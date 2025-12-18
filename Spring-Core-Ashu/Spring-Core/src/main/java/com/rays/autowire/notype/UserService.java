package com.rays.autowire.notype;

public class UserService {

	private UserDAOInt userDao;

	public void setUserDao(UserDAOInt userDao) {
		this.userDao = userDao;
	}

	public void testAdd() {
		userDao.add();
	}
}