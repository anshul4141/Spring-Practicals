package com.rays.autowire.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAutowireByAnnotation {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

//		UserServiceByName userService = (UserServiceByName) context.getBean("userServiceByName");
		
//		UserServiceBySetter userService = (UserServiceBySetter) context.getBean("userServiceBySetter");
//		UserServiceByConstructor userService = (UserServiceByConstructor) context.getBean("userServiceByConstructor");
		UserServiceByType userService = (UserServiceByType) context.getBean("userServiceByType");

		userService.testAdd();

	}
}
