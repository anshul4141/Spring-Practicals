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
//		test.testDelete();
//		test.testUpdate();
//		test.testFindByPk();
//		test.testFindByLogin();
//		test.authenticate();
		test.search();

	}

	public void search() {

		UserDTO dto = new UserDTO();
		int pageNo = 1;
		int pageSize = 5;

		dto.setFirstName("k");
		List<UserDTO> list = service.search(dto, pageNo, pageSize);

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

	public void authenticate() {
		// TODO Auto-generated method stub

	}

	public void testFindByLogin() {
		// TODO Auto-generated method stub

	}

	public void testFindByPk() {

		UserDTO dto = new UserDTO();

		dto = service.findByPk(3);
		System.out.println(dto.getId());
		System.out.println(dto.getFirstName());
		System.out.println(dto.getLastName());
		System.out.println(dto.getLogin());
		System.out.println(dto.getPassword());

	}

	public void testUpdate() {

		UserDTO dto = new UserDTO();

		dto.setId(1);
		dto.setFirstName("abc");
		dto.setLastName("abc");
		dto.setLogin("abc@gmail.com");
		dto.setPassword("abc123");

		service.update(dto);

		System.out.println("Data update");

	}

	public void testDelete() {

		UserDTO dto = new UserDTO();

		dto.setId(1);

		service.delete(dto);

		System.out.println("record deleted");

	}

	public void testAdd() {

		UserDTO dto = new UserDTO();
		dto.setFirstName("Kamal");
		dto.setLastName("Gour");
		dto.setLogin("kamal@gmail.com");
		dto.setPassword("kamal23");

		long i = service.add(dto);

		System.out.println("Data Inserted... = " + i);

	}

}