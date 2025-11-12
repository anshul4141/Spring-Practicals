package com.rays.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.rays.dto.UserDTO;

public interface UserDAOInt {

	public long add(UserDTO dto) throws DataAccessException;

	public void update(UserDTO dto) throws DataAccessException;

	public UserDTO delete(long id) throws DataAccessException;

	public UserDTO findByPk(long pk) throws DataAccessException;

	public UserDTO authenticate(String login, String password);

	public UserDTO findByLogin(String login) throws DataAccessException;

	public List search(UserDTO dto, int pageNo, int pageSize);

}
