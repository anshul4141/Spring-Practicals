package com.rays.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.rays.dto.RoleDTO;

@Repository
public class RoleDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public long add(RoleDTO dto) {
		entityManager.persist(dto); // persist method use to insert record
		return dto.getId();
	}

	public void update(RoleDTO dto) {
		entityManager.merge(dto); // merge method use to update record
	}

	public void delete(long id) {
		RoleDTO dto = findByPk(id);
		entityManager.remove(dto); // remove method use to delete given record/dto
	}

	public RoleDTO findByPk(long id) {
		RoleDTO dto = entityManager.find(RoleDTO.class, id); // find method used to create findByPk
		return dto;
	}

}
