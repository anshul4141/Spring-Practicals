package com.rays.autowire.annotation;

import org.springframework.stereotype.Repository;

@Repository("userDao") // repository annotation is used to create DAO layer or also create bean
public class UserDAOImpl implements UserDAOInt {

	public void add() {
		System.out.println("add method...!");
	}

}
