package com.rays.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rays.dto.UserDTO;

@Repository
public class UserDAOImpl implements UserDAOInt {

	private JdbcTemplate jdbcTemplate;

	private DataSource dataSource = null;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public long nextPk() {
		String sql = "select max(id) from st_user";
		Long maxId = jdbcTemplate.queryForObject(sql, Long.class);
		if (maxId == null) {
			return 1;
		}
		return maxId + 1;
	}

	public long add(UserDTO dto) {
		long pk = nextPk();
		String sql = "insert into st_user values(?, ?, ?, ?, ?)";
		int i = jdbcTemplate.update(sql, pk, dto.getFirstName(), dto.getLastName(), dto.getLogin(), dto.getPassword());
		return i;
	}

	public void update(UserDTO dto) {
		String sql = "update st_user set firstName = ?, lastName = ?, login = ?, password = ? where id = ?";
		int i = jdbcTemplate.update(sql, dto.getFirstName(), dto.getLastName(), dto.getLogin(), dto.getPassword(),
				dto.getId());
		System.out.println("record updated: " + i);
	}

	@Override
	public void delete(int id) {
		String sql = "delete from st_user where id = ?";
		int i = jdbcTemplate.update(sql, id);
		System.out.println("record deleted = " + i);
	}

	public UserDTO findByPk(int id) {
		try {
			
			String sql = "select * from st_user where id = ?";

			Object[] params = { id };
			
			UserDTO user = jdbcTemplate.queryForObject(sql, params, new UserMapper());
			
			return user;
		
		} catch (EmptyResultDataAccessException e) {
		
			return null;
		
		}
	}

	public UserDTO findByLogin(String login) {
		try {
			String sql = "select * from st_user where login = ?";

			Object[] params = { login };
			
			UserDTO user = jdbcTemplate.queryForObject(sql, params, new UserMapper());
		
			return user;
		
		} catch (EmptyResultDataAccessException e) {
		
			return null;
		
		}
	}

	public UserDTO authenticate(String login, String password) {
		try {
			String sql = "select * from st_user where login = ? and password = ?";

			Object[] params = { login, password };
			
			UserDTO user = jdbcTemplate.queryForObject(sql, params, new UserMapper());
			
			return user;
		
		} catch (EmptyResultDataAccessException e) {
		
			return null;
		
		}
	}

}
