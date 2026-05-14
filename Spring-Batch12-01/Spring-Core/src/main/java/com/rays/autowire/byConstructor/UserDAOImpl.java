package com.rays.autowire.byConstructor;

public class UserDAOImpl implements UserDAOInt {

	@Override
	public void add() {
		System.out.println("add method..!");
	}
}