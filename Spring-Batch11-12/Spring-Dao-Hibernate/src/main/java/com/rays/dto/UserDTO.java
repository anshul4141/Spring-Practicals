package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "st_user")
public class UserDTO {

	@Id
	@GeneratedValue(generator = "raysPk")
	@GenericGenerator(name = "raysPk", strategy = "native")
	@Column(name = "ID")
	private int id;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "FIRST_NAME")
	private String lastName;

	@Column(name = "FIRST_NAME")
	private String login;

	@Column(name = "FIRST_NAME")
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
