package com.rays.ctl;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rays.dto.UserDTO;
import com.rays.form.UserForm;
import com.rays.service.UserService;

@Controller
@RequestMapping(value = "user")
public class UserCtl {

	@Autowired
	UserService service;

	@GetMapping
	public String display(@ModelAttribute("form") UserForm form) {
		return "UserView"; // return prefix
	}

	@PostMapping
	public String save(@ModelAttribute("form") @Valid UserForm form, BindingResult bindingResult, Model model)
			throws Exception {

		if (bindingResult.hasErrors()) {
			return "UserView";
		}

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserDTO dto = new UserDTO();

		dto.setFirstName(form.getFirstName());
		dto.setLastName(form.getLastName());
		dto.setLogin(form.getLogin());
		dto.setPassword(form.getPassword());
		dto.setDob(sdf.parse(form.getDob()));
		dto.setAddress(form.getAddress());

		service.add(dto);
		model.addAttribute("msg", "user saved successfully successfully");

		return "UserView";

	}

	@GetMapping("/search")
	public String search(@ModelAttribute("form") UserForm form, Model model) {

		List<UserDTO> list = service.search(null, 1, 5);

		model.addAttribute("list", list);

		return "UserListView";

	}

	@PostMapping("search")
	public String search(@ModelAttribute("form") UserForm form, @RequestParam(required = false) String operation,
			Model model) {

		UserDTO dto = null;

		int pageNo = 1;
		int pageSize = 5;

		if (operation.equals("next")) {
			pageNo++;
		}

		if (operation.equals("previous")) {
			pageNo--;
		}

		if (operation.equals("delete")) {
			if (form.getIds() != null && form.getIds().length > 0) {
				for (long id : form.getIds()) {
					service.delete(id);
					model.addAttribute("msg", "records deleted successfully");
				}
			} else {
				model.addAttribute("msg", "select at least one or more records");
			}
		}

		form.setPageNo(pageNo);
		List list = service.search(dto, pageNo, pageSize);

		model.addAttribute("list", list);

		return "UserListView";
	}

}
