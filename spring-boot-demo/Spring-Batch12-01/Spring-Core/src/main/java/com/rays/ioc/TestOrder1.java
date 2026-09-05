package com.rays.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestOrder1 {

	public static void main(String[] args) {

//		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("Order.xml"));

		ApplicationContext context = new ClassPathXmlApplicationContext("Order.xml");

		Order1 order = context.getBean("order1", Order1.class);

		order.bookATicket(5);

	}

}
