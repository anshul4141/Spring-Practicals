package com.rays.dao;

import com.rays.dto.UserDTO;

public interface UserDAOInt {

	public long add(UserDTO dto);

	public void update(UserDTO dto);

	public void delete(UserDTO dto);

	public UserDTO findByPk(int pk);

	public UserDTO findByLogin(String login);

	public UserDTO authenticate(String login, String password);

}
