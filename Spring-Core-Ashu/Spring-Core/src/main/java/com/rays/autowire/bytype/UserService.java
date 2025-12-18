package com.rays.autowire.bytype;

public class UserService {

	private UserDAOImpl userDao;

	public void setuserdao(UserDAOImpl userDao) {
		this.userDao = userDao;
	}

	public void testAdd() {
		userDao.add();
	}
}