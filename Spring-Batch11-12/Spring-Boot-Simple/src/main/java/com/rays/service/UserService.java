package com.rays.service;

import java.util.List;

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
	public long add(UserDTO dto) {

		UserDTO existDto = findByLogin(dto.getLogin());

		if (existDto != null) {
			throw new RuntimeException("loginId is already exist");
		}

		return dao.add(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void update(UserDTO dto) {
		UserDTO existDto = findByLogin(dto.getLogin());

		if (existDto != null && existDto.getId() != dto.getId()) {
			throw new RuntimeException("loginId is already exist");
		}

		dao.update(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public long save(UserDTO dto) {

		if (dto.getId() > 0) {
			update(dto);
		} else {
			add(dto);
		}
		return dto.getId();
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(long id) {
		dao.delete(id);
	}

	@Transactional(readOnly = true)
	public UserDTO findByPk(long id) {
		return dao.findByPk(id);
	}

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
