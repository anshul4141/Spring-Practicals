package com.rays.autowire.bytype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserService {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("autowireByType.xml");

		UserService service = context.getBean("userService", UserService.class);

		service.add();

	}

}
