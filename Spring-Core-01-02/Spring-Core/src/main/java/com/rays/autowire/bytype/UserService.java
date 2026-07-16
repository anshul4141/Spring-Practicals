package com.rays.autowire.bytype;

public class UserService {

	private UserDAOInt userDao;

	public void setUserDao(UserDAOInt userDao) {
		this.userDao = userDao;
	}

	public void add() {
		userDao.add();
	}

}
