package com.rays.child.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestChild {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		Person person = (Person) context.getBean("person");

		System.out.println("name: " + person.getName());
		System.out.println("age: " + person.getAge());
	}
}
