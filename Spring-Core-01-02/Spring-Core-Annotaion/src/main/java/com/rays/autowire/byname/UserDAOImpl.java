package com.rays.autowire.byname;

import org.springframework.stereotype.Component;

@Component("pp")
public class UserDAOImpl implements UserDAOInt {

	public void add() {
		System.out.println("add method...");
	}

}
