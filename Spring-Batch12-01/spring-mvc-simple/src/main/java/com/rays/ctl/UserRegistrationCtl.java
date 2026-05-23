package com.rays.ctl;

import java.text.SimpleDateFormat;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rays.dto.UserDTO;
import com.rays.form.UserRegistrationForm;
import com.rays.service.UserService;

@Controller
@RequestMapping(value = "register")
public class UserRegistrationCtl {

	@Autowired
	UserService service;

	@GetMapping
	public String display(@ModelAttribute("form") UserRegistrationForm form) {
		return "UserRegistrationView"; // return prefix
	}

	@PostMapping
	public String register(@ModelAttribute("form") @Valid UserRegistrationForm form, BindingResult bindingResult,
			Model model) throws Exception {

		if (bindingResult.hasErrors()) {
			return "UserRegistrationView";
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
		model.addAttribute("msg", "user registration successfully");

		return "UserRegistrationView";

	}

}
