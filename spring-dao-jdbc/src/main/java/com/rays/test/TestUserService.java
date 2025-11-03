package com.rays.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.rays.dto.UserDTO;
import com.rays.service.UserServiceInt;

@Component("testUserService")
public class TestUserService {

	@Autowired
	public UserServiceInt service = null;

	public static void main(String[] args) throws Exception {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		TestUserService test = (TestUserService) context.getBean("testUserService");

		test.testAdd();

	}

	public void testAdd() {
		UserDTO dto = new UserDTO();
		dto.setId(1);
		dto.setFirstName("xyz");
		dto.setLastName("xyz");
		dto.setLogin("admin");
		dto.setPassword("pass1234");
		long pk = service.add(dto);
		System.out.println("Data Inserted... pk = " + pk);
	}

}
