package com.rays.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestPerson {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

		Person p = context.getBean("person", Person.class);

		p.setName("Ram");
		p.setAddress("Indore");

		System.out.println(p.getName());
		System.out.println(p.getAddress());
		
		p.setName("Shyam");
		p.setAddress("Bhopal");

		System.out.println(p.getName());
		System.out.println(p.getAddress());

	}

}
