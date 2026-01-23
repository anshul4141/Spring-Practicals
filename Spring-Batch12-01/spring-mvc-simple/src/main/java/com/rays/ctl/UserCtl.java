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
import com.rays.service.UserService;
import com.rays.util.DataUtility;

@Controller
@RequestMapping(value = "User")
public class UserCtl {

	@Autowired
	public UserService service;

	@GetMapping
	public String display(@ModelAttribute("form") UserForm form) {
		return "UserView";
	}

	@PostMapping
	public String submit(@ModelAttribute("form") UserForm form) throws Exception {

		UserDTO dto = new UserDTO();
		dto.setId(form.getId());
		dto.setFirstName(form.getFirstName());
		dto.setLastName(form.getLastName());
		dto.setLogin(form.getLogin());
		dto.setPassword(form.getPassword());
		dto.setDob(DataUtility.stringToDate(form.getDob()));
		dto.setAddress(form.getAddress());

		if (form.getId() > 0) {
			service.update(dto);
		} else {
			service.add(dto);
		}
		return "UserView";
	}

	@GetMapping("search")
	public String displayUserList(@ModelAttribute("form") UserForm form, Model model) {

		int pageNo = 1;
		int pageSize = 5;

		List<UserDTO> list = service.search(null, pageNo, pageSize);

		model.addAttribute("list", list);

		return "UserListView";
	}

	@PostMapping("search")
	public String displayUserList(@ModelAttribute("form") UserForm form,
			@RequestParam(required = false) String operation, Model model) {

		UserDTO dto = new UserDTO();

		if (operation.equals("search")) {
			dto.setFirstName(form.getFirstName());
		}

		int pageNo = 1;
		int pageSize = 5;

		List<UserDTO> list = service.search(dto, pageNo, pageSize);

		model.addAttribute("list", list);

		return "UserListView";

	}
}