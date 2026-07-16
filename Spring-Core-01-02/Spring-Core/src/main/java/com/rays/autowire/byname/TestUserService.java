package com.rays.autowire.byname;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserService {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("autowireByName.xml");

		UserService service = context.getBean("userService", UserService.class);

		service.add();

	}

}
