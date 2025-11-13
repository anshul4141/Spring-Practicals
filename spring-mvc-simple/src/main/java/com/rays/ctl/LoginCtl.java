package com.rays.ctl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rays.dto.UserDTO;
import com.rays.form.LoginForm;
import com.rays.service.UserServiceInt;

@Controller
@RequestMapping(value = "Login")
public class LoginCtl {

	@Autowired
	public UserServiceInt service;

	@GetMapping
	public String display(@ModelAttribute("form") LoginForm form, @RequestParam(required = false) String operation,
			HttpSession session, Model model) {

		if (operation != null && operation.equals("logout")) {
			session.invalidate();
			model.addAttribute("successMsg", "user logout successfully");
			return "LoginView";
		}

		return "LoginView";
	}

	@PostMapping
	public String submit(@ModelAttribute("form") LoginForm form, @RequestParam(required = false) String operation,
			HttpSession session) {

		if (operation.equals("signUp")) {
			return "redirect:Register";
		}

		UserDTO dto = service.authenticate(form.getLogin(), form.getPassword());

		if (dto != null) {
			session.setAttribute("user", dto);
			return "redirect:WelcomeCtl";
		}
		return "LoginView";
	}

}
