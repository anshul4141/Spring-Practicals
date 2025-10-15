package com.rays.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestPerson1 {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("Multi.xml");
		
		Person p = context.getBean("person", Person.class);
		
		System.out.println(p.getName());
		System.out.println(p.getAddress());
		
		Employee e = context.getBean("employee", Employee.class);
		
		System.out.println(e.getEmpName());
		System.out.println(e.getSalary());

	}

}
