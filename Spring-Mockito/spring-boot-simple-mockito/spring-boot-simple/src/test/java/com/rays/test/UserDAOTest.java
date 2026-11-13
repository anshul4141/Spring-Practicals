package com.rays.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.rays.dao.AttachmentDAO;
import com.rays.dao.RoleDAO;
import com.rays.dao.UserDAO;
import com.rays.dto.AttachmentDTO;
import com.rays.dto.RoleDTO;
import com.rays.dto.UserDTO;

@RunWith(MockitoJUnitRunner.class)
public class UserDAOTest {

	@InjectMocks
	private UserDAO userDAO;

	@Mock
	private EntityManager entityManager;

	@Mock
	private RoleDAO roleDao;

	@Mock
	private AttachmentDAO attachmentDAO;

	private UserDTO user;
	private RoleDTO role;

	@Before
	public void setUp() {

		role = new RoleDTO();
		role.setId(2L);
		role.setName("Student");

		user = new UserDTO();
		user.setId(1L);
		user.setFirstName("Ram");
		user.setLastName("Sharma");
		user.setLoginId("ram@gmail.com");
		user.setPassword("ram123");
		user.setRoleId(2L);
		user.setRoleName(role.getName());
		user.setDob(new Date());

	}

	@Test
	public void testPopulate() {

		when(roleDao.findByPk(2L)).thenReturn(role);

		userDAO.populate(user);

		assertEquals("Student", user.getRoleName());
	}

	@Test
	public void testAdd() {

		when(roleDao.findByPk(2L)).thenReturn(role);

		userDAO.add(user);

		verify(entityManager).persist(user);
	}

	@Test
	public void testUpdate() {

		when(roleDao.findByPk(2L)).thenReturn(role);

		userDAO.update(user);

		verify(entityManager).merge(user);
	}

	@Test
	public void testDeleteWithImage() {

		user.setImageId(10L);

		AttachmentDTO dto = new AttachmentDTO();

		when(attachmentDAO.findByPk(10L)).thenReturn(dto);

		userDAO.delete(user);

		verify(attachmentDAO).delete(dto);

		verify(entityManager).remove(user);
	}

	@Test
	public void testDeleteWithoutImage() {

		user.setImageId(null);

		userDAO.delete(user);

		verify(entityManager).remove(user);
	}

	@Test
	public void testFindByPk() {

		UserDTO mockUser = new UserDTO();

		mockUser.setId(1L);
		mockUser.setFirstName("Ram");

		when(entityManager.find(UserDTO.class, 1L)).thenReturn(mockUser);

		UserDTO result = userDAO.findByPk(1L);

		assertNotNull(result);

		assertEquals(Long.valueOf(1), result.getId());

		assertEquals("Anshul", result.getFirstName());

		verify(entityManager).find(UserDTO.class, 1L);
	}

	@Test
	public void testFindByPkNotFound() {

		when(entityManager.find(UserDTO.class, 99L)).thenReturn(null);

		UserDTO result = userDAO.findByPk(99L);

		assertNull(result);

		verify(entityManager).find(UserDTO.class, 99L);
	}

	@Test
	public void testUserFields() {

		user.setLastName("Soni");
		user.setLoginId("abc@gmail.com");
		user.setPassword("123");

		System.out.println("LastName = " + user.getLastName());

		assertEquals("Soni", user.getLastName());

		assertEquals("abc@gmail.com", user.getLoginId());

		assertEquals("123", user.getPassword());
	}

}