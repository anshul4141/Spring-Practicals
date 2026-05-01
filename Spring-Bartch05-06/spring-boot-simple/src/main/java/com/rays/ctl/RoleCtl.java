package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.ORSResponse;
import com.rays.dto.RoleDTO;
import com.rays.form.RoleForm;
import com.rays.service.RoleService;

@RestController
@RequestMapping(value = "Role")
public class RoleCtl {

	@Autowired
	RoleService roleService;

	@PostMapping("save")
	public ORSResponse save(@RequestBody RoleForm form) {

		ORSResponse res = new ORSResponse();

		RoleDTO dto = new RoleDTO();

		dto.setName(form.getName());
		dto.setDescription(form.getDescription());

		long id = roleService.add(dto);
		// long id = 0;

		if (id != 0 && id > 0) {
			res.setSuccess(true);
			res.addData(dto);
			res.addMessage("role saved successfulluy");
		} else {
			res.addMessage("erorr in role save");
		}

		return res;
	}

	@PostMapping("update")
	public ORSResponse update(@RequestBody RoleForm form) {

		ORSResponse res = new ORSResponse();

		RoleDTO dto = new RoleDTO();

		dto.setId(form.getId());
		dto.setName(form.getName());
		dto.setDescription(form.getDescription());

		roleService.update(dto);

		res.setSuccess(true);
		res.addData(dto);
		res.addMessage("role updated successfulluy");

		return res;
	}

	@PostMapping("delete/{ids}")
	public ORSResponse delete(@PathVariable(required = false) long[] ids) {

		ORSResponse res = new ORSResponse();

		if (ids != null && ids.length > 0) {
			for (long id : ids) {
				roleService.delete(id);
				res.addMessage("recored deleted successfully");
				res.setSuccess(true);
			}
		} else {
			res.addMessage("select at least one record");
		}
		return res;

	}

	@GetMapping("get/{id}")
	public ORSResponse get(@PathVariable(required = false) long id) {

		ORSResponse res = new ORSResponse();

		RoleDTO dto = roleService.findById(id);

		if (dto != null) {
			res.addData(dto);
			res.setSuccess(true);
		} else {
			res.addMessage("record not found");
		}

		return res;

	}

	@GetMapping("search/{pageNo}")
	public ORSResponse search(@PathVariable(required = false) int pageNo) {

		int pageSize = 5;

		ORSResponse res = new ORSResponse();

		RoleDTO dto = new RoleDTO();

		List<RoleDTO> list = roleService.search(dto, pageNo, pageSize);

		if (list != null) {
			res.addData(list);
			res.setSuccess(true);
		} else {
			res.addMessage("record not found");
		}

		return res;

	}

}
