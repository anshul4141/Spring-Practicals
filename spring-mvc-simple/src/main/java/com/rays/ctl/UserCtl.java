package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rays.dto.UserDTO;
import com.rays.form.UserForm;
import com.rays.service.UserServiceInt;

@Controller
@RequestMapping(value = "User")
public class UserCtl {

	@Autowired
	public UserServiceInt service;

	@GetMapping
	public String display(@ModelAttribute("form") UserForm form, @RequestParam(required = false) Long id) {

		if (id != null && id > 0) {
			UserDTO dto = service.findByPk(id);
			form.setId(dto.getId());
			form.setFirstName(dto.getFirstName());
			form.setLastName(dto.getLastName());
			form.setLogin(dto.getLogin());
			form.setPassword(dto.getPassword());
			form.setAddress(dto.getAddress());
		}

		return "UserView";
	}

	@PostMapping
	public String submit(@ModelAttribute("form") UserForm form, Model model) {

		UserDTO dto = new UserDTO();
		dto.setId(form.getId());
		dto.setFirstName(form.getFirstName());
		dto.setLastName(form.getLastName());
		dto.setLogin(form.getLogin());
		dto.setPassword(form.getPassword());
		dto.setAddress(form.getAddress());

		if (form.getId() > 0) {
			service.update(dto);
			model.addAttribute("successMsg", "record updated successfully");
		} else {
			service.add(dto);
			model.addAttribute("successMsg", "record added successfully");
		}
		return "UserView";
	}

	@GetMapping("search")
	public String display(@ModelAttribute("form") UserForm form, Model model) {

		int pageNo = 1;
		int pageSize = 5;

		List list = service.search(null, pageNo, pageSize);

		form.setPageNo(pageNo);

		model.addAttribute("list", list);

		return "UserListView";

	}

	@PostMapping("search")
	public String display(@ModelAttribute("form") UserForm form, @RequestParam(required = false) String operation,
			Model model) {

		UserDTO dto = null;

		int pageNo = 1;
		int pageSize = 5;
		System.out.println("op =====> " + operation);
		if (operation != null && operation.equals("next")) {
			pageNo = form.getPageNo();
			pageNo++;
		}

		if (operation != null && operation.equals("previous")) {
			pageNo = form.getPageNo();
			pageNo--;
		}

		if (operation != null && operation.equals("search")) {
			dto = new UserDTO();
			dto.setId(form.getId());
			dto.setFirstName(form.getFirstName());
		}

		if (operation != null && operation.equals("delete")) {
			if (form.getIds() != null && form.getIds().length > 0) {
				for (long id : form.getIds()) {
					service.delete(id);
					model.addAttribute("successMsg", "record deleted successfully");
				}
			} else {
				model.addAttribute("errorMsg", "select at least one record");
			}
		}

		form.setPageNo(pageNo);

		List list = service.search(dto, pageNo, pageSize);

		model.addAttribute("list", list);

		return "UserListView";

	}
}
