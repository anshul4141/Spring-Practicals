package com.rays.autowire.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("userServiceBySetter") // service annotation is used to create service layer and also create bean
public class UserServiceBySetter {

	private UserDAOInt userDao;

	@Autowired
	public void setUserDao(UserDAOInt userDao) {
		this.userDao = userDao;
	}

	public void testAdd() {
		userDao.add();
	}
	
}
