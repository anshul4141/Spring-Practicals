package com.rays.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.rays.dto.UserDTO;
import com.rays.service.UserServiceInt;

@Component("testUserService")
public class TestUserService {

	@Autowired
	private UserServiceInt userService = null;

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		TestUserService test = (TestUserService) context.getBean("testUserService");

//		test.testAdd();
//		test.testFindByPk();
		test.testSearch();
	}

	private void testSearch() {

		List<UserDTO> list = null;
		UserDTO dto = null;

		list = userService.search(dto, 1, 5);

		for (UserDTO udto : list) {
			System.out.println(udto.getId());
			System.out.println(udto.getFirstName());
			System.out.println(udto.getLastName());
			System.out.println(udto.getLogin());
			System.out.println(udto.getPassword());
		}

	}

	private void testAdd() {

		UserDTO dto = new UserDTO();

		// dto.setId(0);
		dto.setFirstName("Akbar");
		dto.setLastName("Mansuri");
		dto.setLogin("akbar@gmail.com");
		dto.setPassword("akbar123");

		long pk = userService.add(dto);
		System.out.println("data added successfully: " + pk);
	}

	private void testFindByPk() {

		UserDTO dto = null;

		dto = userService.findByPk(2L);

		if (dto != null) {
			System.out.println(dto.getId());
			System.out.println(dto.getFirstName());
			System.out.println(dto.getLastName());
			System.out.println(dto.getLogin());
			System.out.println(dto.getPassword());
		} else {
			System.out.println("user not found");
		}

	}

}
