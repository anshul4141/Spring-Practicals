package com.rays.ctl;

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
@RequestMapping("Role")
public class RoleCtl {

	@Autowired
	private RoleService roleService;

	@PostMapping("/save")
	public ORSResponse save(@RequestBody RoleForm form) {

		ORSResponse res = new ORSResponse();

		RoleDTO dto = (RoleDTO) form.getDto();

		roleService.add(dto);

		res.addMessage("recored saves successfully");
		res.addData(dto);
		res.setSuccess(true);

		return res;

	}

	@PostMapping("/update")
	public ORSResponse update(@RequestBody RoleForm form) {

		ORSResponse res = new ORSResponse();

		RoleDTO dto = (RoleDTO) form.getDto();

		roleService.update(dto);
		res.addMessage("recored update successfully");
		res.addData(dto);
		res.setSuccess(true);

		return res;

	}

	@PostMapping("/delete/{ids}")
	public ORSResponse update(@PathVariable long[] ids) {

		ORSResponse res = new ORSResponse();

		for (long id : ids) {
			roleService.delete(id);
			res.addMessage("role deleted successfully");
			res.setSuccess(true);
		}

		return res;

	}

	@GetMapping("/get/{id}")
	public ORSResponse get(@PathVariable long id) {

		ORSResponse res = new ORSResponse();

		RoleDTO dto = roleService.findByPk(id);

		if (dto != null) {
			res.addData(dto);
			res.setSuccess(true);
		} else {
			res.addMessage("record not found");
			res.setSuccess(false);

		}

		return res;

	}

}
