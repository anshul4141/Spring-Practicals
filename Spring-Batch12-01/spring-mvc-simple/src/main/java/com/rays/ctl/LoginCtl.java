package com.rays.ctl;

import javax.servlet.http.HttpSession;
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
import com.rays.form.LoginForm;
import com.rays.service.UserService;

@Controller
@RequestMapping(value = "login")
public class LoginCtl {

	@Autowired
	UserService service;

	@GetMapping
	public String display(@ModelAttribute("form") LoginForm form, @RequestParam(required = false) String operation,
			HttpSession session, Model model) {

		if (operation != null) {
			session.invalidate();
			model.addAttribute("msg", "logout successfully");
		}

		return "LoginView";
	}

	@PostMapping
	public String login(@ModelAttribute("form") @Valid LoginForm form, BindingResult bindingResult, HttpSession session,
			Model model) {

		if (bindingResult.hasErrors()) {
			return "LoginView";
		}

		UserDTO dto = service.authenticate(form.getLogin(), form.getPassword());

		if (dto != null) {
			session.setAttribute("user", dto);
			return "redirect:/Welcome";
		} else {
			model.addAttribute("msg", "invalid login or passwored");
		}
		return "LoginView";

	}

}
