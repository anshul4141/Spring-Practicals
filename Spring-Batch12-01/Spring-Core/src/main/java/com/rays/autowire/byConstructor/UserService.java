package com.rays.autowire.byConstructor;

public class UserService {
	
	private UserDAOInt userDao;

	public UserService(UserDAOInt userDao) {
		this.userDao = userDao;
	}

	public void testAdd() {
		userDao.add();
	}
	
}
