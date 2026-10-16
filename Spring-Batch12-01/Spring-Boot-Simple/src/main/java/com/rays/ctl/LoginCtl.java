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
import com.rays.form.UserRegistrationForm;
import com.rays.service.UserService;

@RestController
@RequestMapping(value = "Auth")
public class LoginCtl extends BaseCtl {

	@Autowired
	public UserService userService;

	@PostMapping("signUp")
	public ORSResponse signUp(@RequestBody @Valid UserRegistrationForm form, BindingResult bindiResult) {
		ORSResponse res = new ORSResponse();

		res = validate(bindiResult);

		if (res.isSuccess() == false) {
			return res;
		}

		UserDTO dto = (UserDTO) form.getDto();

		long pk = userService.add(dto);
		res.addData(pk);
		res.addMessage("user register successfully");
		res.setSuccess(true);
		return res;
	}

	@PostMapping("login")
	public ORSResponse login(@RequestBody @Valid LoginForm form, BindingResult bindiResult, HttpSession session) {

		ORSResponse res = new ORSResponse();

		res = validate(bindiResult);

		if (res.isSuccess() == false) {
			return res;
		}

		UserDTO dto = (UserDTO) form.getDto();

		dto = userService.authenticate(dto.getLogin(), dto.getPassword());

		if (dto != null) {
			session.setAttribute("user", dto);
			res.setSuccess(true);
			res.addMessage("user login successfully");
		} else {
			res.addMessage("invalid login or password");
		}

		return res;
	}

	@PostMapping("logout")
	public ORSResponse save(HttpSession session) {
		ORSResponse res = new ORSResponse();

		session.invalidate();
		res.addMessage("user logout successfully");

		return res;
	}

}
