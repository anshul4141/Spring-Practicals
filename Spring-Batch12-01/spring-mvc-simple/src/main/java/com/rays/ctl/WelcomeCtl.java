package com.rays.ctl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "Welcome")
public class WelcomeCtl {

	@GetMapping
	public String display(Model model) {
		System.out.println("display");
		model.addAttribute("message", "Welcome to Spring MVC..!!");
		return "Welcome";
	}

	@GetMapping("first")
	public String display1(Model model) {
		System.out.println("display1");
		model.addAttribute("message", "Welcome to Spring MVC..!!");
		return "Welcome";
	}

	@GetMapping("second")
	public String display2(Model model) {
		System.out.println("display2");
		model.addAttribute("message", "Welcome to Spring MVC..!!");
		return "Welcome";
	}

}