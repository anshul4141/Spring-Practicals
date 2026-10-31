package com.rays.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.dao.UserDAO;
import com.rays.dto.UserDTO;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserDAO dao;

	@Transactional(propagation = Propagation.REQUIRED)
	public int add(UserDTO dto) {

		return dao.add(dto);

	}

}
