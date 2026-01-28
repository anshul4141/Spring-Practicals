package com.rays.ctl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "Test")
public class TestCtl {

	@GetMapping
	public String display() {
		return "display method....";
	}

	@PostMapping
	public String submit() {
		return "submit method....";
	}

}
