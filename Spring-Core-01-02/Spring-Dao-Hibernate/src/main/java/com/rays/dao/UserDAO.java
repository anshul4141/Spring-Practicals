package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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

	public UserDTO findByLogin(String login) {

		Session session = sessionFactory.getCurrentSession();

		UserDTO dto = null;
		List<UserDTO> list = new ArrayList<UserDTO>();

		// select * from UserDTO where 1 = 1
		Criteria criteria = session.createCriteria(UserDTO.class);

		// and login = ?;
		criteria.add(Restrictions.eq("login", login));

		list = criteria.list();

		if (list.size() == 1) {
			dto = list.get(0);
		}

		return dto;

	}

	public UserDTO authenticate(String login, String password) {

		Session session = sessionFactory.getCurrentSession();

		UserDTO dto = null;
		List<UserDTO> list = new ArrayList<UserDTO>();

		// select * from UserDTO where 1 = 1
		Criteria criteria = session.createCriteria(UserDTO.class);

		// and login = ?
		criteria.add(Restrictions.eq("login", login));

		// and password = ?;
		criteria.add(Restrictions.eq("password", password));

		list = criteria.list();

		if (list.size() == 1) {
			dto = list.get(0);
		}

		return dto;

	}

	public List<UserDTO> search(UserDTO dto, int pageNo, int pageSize) {

		Session session = sessionFactory.getCurrentSession();

		List<UserDTO> list = new ArrayList<UserDTO>();

		// select * from UserDTO where 1 = 1
		Criteria criteria = session.createCriteria(UserDTO.class);

		if (dto != null) {
			if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {
				criteria.add(Restrictions.like("firstName", dto.getFirstName() + "%"));
			}
		}

		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			criteria.setFirstResult(pageNo); // index
			criteria.setMaxResults(pageSize);// number of records
		}

		list = criteria.list();

		return list;

	}

}
