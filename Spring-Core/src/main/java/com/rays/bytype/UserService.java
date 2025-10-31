package com.rays.bytype;

public class UserService {

	private UserDAOInt userDaoInt;

	public void setUserDaoInt(UserDAOInt userDaoInt) {
		this.userDaoInt = userDaoInt;
	}

	public void testAdd() {
		userDaoInt.add();
	}
}