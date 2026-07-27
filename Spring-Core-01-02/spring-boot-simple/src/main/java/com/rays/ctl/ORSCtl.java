package com.rays.ctl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.ORSResponse;
import com.rays.dto.TestDTO;

@RestController
@RequestMapping(value = "Ors")
public class ORSCtl {

	@GetMapping
	public ORSResponse getOrs() {

		ORSResponse res = new ORSResponse();

		res.addMessage("invalid login or password");
		//res.setSuccess(true);

		return res;

	}
	
	@GetMapping("getDto")
	public ORSResponse getDto() {

		ORSResponse res = new ORSResponse();

		TestDTO dto = new TestDTO();
		
		dto.setFirstName("Ram");
		dto.setLastName("Sharma");
		dto.setLogin("ram@gmail.com");
		dto.setPassword("pass123");

		res.addData(dto);
		
		return res;

	}

}
