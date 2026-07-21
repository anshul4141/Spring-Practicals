package com.rays.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rays.dto.UserDTO;

@Repository
public class UserDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}

	public int add(UserDTO dto) {

		String sql = "insert into st_user values(?, ?, ?, ?, ?)";

		jdbcTemplate.update(sql, dto.getId(), dto.getFirstName(), dto.getLastName(), dto.getLogin(), dto.getPassword());

		return dto.getId();

	}

	public void update(UserDTO dto) {

		String sql = "update st_user set firstName = ?, lastName = ?, login = ?, password = ? where id = ?";

		int i = jdbcTemplate.update(sql, dto.getFirstName(), dto.getLastName(), dto.getLogin(), dto.getPassword(),
				dto.getId());

		System.out.println("record updated successfully: " + i);
	}

	public void delete(int id) {

		String sql = "delete from st_user where id = ?";

		int i = jdbcTemplate.update(sql, id);

		System.out.println("record deleted successfully: " + i);
	}

	public UserDTO findByLogin(String login) {

		String sql = "select * from st_user where login = ?";

		Object[] param = { login };

		UserDTO dto = jdbcTemplate.queryForObject(sql, param, new UserMapper());

		return dto;

	}

	public List<UserDTO> search(UserDTO dto, int pageNo, int pageSize) {

		StringBuffer sql = new StringBuffer("select * from st_user where 1 = 1 ");

		if (dto != null) {
			if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {
				sql.append(" and firstName like '" + dto.getFirstName() + "%'");
			}
		}

		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + ", " + pageSize);
		}

		List<UserDTO> list = jdbcTemplate.query(sql.toString(), new UserMapper());

		return list;

	}

}
