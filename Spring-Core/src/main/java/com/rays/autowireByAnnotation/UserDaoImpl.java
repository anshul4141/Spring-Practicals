package com.rays.autowireByAnnotation;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDaoInt {

	public void add() {

		System.out.println("add method.....");

	}

}
