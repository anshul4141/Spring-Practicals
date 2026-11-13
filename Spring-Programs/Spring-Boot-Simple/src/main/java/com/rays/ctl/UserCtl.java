package com.rays.ctl;

import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.AttachmentDTO;
import com.rays.dto.UserDTO;
import com.rays.form.UserForm;
import com.rays.service.AttachmentService;
import com.rays.service.UserService;

@RestController
@RequestMapping(value = "User")
public class UserCtl extends BaseCtl {

	@Autowired
	private UserService userService;

	@Autowired
	private AttachmentService attachmentService;

	@PostMapping("save")
	public ORSResponse save(@RequestBody @Valid UserForm form, BindingResult bindingResult) {

		ORSResponse res = new ORSResponse();

		res = validate(bindingResult);
		if (res.isSuccess() == false) {
			return res;
		}

		UserDTO dto = (UserDTO) form.getDto();

		try {
			if (dto.getId() != null && dto.getId() > 0) {
				userService.update(dto);
				res.addMessage("user updated successfully");
				res.addData(dto);
			} else {
				userService.add(dto);
				res.addMessage("user added successfully");
				res.addData(dto);
			}
		} catch (Exception e) {
			res.setSuccess(false);
			res.addMessage(e.getMessage());
		}

		return res;

	}

	@GetMapping("delete/{ids}")
	public ORSResponse save(@PathVariable long[] ids) {

		ORSResponse res = new ORSResponse();

		for (long id : ids) {
			userService.delete(id);
			res.setSuccess(true);
			res.addMessage("record deleted successfully");
		}

		return res;

	}

	@GetMapping("get/{id}")
	public ORSResponse save(@PathVariable long id) {

		ORSResponse res = new ORSResponse();

		UserDTO dto = userService.findByPk(id);

		if (dto != null) {
			res.addData(dto);
			res.setSuccess(true);
		} else {
			res.addMessage("record not found");
		}

		return res;

	}

	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST }, value = "/search/{pageNo}")
	public ORSResponse search(@RequestBody UserForm form, @PathVariable int pageNo) {

		ORSResponse res = new ORSResponse();

		int pageSize = 5;

		UserDTO dto = (UserDTO) form.getDto();

		List<UserDTO> list = userService.search(dto, pageNo, pageSize);

		if (list != null) {
			res.addData(list);
			res.setSuccess(true);
		} else {
			res.addMessage("record not found");
		}

		return res;

	}

	@PostMapping("/profilePic/{userId}")
	public ORSResponse uploadPic(@PathVariable Long userId, @RequestParam("file") MultipartFile file) {
		
		AttachmentDTO attachmentDto = new AttachmentDTO(file);
		
		attachmentDto.setDescription("profile pic");
		
		attachmentDto.setUserId(userId);
		
		UserDTO userDto = userService.findByPk(userId);
		
		if (userDto.getImageId() != null && userDto.getImageId() > 0) {
			attachmentDto.setId(userDto.getImageId());
		}
		
		Long imageId = attachmentService.save(attachmentDto);
		
		if (userDto.getImageId() == null) {
			userDto.setImageId(imageId);
			userService.update(userDto);
		}
		
		ORSResponse res = new ORSResponse();
		
		res.addResult("imageId", imageId);
		
		res.setSuccess(true);
		
		return res;
	}

	@GetMapping("/profilePic/{userId}")
	public void downloadPic(@PathVariable Long userId, HttpServletResponse response) {
		try {
			UserDTO userDto = userService.findByPk(userId);
			AttachmentDTO attachmentDTO = null;
			if (userDto != null) {
				attachmentDTO = attachmentService.findById(userDto.getImageId());
			}
			if (attachmentDTO != null) {
				response.setContentType(attachmentDTO.getType());
				OutputStream out = response.getOutputStream();
				out.write(attachmentDTO.getDoc());
				out.close();
			} else {
				response.setContentType("application/json");
				response.getWriter().write("ERROR: File not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
