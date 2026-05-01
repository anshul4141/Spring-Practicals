package com.rays.dao;

import java.util.ArrayList;
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
	public EntityManager entityManager;

	public long add(RoleDTO dto) {
		entityManager.persist(dto); // add
		return dto.getId();
	}

	public void update(RoleDTO dto) {
		entityManager.merge(dto); // update
	}

	public void delete(RoleDTO dto) {
		entityManager.remove(dto); // delete
	}

	public RoleDTO findByPk(long pk) {
		RoleDTO dto = entityManager.find(RoleDTO.class, pk); // find by id
		return dto;
	}

	public List<RoleDTO> search(RoleDTO dto, int pageNo, int pageSize) {

		List<RoleDTO> list = null;

		// CriteriaBuilder SQL query programmatically banane ke kaam aata hai(sql query banane ke liye)
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		// RoleDTO type ki query banate hain (result RoleDTO hoga)(CriteriaQueiry DTO Type ki query banane ke liye)
		CriteriaQuery<RoleDTO> cq = builder.createQuery(RoleDTO.class);

		// Query kis table/entity par chalegi - yaha RoleDTO table
		Root<RoleDTO> qRoot = cq.from(RoleDTO.class);

		// final query = select * from RoleDTO
		cq.select(qRoot);

		TypedQuery<RoleDTO> tq = entityManager.createQuery(cq);

		if (pageSize > 0) {
			tq.setFirstResult(pageNo * pageSize);
			tq.setMaxResults(pageSize);
		}

		list = tq.getResultList();

		return list;
	}

}
