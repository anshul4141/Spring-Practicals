package com.rays.autowire.byname;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class UserService {

	@Autowired
	@Qualifier("p")
	private UserDAOInt userDao;

	public void add() {
		userDao.add();
	}

}
