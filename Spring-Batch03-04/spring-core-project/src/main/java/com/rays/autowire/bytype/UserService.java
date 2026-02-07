package com.rays.autowire.bytype;

public class UserService {

	UserDAOInt userDao;

	public void setUserDaoooooo(UserDAOInt userDao) {
		this.userDao = userDao;
	}

	public void add() {
		userDao.add();
	}

}
