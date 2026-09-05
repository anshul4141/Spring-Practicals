package com.rays.ioc;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class TestOrder {

	public static void main(String[] args) {

//		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("Order.xml"));

		ApplicationContext context = new ClassPathXmlApplicationContext("Order.xml");

		Order order = context.getBean("order", Order.class);

		order.bookATicket(5);

	}

}
