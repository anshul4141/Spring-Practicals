package com.rays.autowire.bytype;

public class UserDAOHibImpl implements UserDAOInt {

	@Override
	public void add() {
		System.out.println("add method...");
	}

}
