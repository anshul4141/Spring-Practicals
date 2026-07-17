package com.rays.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rays.AppConfig;

public class TestPerson {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

//		ApplicationContext context = new ClassPathXmlApplicationContext("AppConfig.xml");

		Person p = context.getBean("p", Person.class);

		p.setName("Shyam");
		p.setAddress("Indore");

		System.out.println(p.getName());
		System.out.println(p.getAddress());

	}

}
