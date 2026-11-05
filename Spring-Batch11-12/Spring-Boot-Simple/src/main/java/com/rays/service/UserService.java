package com.rays.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.dao.UserDAO;
import com.rays.dto.UserDTO;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserDAO dao;

	@Transactional(readOnly = true)
	public List<UserDTO> search(UserDTO dto, int pageNo, int pageSize) {

		return dao.search(dto, pageNo, pageSize);

	}

	@Transactional(readOnly = true)
	public UserDTO findByLogin(String login) {

		return dao.findByUniqueKey("login", login);

	}

	@Transactional(readOnly = true)
	public UserDTO authenticate(String login, String password) {

		UserDTO dto = findByLogin(login);

		if (dto != null && dto.getPassword().equals(password)) {
			return dto;
		}

		return null;

	}

}
