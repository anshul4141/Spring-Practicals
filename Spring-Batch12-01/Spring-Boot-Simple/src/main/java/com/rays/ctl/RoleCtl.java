package com.rays.ctl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.dto.RoleDTO;
import com.rays.form.RoleForm;
import com.rays.service.RoleService;

@RestController
@RequestMapping("Role")
public class RoleCtl {

	@Autowired
	private RoleService roleService;

	@PostMapping("/save")
	public Map save(@RequestBody RoleForm form) {

		Map m = new HashMap();

		RoleDTO dto = (RoleDTO) form.getDto();

		roleService.add(dto);
		m.put("msg", "role add successfully");
		m.put("data", dto);

		return m;

	}

	@PostMapping("/update")
	public Map update(@RequestBody RoleForm form) {

		Map m = new HashMap();

		RoleDTO dto = (RoleDTO) form.getDto();

		roleService.update(dto);
		m.put("msg", "role update successfully");

		return m;

	}

	@PostMapping("/delete/{ids}")
	public Map update(@PathVariable long[] ids) {

		Map m = new HashMap();

		for (long id : ids) {
			roleService.delete(id);
			m.put("msg", "role deleted successfully");
		}

		return m;

	}

	@GetMapping("/get/{id}")
	public Map get(@PathVariable long id) {

		Map m = new HashMap();

		RoleDTO dto = roleService.findByPk(id);

		if (dto != null) {
			m.put("data", dto);
		} else {
			m.put("msg", "record not found");

		}

		return m;

	}

}
