package com.rays.ctl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestCtl {

	@GetMapping
	public Map get() {
		Map m = new HashMap();
		m.put("getMsg", "get method...");
		return m;
	}

	@PostMapping
	public Map submit() {
		Map m = new HashMap();
		m.put("postMsg", "post method...");
		return m;
	}

	@GetMapping("/search")
	public Map search() {
		Map m = new HashMap();
		m.put("firstName", "Ram");
		m.put("lastName", "Sahrma");
		return m;
	}

	@PostMapping("/save")
	public Map save() {
		Map m = new HashMap();
		m.put("msg", "record saved successfully");
		return m;
	}

}
