package com.rays.autowire.byname;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class TestOrder {

	public static void main(String[] args) {

		BeanFactory fectory = new XmlBeanFactory(new ClassPathResource("autoWireByName.xml"));

		Order o = (Order) fectory.getBean("order");

		o.makeOrder(3);

	}

}
