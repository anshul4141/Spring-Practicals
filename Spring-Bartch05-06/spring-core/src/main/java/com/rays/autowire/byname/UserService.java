package com.rays.autowire.byname;

public class UserService {

	private UserDAOInt userDao;

	// by property name
	public void setUserDao(UserDAOInt userDao) {
		this.userDao = userDao;
	}

	public void testAdd() {
		userDao.add();
	}
}
