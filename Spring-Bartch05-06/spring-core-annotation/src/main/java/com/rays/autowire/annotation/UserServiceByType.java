package com.rays.autowire.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userServiceByType") // service annotation is used to create service layer and also create bean
public class UserServiceByType {

	@Autowired
	private UserDAOInt userDao;

	public void testAdd() {
		userDao.add();
	}

}
