package com.rays.ioc;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class TestOrder1 {

	public static void main(String[] args) {

		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("Order1.xml"));

		Order o = factory.getBean("order", Order.class);

		o.bookATicket(10);

	}

}
