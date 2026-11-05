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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rays.dto.RoleDTO;
import com.rays.dto.UserDTO;

@Repository
public class UserDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private RoleDAO roleDao;

	public void populate(UserDTO dto) {
		if (dto.getRoleId() != null && dto.getRoleId() > 0) {
			RoleDTO rdto = roleDao.findByPk(dto.getRoleId());
			dto.setRoleName(rdto.getName());
		}
	}

	public long add(UserDTO dto) {
		
		populate(dto);

		entityManager.persist(dto); // persist method used to save records

		return dto.getId();

	}

	public void update(UserDTO dto) {
		
		populate(dto);

		entityManager.merge(dto); // merge method used to update records

	}

	public void delete(long id) {

		UserDTO dto = findByPk(id);

		entityManager.remove(dto);

	}

	public UserDTO findByPk(long id) {

		UserDTO dto = entityManager.find(UserDTO.class, id);

		return dto;

	}

	public List<UserDTO> search(UserDTO dto, int pageNo, int pageSize) {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<UserDTO> criteriaQuery = builder.createQuery(UserDTO.class);

		Root<UserDTO> qRoot = criteriaQuery.from(UserDTO.class);

		List<Predicate> predicateList = new ArrayList<Predicate>();

		if (dto != null) {

			if (dto.getId() != null && dto.getId() > 0) {
				predicateList.add(builder.equal(qRoot.get("id"), dto.getId()));
			}
			if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {
				predicateList.add(builder.like(qRoot.get("firstName"), dto.getFirstName() + "%"));
			}

		}

		criteriaQuery.where(predicateList.toArray(new Predicate[predicateList.size()]));

		TypedQuery<UserDTO> query = entityManager.createQuery(criteriaQuery);

		if (pageSize > 0) {
			query.setFirstResult(pageNo * pageSize);
			query.setMaxResults(pageSize);
		}

		List<UserDTO> list = query.getResultList();

		return list;

	}

	public UserDTO findByUniqueKey(String attribute, Object value) {

		UserDTO dto = null;

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<UserDTO> criteriaQuery = builder.createQuery(UserDTO.class);

		Root<UserDTO> qRoot = criteriaQuery.from(UserDTO.class);

		Predicate condition = builder.equal(qRoot.get(attribute), value);

		criteriaQuery.where(condition);

		TypedQuery<UserDTO> query = entityManager.createQuery(criteriaQuery);

		List<UserDTO> list = query.getResultList();

		if (list.size() == 1) {
			dto = new UserDTO();
			dto = list.get(0);
		}

		return dto;

	}

}
