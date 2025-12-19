package com.rays.annotation;

import org.springframework.stereotype.Component;

@Component
public class UserDAOImpl implements UserDAOInt {

	public void add() {
		System.out.println("add method: autowire annotation");
	}

}
