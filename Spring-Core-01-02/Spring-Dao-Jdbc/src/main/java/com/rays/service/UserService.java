package com.rays.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rays.dao.UserDAO;
import com.rays.dto.UserDTO;

@Service
public class UserService {

	@Autowired
	UserDAO dao;

	public int add(UserDTO dto) {
		return dao.add(dto);
	}

}
