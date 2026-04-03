package com.rays.ioc;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class TestOrder1 {

	public static void main(String[] args) {

		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("Order1.xml"));

		Order1 order1 = (Order1) factory.getBean("order1");

		order1.bookATicket(5);

	}

}
