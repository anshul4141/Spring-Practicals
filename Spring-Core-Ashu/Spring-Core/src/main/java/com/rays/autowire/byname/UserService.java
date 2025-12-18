package com.rays.autowire.byname;

public class UserService {

	private UserDAOInt userdao;

	public void setUserDao(UserDAOInt userdao) {
		this.userdao = userdao;
	}

	public void testAdd() {
		userdao.add();
	}
}