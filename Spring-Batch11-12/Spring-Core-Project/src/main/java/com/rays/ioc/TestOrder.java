package com.rays.ioc;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class TestOrder {

	public static void main(String[] args) {

		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("order.xml"));

		Order o = factory.getBean("order", Order.class);

		o.placedOrder(3);

	}

}
