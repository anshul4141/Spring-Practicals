package com.rays.byconstructor;

public class UserService {

	private UserDAOInt userDaoInt;

	public UserService(UserDAOInt userDaoInt) {
		this.userDaoInt = userDaoInt;
	}

	public void testAdd() {
		userDaoInt.add();
	}
}