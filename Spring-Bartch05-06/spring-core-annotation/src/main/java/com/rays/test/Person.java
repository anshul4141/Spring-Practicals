package com.rays.test;

import org.springframework.stereotype.Component;

//Person person = new Person();
@Component // <bean id="person" class="com.rays.test.Person"></bean>
public class Person {

	//@Value("Ram")
	private String name;

	//@Value("Indore")
	private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
