package com.rays.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class TestPerson {

	public static void main(String[] args) {

		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("person.xml"));

		Person p = factory.getBean("person", Person.class);
		// Person p = (Person) factory.getBean("person");

		System.out.println("person's name: " + p.getName());
		System.out.println("person's address: " + p.getAddress());
		
		System.out.println("------------------");
		
		BeanFactory factory1 = new XmlBeanFactory(new ClassPathResource("person.xml"));
		
		Person p1 = factory.getBean("person1", Person.class);
		
		System.out.println("person's name: " + p1.getName());
		System.out.println("person's address: " + p1.getAddress());

	}

}
