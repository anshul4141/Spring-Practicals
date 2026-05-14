package com.rays.autowire.byType;

public class UserDAOImpl implements UserDAOInt {

	@Override
	public void add() {
		System.out.println("add method..!");
	}

}
