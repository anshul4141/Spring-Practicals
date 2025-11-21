package com.rays.ctl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.RoleDTO;
import com.rays.form.RoleForm;
import com.rays.service.RoleService;

@RestController
@RequestMapping(value = "Role")
public class RoleCtl extends BaseCtl {

	@Autowired
	public RoleService roleService;

	@PostMapping("save")
	public ORSResponse save(@RequestBody @Valid RoleForm form, BindingResult bindingResult) {

		ORSResponse res = validate(bindingResult);

		if (!res.isSuccess()) {
			return res;
		}

		RoleDTO dto = (RoleDTO) form.getDto();

		long pk = roleService.add(dto);

		res.addData(pk);
		res.addMessage("Role addedd successfully..!!!");

		return res;

	}
	
	@PostMapping("update")
	public ORSResponse update(@RequestBody @Valid RoleForm form, BindingResult bindingResult) {

		ORSResponse res = validate(bindingResult);

		if (!res.isSuccess()) {
			return res;
		}

		RoleDTO dto = (RoleDTO) form.getDto();

		roleService.update(dto);

		res.addMessage("Role update successfully..!!!");

		return res;

	}

}