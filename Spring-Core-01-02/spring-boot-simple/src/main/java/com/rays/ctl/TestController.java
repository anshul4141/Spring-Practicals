package com.rays.ctl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "Test")
public class TestController {

	@GetMapping
	public String display() {
		return "this is display method";
	}

	@PostMapping
	public String submit() {
		return "this is submit method";
	}

	@GetMapping("get")
	public String get() {
		return "this is get endpoint";
	}

	@PostMapping("save")
	public String save() {
		return "this is post endpoint";
	}

}
