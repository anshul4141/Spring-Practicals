package com.rays.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestPerson {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

		Person p = (Person) context.getBean("person");

		p.setName("Ram");
		p.setAddress("Indore");
		System.out.println(p.getName());
		System.out.println(p.getAddress());

		System.out.println("----------------");

		Person p1 = (Person) context.getBean("person");

		p1.setName("Shyam");
		p1.setAddress("Bhopal");
		System.out.println(p1.getName());
		System.out.println(p1.getAddress());

	}

}
