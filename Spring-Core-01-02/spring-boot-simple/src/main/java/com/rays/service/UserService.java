package com.rays.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.dao.UserDAO;
import com.rays.dto.UserDTO;
import com.rays.exception.DuplicateRecordException;

@Service
@Transactional
public class UserService {

	@Autowired
	public UserDAO dao;

	@Transactional(readOnly = true)
	public UserDTO findByLogin(String loginId) {
		UserDTO dto = dao.findByUniqueKey("loginId", loginId);

		if (dto != null) {
			return dto;
		}

		return null;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public long add(UserDTO dto) {

		UserDTO existDto = findByLogin(dto.getLoginId());

		if (existDto != null) {
			throw new DuplicateRecordException("loginId already exist");
		}
		long pk = dao.add(dto);
		return pk;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void update(UserDTO dto) {

		UserDTO existDto = findByLogin(dto.getLoginId());

		if (existDto != null && dto.getId() != existDto.getId()) {
			throw new DuplicateRecordException("loginId already exist");
		}
		dao.update(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(long id) {
		try {
			UserDTO dto = findById(id);
			dao.delete(dto);
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}

	@Transactional(readOnly = true)
	public UserDTO findById(long pk) {
		UserDTO dto = dao.findByPk(pk);
		return dto;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public long save(UserDTO dto) {
		Long id = dto.getId();
		if (id != null && id > 0)
			update(dto);
		else
			id = add(dto);
		return id;
	}

	@Transactional(readOnly = true)
	public List<UserDTO> search(UserDTO dto, int pageNo, int pageSize) {
		List<UserDTO> list = dao.search(dto, pageNo, pageSize);
		return list;
	}

	@Transactional(readOnly = true)
	public UserDTO authenticate(String loginId, String password) {

		UserDTO dto = findByLogin(loginId);

		if (dto != null)
			if (dto.getPassword().equals(password))
				return dto;

		return null;
	}
}