package com.rays.child.annotation;

import org.springframework.stereotype.Component;

@Component("person")
public class Person {

	private String name = "parent";
	private int age = 100;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}
}
