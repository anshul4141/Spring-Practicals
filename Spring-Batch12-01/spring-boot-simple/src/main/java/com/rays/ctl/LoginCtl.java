package com.rays.ctl;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.UserDTO;
import com.rays.form.LoginForm;
import com.rays.form.UserForm;
import com.rays.form.UserRegistrationForm;
import com.rays.service.UserService;

@RestController
@RequestMapping(value = "Auth")
public class LoginCtl extends BaseCtl {

	@Autowired
	UserService service;

	@PostMapping("signUp")
	public ORSResponse save(@RequestBody @Valid UserRegistrationForm form, BindingResult bindingResult) {

		ORSResponse res = new ORSResponse();

		res = validate(bindingResult);

		if (res.isSuccess() == false) {
			return res;
		}

		UserDTO dto = new UserDTO();

		dto = (UserDTO) form.getDto();

		long i = service.add(dto);

		if (i != 0) {
			res.addMessage("user added successfully");
			res.addData(dto);
		}

		return res;

	}

	@PostMapping("login")
	public ORSResponse login(@RequestBody @Valid LoginForm form, BindingResult bindingResult, HttpSession session) {

		ORSResponse res = new ORSResponse();

		res = validate(bindingResult);

		if (!res.isSuccess()) {
			return res;
		}

		UserDTO dto = service.authenticate(form.getLoginId(), form.getPassword());

		if (dto != null) {
			session.setAttribute("user", dto);
			res.setSuccess(true);
			res.addData(dto);
			res.addMessage("user login successfully");
		} else {
			res.setSuccess(false);
			res.addMessage("Invalid login or password");
		}

		return res;

	}

	@PostMapping("logout")
	public ORSResponse logout(HttpSession session) {

		ORSResponse res = new ORSResponse();
		session.invalidate();
		res.addMessage("user logout successfully...!");

		return res;

	}

}
