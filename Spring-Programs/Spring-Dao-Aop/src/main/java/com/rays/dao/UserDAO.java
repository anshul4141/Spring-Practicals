package com.rays.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rays.dto.UserDTO;

@Repository
public class UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public int add(UserDTO dto) {

		Session session = sessionFactory.getCurrentSession();

		session.save(dto);

		return dto.getId();

	}

}
