package com.rays.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rays.dto.UserDTO;

@Repository
public class UserDAO {

	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource;

	@Autowired
	public UserDAO(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public int nextPk() {

		int pk = 0;

		String sql = "select max(id) from st_user";

		pk = jdbcTemplate.queryForObject(sql, Integer.class);

		return pk + 1;
	}

	public int add(UserDTO dto) {

		String sql = "insert into st_user values(?,?,?,?,?)";

		jdbcTemplate.update(sql, dto.getId(), dto.getFirstName(), dto.getLastName(), dto.getLogin(), dto.getPassword());

		return dto.getId();

	}

	public void update(UserDTO dto) {

		String sql = "update st_user set first_name = ?, last_name = ?, login = ?, password = ? where id = ?";

		int i = jdbcTemplate.update(sql, dto.getFirstName(), dto.getLastName(), dto.getLogin(), dto.getPassword(),
				dto.getId());

		System.out.println("user update successfully: " + i);
	}

	public void delete(int id) {

		String sql = "delete st_user where id = ?";

		int i = jdbcTemplate.update(sql, id);

		System.out.println("user deleted successfully: " + i);
	}

}
