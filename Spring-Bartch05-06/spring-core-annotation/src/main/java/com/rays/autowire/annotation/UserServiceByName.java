package com.rays.autowire.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("userServiceByName") // service annotation is used to create service layer and also create bean
public class UserServiceByName {

	@Autowired
	@Qualifier("userDao")
	private UserDAOInt userDao;

	public void testAdd() {
		userDao.add();
	}

}
