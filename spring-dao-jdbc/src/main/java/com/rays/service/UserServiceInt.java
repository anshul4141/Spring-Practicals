package com.rays.service;

import com.rays.dto.UserDTO;

public interface UserServiceInt {

	public long add(UserDTO dto) throws Exception;

	public void update(UserDTO dto);

	public void delete(long id);
	
	public UserDTO findByLogin(String login);
	
	public UserDTO authenticate(String login, String password);
	

}
