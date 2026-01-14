package com.rays.service;

import java.util.List;

import com.rays.dto.UserDTO;

public interface UserServiceInt {

	public long add(UserDTO dto);

	public void delete(int id);

	public void update(UserDTO dto);

	public UserDTO authenticate(String login, String password);

	public UserDTO findByLogin(String login);

	public UserDTO findByPk(int id);

	public List<UserDTO> search();

	public List<UserDTO> search(UserDTO dto, int pageNo, int pageSize);

}
