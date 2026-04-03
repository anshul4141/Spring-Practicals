package com.rays.ioc;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class TestOrder2 {

	public static void main(String[] args) {

		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("Order2.xml"));

		Order2 order2 = (Order2) factory.getBean("order2");

		order2.bookATicket(10);

	}

}
