package com.rays.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.rays.dto.UserDTO;
import com.rays.service.UserService;

@Component("testUserService")
public class TestUserService {

	@Autowired
	public UserService service = null;

	public static void main(String[] args) throws Exception {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		TestUserService test = (TestUserService) context.getBean("testUserService");

//		test.testAdd();
		test.testDelete();

	}

	private void testDelete() {
		UserDTO dto = new UserDTO();

		dto.setId(1);

		service.delete(dto);

		System.out.println("record deleted");

	}

	public void testAdd() {
		UserDTO dto = new UserDTO();
		dto.setFirstName("abc");
		dto.setLastName("abc");
		dto.setLogin("abc@gmail.com");
		dto.setPassword("abc123");
		long i = service.add(dto);
		System.out.println("Data Inserted... = " + i);
	}

}