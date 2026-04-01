package com.rays.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class TestUserBean {

	public static void main(String[] args) {

		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("user.xml"));

		UserBean user = (UserBean) factory.getBean("user");

		System.out.println(user.getName());
		System.out.println(user.getAddress());

		System.out.println("-------------");

		UserBean user1 = (UserBean) factory.getBean("user1");

		System.out.println(user1.getName());
		System.out.println(user1.getAddress());
	}

}
