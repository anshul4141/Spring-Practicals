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

	public void delete(int id) {
		dao.delete(id);
	}

}