package com.rays.autowire.bytype;

public class UserService {

	private UserDAOInt userDao;

	public void setuserdao(UserDAOInt userDao) {
		this.userDao = userDao;
	}

	public void testAdd() {
		userDao.add();
	}
}