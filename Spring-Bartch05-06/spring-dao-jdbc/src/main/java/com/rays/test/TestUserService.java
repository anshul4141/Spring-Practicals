package com.rays.test;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.rays.dto.UserDTO;
import com.rays.service.UserService;

@Component("testUserService")
public class TestUserService {

	@Autowired
	public UserService service = null;

	public static void main(String[] args) throws Exception {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		TestUserService test = (TestUserService) context.getBean("testUserService");

//		test.testAdd();
//		test.testUpdate();
//		test.testDelete();
//		test.testFindByPk();
//		test.testFindByLogin();
//		test.testAuthencticate();
		test.testSearch();

	}

	private void testSearch() {

		UserDTO dto = new UserDTO();

		//dto.setFirstName("abc");
		
		List<UserDTO> list = service.search(dto, 1, 5);

		Iterator<UserDTO> it = list.iterator();

		while (it.hasNext()) {
			dto = it.next();
			System.out.println(dto.getId());
			System.out.println(dto.getFirstName());
			System.out.println(dto.getLastName());
			System.out.println(dto.getLogin());
			System.out.println(dto.getPassword());
		}

	}

	private void testFindByLogin() {
		UserDTO dto = new UserDTO();

		dto = service.findByLogin("abc123@gmail.com");

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

	private void testAuthencticate() {

		UserDTO dto = new UserDTO();

		dto = service.authenticate("abc@gmail.com", "abc1243");

		if (dto != null) {
			System.out.println(dto.getId());
			System.out.println(dto.getFirstName());
			System.out.println(dto.getLastName());
			System.out.println(dto.getLogin());
			System.out.println(dto.getPassword());
		} else {
			System.out.println("invalid login or password");
		}

	}

	private void testFindByPk() {

		UserDTO dto = new UserDTO();

		dto = service.findByPk(10);

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

	private void testUpdate() {

		UserDTO dto = new UserDTO();

		dto.setId(2);
		dto.setFirstName("Ram");
		dto.setLastName("Sharma");
		dto.setLogin("ram@gmail.com");
		dto.setPassword("ram123");

		service.update(dto);

	}

	private void testDelete() {
		service.delete(3);
	}

	public void testAdd() {
		UserDTO dto = new UserDTO();
		dto.setFirstName("Pawan");
		dto.setLastName("Verma");
		dto.setLogin("pawan@gmail.com");
		dto.setPassword("ram123");
		long i = service.add(dto);
		System.out.println("Data Inserted... row affected = " + i);
	}

}