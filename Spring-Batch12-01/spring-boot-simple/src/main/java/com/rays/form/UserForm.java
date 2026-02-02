package com.rays.form;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.UserDTO;

public class UserForm extends BaseForm {

	@NotEmpty(message = "first name is required")
	private String firstName;

	@NotEmpty(message = "first name is required")
	private String lastName;

	@NotEmpty(message = "first name is required")
	private String loginId;

	@NotEmpty(message = "first name is required")
	private String password;

	@NotEmpty(message = "first name is required")
	private Date dob;

	@NotEmpty(message = "first name is required")
	private Long roleId;

	@Override
	public BaseDTO getDto() {
		
		UserDTO dto = new UserDTO();
		dto.setFirstName(firstName);
		dto.setLastName(lastName);
		dto.setLoginId(loginId);
		dto.setPassword(password);
		dto.setRoleId(roleId);
		dto.setDob(dob);

		return dto;

	}

}
