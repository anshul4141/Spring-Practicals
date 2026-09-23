package com.rays.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.rays.dto.UserDTO;
import com.rays.service.UserService;

@Component("testUser")
public class TestUser {

	@Autowired
	UserService service;

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		TestUser test = context.getBean("testUser", TestUser.class);

//		test.testAdd();
//		test.testUpdate();
//		test.testFindPk();
		test.testFindByLogin();
		test.testAuthenticate();
		test.testSearch();

	}

	private void testFindPk() {

		UserDTO dto = service.findByPk(1);

		System.out.println(dto.getId());
		System.out.println(dto.getFirstName());
		System.out.println(dto.getLastName());
		System.out.println(dto.getLogin());
		System.out.println(dto.getPassword());

	}

	private void testAdd() {

		UserDTO dto = new UserDTO();

		dto.setId(1);
		dto.setFirstName("Harshit");
		dto.setLastName("Panchal");
		dto.setLogin("harshit@gmail.com");
		dto.setPassword("pass123");

		int id = service.add(dto);

		System.out.println("data inserted successfully at id: " + id);

	}

	private void testUpdate() {

		UserDTO dto = new UserDTO();

		dto.setId(1);
		dto.setFirstName("Harshit");
		dto.setLastName("Sharma");
		dto.setLogin("harshit@gmail.com");
		dto.setPassword("pass123");

		service.update(dto);

	}

}
