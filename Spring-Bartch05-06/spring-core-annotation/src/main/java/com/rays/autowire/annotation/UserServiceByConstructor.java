package com.rays.autowire.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userServiceByConstructor") // service annotation is used to create service layer and also create bean
public class UserServiceByConstructor {

	private UserDAOInt userDao;

	@Autowired
	public UserServiceByConstructor(UserDAOInt userDao) {
		this.userDao = userDao;
	}

	public void testAdd() {
		userDao.add();
	}

}
