package com.rays.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class TestPerson {

	public static void main(String[] args) {

		BeanFactory fectory = new XmlBeanFactory(new ClassPathResource("person.xml"));

		// Person p = (Person) fectory.getBean("person");
		Person p = fectory.getBean("person", Person.class);

		System.out.println(p.getName());
		System.out.println(p.getAddress());


	}

}
