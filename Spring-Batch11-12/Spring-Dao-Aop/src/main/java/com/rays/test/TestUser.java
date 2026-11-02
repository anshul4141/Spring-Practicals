package com.rays.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.rays.dto.UserDTO;
import com.rays.service.UserService;

@Component("test")
public class TestUser {

	@Autowired
	private UserService service;

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		TestUser test = context.getBean("test", TestUser.class);

		test.testAdd();
	}

	public void testAdd() {

		UserDTO dto = new UserDTO();

		dto.setFirstName("Tanisha");
		dto.setLastName("Rambadia");
		dto.setLogin("tanisha@gmail.com");
		dto.setPassword("tanisha123");

		int id = service.add(dto);

		System.out.println("User added with ID: " + id);
	}

}