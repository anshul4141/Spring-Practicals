package com.rays.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rays.dto.RoleDTO;
import com.rays.dto.UserDTO;

@Repository
public class UserDAO {

	@PersistenceContext
	public EntityManager entityManager;

	@Autowired
	public RoleDAO roleDao;

	public void populate(UserDTO dto) {
		RoleDTO roleDto = roleDao.findByPk(dto.getRoleId());
		dto.setRoleName(roleDto.getName());

		if (dto.getId() != null && dto.getId() > 0) {
			UserDTO userData = findByPk(dto.getId());
		}
	}

	public long add(UserDTO dto) {
		populate(dto);
		entityManager.persist(dto);
		return dto.getId();
	}

	public void update(UserDTO dto) {
		populate(dto);
		entityManager.merge(dto);
	}

	public void delete(UserDTO dto) {
		entityManager.remove(dto);
	}

	public UserDTO findByPk(long pk) {
		UserDTO dto = entityManager.find(UserDTO.class, pk);
		return dto;
	}

}