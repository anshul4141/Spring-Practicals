package com.rays.autowiring.bytype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAutoWireByType {
	
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("autowiringByType.xml");

		Order o = context.getBean("order", Order.class);
		
		o.placedOrder(3);

	}

}
