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
	UserDAO dao;

	@Transactional(propagation = Propagation.REQUIRED)
	public void save(UserDTO dto) {

		if (dto.getId() > 0) {
			dao.update(dto);
			return;
		}
		dao.add(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(int id) {
		dao.delete(id);
	}

	@Transactional(readOnly = true)
	public UserDTO findById(int id) {
		return dao.findByPk(id);
	}

}
