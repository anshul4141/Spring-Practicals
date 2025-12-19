package com.rays.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestPerson {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("person-annotation.xml");

		Person person = (Person) context.getBean("person");

		System.out.println("Person's name: " + person.getName());
		System.out.println("Person's address: " + person.getAddress());
	}
}