package com.rays.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//Ye example Spring Bean ke life cycle ko dikhata hai:
//init-method → bean banne ke baad chalti hai
//destroy-method → context close hone par chalti hai
public class TestLifeCycle {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("lifecycle.xml");

		MyBean myBean = (MyBean) context.getBean("myBean");

		//myBean.service();

		((ClassPathXmlApplicationContext) context).close();
	}
}