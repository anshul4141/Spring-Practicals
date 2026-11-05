package com.rays.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.dto.RoleDTO;

@Repository
public class RoleDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public long add(RoleDTO dto) {

		entityManager.persist(dto); // persist method used to save records

		return dto.getId();

	}

	public void update(RoleDTO dto) {

		entityManager.merge(dto); // merge method used to update records

	}

	public void delete(long id) {

		RoleDTO dto = findByPk(id);

		entityManager.remove(dto);

	}

	public RoleDTO findByPk(long id) {

		RoleDTO dto = entityManager.find(RoleDTO.class, id);

		return dto;

	}

	public RoleDTO findByUniqueKey(String attribute, Object value) {

		RoleDTO dto = null;

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<RoleDTO> criteriaQuery = builder.createQuery(RoleDTO.class);

		Root<RoleDTO> qRoot = criteriaQuery.from(RoleDTO.class);

		Predicate condition = builder.equal(qRoot.get(attribute), value);

		criteriaQuery.where(condition);

		TypedQuery<RoleDTO> query = entityManager.createQuery(criteriaQuery);

		List<RoleDTO> list = query.getResultList();

		if (list.size() == 1) {
			dto = new RoleDTO();
			dto = list.get(0);
		}

		return dto;

	}

}
