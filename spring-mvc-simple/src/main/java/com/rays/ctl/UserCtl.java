package com.rays.ctl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rays.service.UserServiceInt;

@Controller
@RequestMapping(value = "User")
public class UserCtl {

	@Autowired
	public UserServiceInt service;

	@GetMapping
	public String display() {
		return "UserView";
	}

	@GetMapping("search")
	public String display(Model model) {
		model.addAttribute("message", "User list");
		return "UserListView";

	}
}
