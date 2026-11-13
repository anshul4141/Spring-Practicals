package com.rays.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestLifeCycle {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("myBean.xml");

		MyBean myBean = context.getBean("myBean", MyBean.class);
		System.out.println("------------");
		((ClassPathXmlApplicationContext) context).close();

	}

}
