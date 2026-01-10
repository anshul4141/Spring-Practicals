package com.rays.autowire.bynotype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAutowireNoType {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("autowire-no-type.xml");

		UserService userService = context.getBean("userService", UserService.class);

		userService.testAdd();

	}

}
