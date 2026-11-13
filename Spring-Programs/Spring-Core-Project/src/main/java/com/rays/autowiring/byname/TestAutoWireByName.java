package com.rays.autowiring.byname;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAutoWireByName {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("autowiringByName.xml");

		Order o = context.getBean("order", Order.class);
		
		o.placedOrder(3);

	}

}
