package com.rays.service;

import java.util.List;

import com.rays.dto.UserDTO;

public interface UserServiceInt {

	public long add(UserDTO dto);
	
	public void delete(int id);
	
	public void update(UserDTO dto);
	
	public List search();

}
