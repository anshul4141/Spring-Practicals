package com.rays.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class TestUser {

	public static void main(String[] args) {

		BeanFactory fectory = new XmlBeanFactory(new ClassPathResource("user.xml"));

		User dto = (User) fectory.getBean("user");

		System.out.println(dto.getName());
		System.out.println(dto.getAddress());

		System.out.println("------------------");

		dto = (User) fectory.getBean("user1");

		System.out.println(dto.getName());
		System.out.println(dto.getAddress());
		
		System.out.println("------------------");

		dto = (User) fectory.getBean("user2");

		System.out.println(dto.getName());
		System.out.println(dto.getAddress());
	}

}
