package com.rays.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rays.dao.UserDAOInt;
import com.rays.dto.UserDTO;

@Service
public class UserService {

	@Autowired
	private UserDAOInt dao;

	public long add(UserDTO dto) {
		long pk = dao.add(dto);
		return pk;
	}

	public void update(UserDTO dto) {
		dao.update(dto);

	}

	public void delete(int id) {
		dao.delete(id);
	}

	public UserDTO findByPk(int id) {
		return dao.findByPk(id);
	}

	public UserDTO findByLogin(String login) {
		return dao.findByLogin(login);
	}

	public UserDTO authenticate(String login, String password) {
		return dao.authenticate(login, password);
	}

}