package com.rays.ctl;

import java.util.List;

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
	UserServiceInt userService;
	
	@GetMapping
	public String display() {
		return "UserView";
	}

	@GetMapping("search")
	public String search(Model model) {

		List list = userService.search(null, 0, 0);
		System.out.println("list size ====> " + list.size());
		model.addAttribute("list", list);

		return "UserListView";
	}

}
