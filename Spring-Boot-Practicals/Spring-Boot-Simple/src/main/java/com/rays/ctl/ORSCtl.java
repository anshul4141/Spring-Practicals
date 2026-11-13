package com.rays.ctl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.ORSResponse;
import com.rays.dto.TestDTO;

@RestController
@RequestMapping(value = "Ors")
public class ORSCtl {

	@GetMapping
	public ORSResponse get() {

		ORSResponse res = new ORSResponse();

		res.addMessage("something went wrong..");

		return res;

	}

	@GetMapping("get")
	public ORSResponse get1() {

		ORSResponse res = new ORSResponse();

		TestDTO dto = new TestDTO();
		dto.setId(1L);
		dto.setFirstName("Ram");
		dto.setLastName("Sharma");
		dto.setLogin("ram@gmail.com");
		dto.setPassword("pass123");

		TestDTO dto1 = new TestDTO();
		dto1.setId(2L);
		dto1.setFirstName("Shyam");
		dto1.setLastName("Yadav");
		dto1.setLogin("shyam@gmail.com");
		dto1.setPassword("pass");

		List<TestDTO> list = new ArrayList<TestDTO>();
		list.add(dto);
		list.add(dto1);

		res.addData(list);
		res.setSuccess(true);

		return res;

	}

	@GetMapping("get1")
	public ORSResponse get2() {

		ORSResponse res = new ORSResponse();

		Map<String, String> errors = new HashMap<String, String>();
		errors.put("firstName", "first name is required");
		errors.put("lastName", "last name is required");
		errors.put("login", "logn is required");
		errors.put("password", "passwrod is required");

		res.addInputError(errors);

		return res;

	}

	@GetMapping("get2")
	public ORSResponse get3() {

		ORSResponse res = new ORSResponse();

		Map<Integer, String> roleList = new HashMap<Integer, String>();
		roleList.put(1, "Admin");
		roleList.put(2, "Student");
		roleList.put(3, "College");
		roleList.put(4, "Faculty");

		res.addResult("roleList", roleList);
		res.setSuccess(true);

		return res;

	}

}
