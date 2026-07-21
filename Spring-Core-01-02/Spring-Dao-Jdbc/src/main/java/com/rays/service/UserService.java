package com.rays.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.dao.UserDAO;
import com.rays.dto.UserDTO;

@Service
public class UserService {

	@Autowired
	UserDAO dao;

	@Transactional(propagation = Propagation.REQUIRED)
	public int add(UserDTO dto) {

		UserDTO existDto = dao.findByLogin(dto.getLogin());

		if (existDto != null) {
			throw new RuntimeException("loginId already exist");
		}

		return dao.add(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void update(UserDTO dto) {

		UserDTO existDto = dao.findByLogin(dto.getLogin());

		if (existDto != null && dto.getId() != existDto.getId()) {
			throw new RuntimeException("loginId already exist");
		}

		dao.update(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(int id) {
		dao.delete(id);
	}

	public UserDTO authenticate(String login, String password) {

		UserDTO dto = dao.findByLogin(login);

		if (dto != null) {
			if (dto.getPassword().equals(password)) {
				return dto;
			}
		}

		return null;

	}

	public List<UserDTO> search(UserDTO dto, int pageNo, int pageSize) {
		return dao.search(dto, pageNo, pageSize);
	}

}
