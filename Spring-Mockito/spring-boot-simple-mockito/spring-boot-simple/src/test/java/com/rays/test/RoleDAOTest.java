package com.rays.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.rays.dao.RoleDAO;
import com.rays.dto.RoleDTO;

@RunWith(MockitoJUnitRunner.class)
public class RoleDAOTest {

	@InjectMocks
	private RoleDAO roleDAO;

	@Mock
	private EntityManager entityManager;

	@Mock
	private TypedQuery<RoleDTO> typedQuery;

	private RoleDTO role;

	@Before
	public void setUp() {

		role = new RoleDTO();
		role.setId(1L);
		role.setName("Admin");
		role.setDescription("Administrator");
	}

	@Test
	public void testAdd() {

		roleDAO.add(role);

		verify(entityManager).persist(role);

		assertEquals(Long.valueOf(1), role.getId());
	}

	@Test
	public void testUpdate() {

		role.setName("Student");

		roleDAO.update(role);

		verify(entityManager).merge(role);

		assertEquals("Student", role.getName());
	}

	@Test
	public void testDelete() {

		roleDAO.delete(role);

		verify(entityManager).remove(role);
	}

	@Test
	public void testFindByPk() {

		RoleDTO mockRole = new RoleDTO();

		mockRole.setId(1L);
		mockRole.setName("Admin");

		when(entityManager.find(RoleDTO.class, 1L)).thenReturn(mockRole);

		RoleDTO result = roleDAO.findByPk(1L);

		assertNotNull(result);

		assertEquals("Admin", result.getName());

		verify(entityManager).find(RoleDTO.class, 1L);
	}

	@Test
	public void testFindByPkNotFound() {

		when(entityManager.find(RoleDTO.class, 99L)).thenReturn(null);

		RoleDTO result = roleDAO.findByPk(99L);

		assertNull(result);
	}

	@Test
	public void testSearchMock() {

		List<RoleDTO> list = new ArrayList<RoleDTO>();

		list.add(role);

		assertEquals(1, list.size());
	}

	@Test
	public void testRoleFields() {

		role.setName("Manager");
		role.setDescription("Management Role");

		assertEquals("Manager", role.getName());

		assertEquals("Management Role", role.getDescription());
	}

	@Test
	public void testGetValue() {

		role.setName("Admin");

		assertEquals("Admin", role.getValue());
	}

}