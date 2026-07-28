package com.rays.common;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

@MappedSuperclass
public class BaseDTO {

	@Id
	@GeneratedValue(generator = "raysPk")
	@GenericGenerator(name = "raysPk", strategy = "native")
	@Column(name = "ID", nullable = false, unique = true)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
