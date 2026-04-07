package com.rays.autowire.bytype;

public class UserService {

	// by property type
	private UserDAOInt userDao;

	public void setUserDaoInt(UserDAOInt userDao) {
		this.userDao = userDao;
	}

	public void testAdd() {
		userDao.add();
	}
}
