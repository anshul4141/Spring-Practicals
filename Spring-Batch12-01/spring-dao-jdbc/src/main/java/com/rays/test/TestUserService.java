package com.rays.test;

import java.util.Iterator;
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
	public UserServiceInt service = null;

	public static void main(String[] args) throws Exception {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		TestUserService test = (TestUserService) context.getBean("testUserService");

//		test.testAdd();
//		test.testDelete();
//		test.testUpdate();
		test.testSearch();

	}

	public void testAdd() {
		UserDTO dto = new UserDTO();
		dto.setId(2);
		dto.setFirstName("abc");
		dto.setLastName("abc");
		dto.setLogin("abc@gmail.com");
		dto.setPassword("abc123");
		long pk = service.add(dto);
		System.out.println("Data Inserted... pk = " + pk);
	}

	private void testDelete() {
		service.delete(2);
	}

	private void testUpdate() {
		UserDTO dto = new UserDTO();
		dto.setId(1);
		dto.setFirstName("Ram");
		dto.setLastName("Sharma");
		dto.setLogin("ram@gmail.com");
		dto.setPassword("ram123");
		service.update(dto);
	}

	private void testSearch() {
		List list = service.search();

		Iterator<UserDTO> it = list.iterator();
		while (it.hasNext()) {
			UserDTO dto = it.next();
			System.out.println(dto.getId());
			System.out.println(dto.getFirstName());
			System.out.println(dto.getLastName());
			System.out.println(dto.getLogin());
			System.out.println(dto.getPassword());
		}
	}

}
