package com.rays.child;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestChild {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("child.xml");

		Person person = (Person) context.getBean("employee");

		System.out.println("employee name: " + person.getName());
		System.out.println("employee age: " + person.getAge());

	}

}
