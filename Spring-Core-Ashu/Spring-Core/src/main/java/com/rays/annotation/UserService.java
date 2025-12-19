package com.rays.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("userService")
public class UserService {

	@Autowired
	UserDAOInt userDao;

	public void testAdd() {
		userDao.add();
	}

}
