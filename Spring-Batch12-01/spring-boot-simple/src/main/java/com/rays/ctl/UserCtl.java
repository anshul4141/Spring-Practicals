package com.rays.ctl;

import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
import com.rays.common.DropDownList;
import com.rays.common.ORSResponse;
import com.rays.dto.AttachmentDTO;
import com.rays.dto.UserDTO;
import com.rays.form.UserForm;
import com.rays.service.AttachmentService;
import com.rays.service.RoleService;
import com.rays.service.UserService;

@RestController
@RequestMapping(value = "User")
public class UserCtl extends BaseCtl {

	@Autowired
	UserService userService;

	@Autowired
	RoleService roleService;

	@Autowired
	AttachmentService attachmentService;

	@GetMapping("preload")
	public ORSResponse preload() {
		ORSResponse res = new ORSResponse();
		List<DropDownList> roleList = roleService.search(null, 0, 0);
		res.setSuccess(true);
		res.addResult("roleList", roleList);
		return res;
	}

	@PostMapping("save")
	public ORSResponse save(@RequestBody @Valid UserForm form, BindingResult bindingResult) {

		ORSResponse res = new ORSResponse();

		res = validate(bindingResult);

		if (res.isSuccess() == false) {
			return res;
		}

		UserDTO dto = new UserDTO();

		dto = (UserDTO) form.getDto();

		long i = userService.add(dto);

		if (i != 0) {
			res.addMessage("user added successfully");
			res.addData(dto);
		}

		return res;

	}

	@PostMapping("update")
	public ORSResponse update(@RequestBody @Valid UserForm form, BindingResult bindingResult) {
		ORSResponse res = new ORSResponse();

		res = validate(bindingResult);

		if (res.isSuccess() == false) {
			return res;
		}

		UserDTO dto = new UserDTO();

		dto = (UserDTO) form.getDto();

		userService.update(dto);

		res.setSuccess(true);
		res.addMessage("user update successfully");
		res.addData(dto);

		return res;
	}

	@PostMapping("delete/{ids}")
	public ORSResponse delete(@PathVariable(required = false) long[] ids) {

		ORSResponse res = new ORSResponse();

		if (ids != null && ids.length > 0) {
			for (long id : ids) {
				userService.delete(id);
			}
			res.setSuccess(true);
			res.addMessage("record deleted successfully");
		} else {
			res.addMessage("select at least one record");
		}

		return res;
	}

	@GetMapping("get/{id}")
	public ORSResponse get(@PathVariable(required = false) long id) {

		ORSResponse res = new ORSResponse();

		UserDTO dto = userService.findById(id);

		if (dto != null) {
			res.addData(dto);
			res.setSuccess(true);
		} else {
			res.addMessage("user not found");
		}

		return res;

	}

	@RequestMapping(value = "/search/{pageNo}", method = { RequestMethod.GET, RequestMethod.POST })
	public ORSResponse search(@RequestBody UserForm form, @PathVariable int pageNo) {

		ORSResponse res = new ORSResponse();

		UserDTO dto = (UserDTO) form.getDto();

		List<UserDTO> list = userService.search(dto, pageNo, 5);

		if (list.size() == 0) {
			res.addMessage("Result not found...!!!");
		} else {
			res.setSuccess(true);
			res.addData(list);
		}
		return res;

	}

	@PostMapping("/profilePic/{userId}")
	public ORSResponse uploadPic(@PathVariable Long userId, @RequestParam("file") MultipartFile file,
			HttpServletRequest req) {

		AttachmentDTO attachmentDto = new AttachmentDTO(file);

		attachmentDto.setDescription("profile pic");
		attachmentDto.setUserId(userId);

		UserDTO userDto = userService.findById(userId);

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

			UserDTO userDto = userService.findById(userId);
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
				response.getWriter().write("ERROR: File not found");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
