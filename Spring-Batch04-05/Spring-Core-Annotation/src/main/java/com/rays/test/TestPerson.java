package com.rays.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestPerson {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Person p = context.getBean("person", Person.class);
		
		System.out.println(p.getName());
		System.out.println(p.getAddress());
		
		
	}

}
