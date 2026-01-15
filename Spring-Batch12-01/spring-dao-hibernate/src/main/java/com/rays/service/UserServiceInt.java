package com.rays.service;

import com.rays.dto.UserDTO;

public interface UserServiceInt {

	public long add(UserDTO dto);
	
	public void update(UserDTO dto);
	
	public UserDTO findByPk(long pk);
	
	public void delete(long pk);

}
