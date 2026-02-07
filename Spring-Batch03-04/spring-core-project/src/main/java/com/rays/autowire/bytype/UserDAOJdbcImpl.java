package com.rays.autowire.bytype;

public class UserDAOJdbcImpl implements UserDAOInt {

	@Override
	public void add() {
		System.out.println("add method...jdbc");
	}
}
