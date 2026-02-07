package com.rays.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.dao.UserDAOInt;
import com.rays.dto.UserDTO;

@Service
public class UserService{

	@Autowired
	private UserDAOInt dao;

	@Transactional(propagation = Propagation.REQUIRED)
	public long add(UserDTO dto) {
		long pk = dao.add(dto);
		return pk;
	}

}

/*
 * @Transactional ka matlab hai ki Spring is method ko ek transaction ke andar
 * run karega — matlab agar kuch galat ho jaaye (exception aajaye), to saare
 * database changes rollback ho jaayenge or agar exception nahi hai toh
 * transaction commit ho jayenge.
 * 
 * propagation = Propagation.REQUIRED ka matlab hai: 1.Agar koi transaction
 * already chal raha hai, to ye method usi existing transaction ko continue
 * karega. 2.Agar koi transaction nahi chal raha, to ye naya transaction start
 * karega.
 */
