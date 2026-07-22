package com.rays.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rays.dto.UserDTO;

@Repository
public class UserDAO {

	@Autowired
	SessionFactory sessionFactory;

	public int add(UserDTO dto) {

		Session session = sessionFactory.getCurrentSession();

		session.save(dto);

		return dto.getId();
	}

	public void update(UserDTO dto) {

		Session session = sessionFactory.getCurrentSession();

		session.update(dto);

	}

	public void delete(int id) {

		Session session = sessionFactory.getCurrentSession();

		UserDTO dto = findByPk(id);

		session.delete(dto);

	}

	public UserDTO findByPk(int id) {
		Session session = sessionFactory.getCurrentSession();
		UserDTO dto = session.get(UserDTO.class, id);
		return dto;

	}

}
