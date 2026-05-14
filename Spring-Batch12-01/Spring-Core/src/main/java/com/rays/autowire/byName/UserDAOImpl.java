package com.rays.autowire.byName;

public class UserDAOImpl implements UserDAOInt {

	@Override
	public void add() {
		System.out.println("add method..!");
	}
}
