package com.rays.autowire.bynotype;

public class UserService {

	private UserDAOInt userDao;

	public void setUserDao(UserDAOInt userDao) {
		this.userDao = userDao;
	}

	public void testAdd() {
		userDao.add();
	}

}
