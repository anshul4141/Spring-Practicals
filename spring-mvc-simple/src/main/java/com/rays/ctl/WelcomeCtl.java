package com.rays.ctl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/WelcomeCtl")
public class WelcomeCtl {

	@GetMapping
	public String display(Model model) {
		System.out.println("in display method");
		model.addAttribute("message", "Welcome to Spring MVC!!");
		return "WelcomeView";
	}

}
