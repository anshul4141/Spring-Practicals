package com.rays.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAutowireByAnnotaion {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("person-annotation.xml");

		UserService service = context.getBean("userService", UserService.class);

		service.testAdd();

	}

}
