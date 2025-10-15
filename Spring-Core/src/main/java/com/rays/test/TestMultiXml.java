package com.rays.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class TestMultiXml {

	public static void main(String[] args) {

		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("Multi.xml"));

		Person p = factory.getBean("person", Person.class);
		
		System.out.println(p.getName());
		System.out.println(p.getAddress());
		
		Employee e = factory.getBean("employee", Employee.class);
		
		System.out.println(e.getEmpName());
		System.out.println(e.getSalary());

	}

}
