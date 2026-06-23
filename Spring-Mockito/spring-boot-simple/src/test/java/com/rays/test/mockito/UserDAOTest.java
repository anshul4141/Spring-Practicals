package com.rays.test.mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

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
	private RoleDAO roleDAO;

	@Mock
	private AttachmentDAO attachmentDAO;

	@Mock
	private javax.persistence.criteria.CriteriaBuilder builder;

	@Mock
	private javax.persistence.criteria.CriteriaQuery<UserDTO> criteriaQuery;

	@Mock
	private javax.persistence.criteria.Root<UserDTO> root;

	@Mock
	private javax.persistence.criteria.Predicate predicate;

	@Mock
	private TypedQuery<UserDTO> typedQuery;

	@Rule
	public TestName testName = new TestName();

	@Before
	public void before() {
		System.out.println("\n=================================================");
		System.out.println("STARTING TEST : " + testName.getMethodName());
		System.out.println("=================================================");
	}

	@After
	public void after() {
		System.out.println("=================================================");
		System.out.println("FINISHED TEST : " + testName.getMethodName());
		System.out.println("=================================================\n");
	}

	@Test
	public void testPopulate() {

		System.out.println("Step 1 : Creating UserDTO");
		UserDTO user = new UserDTO();
		user.setRoleId(1L);

		System.out.println("Step 2 : Creating RoleDTO");
		RoleDTO role = new RoleDTO();
		role.setName("Admin");

		System.out.println("Step 3 : Mocking roleDAO.findByPk()");
		when(roleDAO.findByPk(1L)).thenReturn(role);

		System.out.println("Step 4 : Calling populate()");
		userDAO.populate(user);

		System.out.println("Step 5 : Verifying role name");
		assertEquals("Admin", user.getRoleName());

		System.out.println("TEST PASSED : populate()");
	}

	@Test
	public void testAdd() {

		System.out.println("Step 1 : Creating UserDTO");
		UserDTO user = new UserDTO();
		user.setId(100L);
		user.setRoleId(1L);

		System.out.println("Step 2 : Creating RoleDTO");
		RoleDTO role = new RoleDTO();
		role.setName("Admin");

		System.out.println("Step 3 : Mocking roleDAO.findByPk()");
		when(roleDAO.findByPk(1L)).thenReturn(role);

		System.out.println("Step 4 : Calling add()");
		long id = userDAO.add(user);

		System.out.println("Step 5 : Verifying persist()");
		verify(entityManager).persist(user);

		System.out.println("Step 6 : Verifying id");
		assertEquals(100L, id);

		System.out.println("Step 7 : Verifying role name");
		assertEquals("Student", user.getRoleName());

		System.out.println("TEST PASSED : add()");
	}

	@Test
	public void testUpdate() {

		System.out.println("Step 1 : Creating UserDTO");
		UserDTO user = new UserDTO();
		user.setRoleId(1L);

		System.out.println("Step 2 : Creating RoleDTO");
		RoleDTO role = new RoleDTO();
		role.setName("Admin");

		System.out.println("Step 3 : Mocking roleDAO.findByPk()");
		when(roleDAO.findByPk(1L)).thenReturn(role);

		System.out.println("Step 4 : Calling update()");
		userDAO.update(user);

		System.out.println("Step 5 : Verifying merge()");
		verify(entityManager).merge(user);

		System.out.println("TEST PASSED : update()");
	}

	@Test
	public void testFindByPk() {

		System.out.println("Step 1 : Creating UserDTO");
		UserDTO user = new UserDTO();
		user.setId(1L);

		System.out.println("Step 2 : Mocking entityManager.find()");
		when(entityManager.find(UserDTO.class, 1L)).thenReturn(user);

		System.out.println("Step 3 : Calling findByPk()");
		UserDTO dto = userDAO.findByPk(1L);

		System.out.println("Step 4 : Verifying result");
		assertNotNull(dto);

		System.out.println("Step 5 : Verifying id");
		assertEquals(Long.valueOf(2L), dto.getId());

		System.out.println("TEST PASSED : findByPk()");
	}

	@Test
	public void testDeleteWithImage() {

		System.out.println("Step 1 : Creating UserDTO");
		UserDTO user = new UserDTO();
		user.setImageId(10L);

		System.out.println("Step 2 : Creating AttachmentDTO");
		AttachmentDTO attachment = new AttachmentDTO();

		System.out.println("Step 3 : Mocking attachmentDAO.findByPk()");
		when(attachmentDAO.findByPk(10L)).thenReturn(attachment);

		System.out.println("Step 4 : Calling delete()");
		userDAO.delete(user);

		System.out.println("Step 5 : Verifying attachment find");
		verify(attachmentDAO).findByPk(10L);

		System.out.println("Step 6 : Verifying attachment delete");
		verify(attachmentDAO).delete(attachment);

		System.out.println("Step 7 : Verifying entity remove");
		verify(entityManager).remove(user);

		System.out.println("TEST PASSED : deleteWithImage()");
	}

	@Test
	public void testDeleteWithoutImage() {

		System.out.println("Step 1 : Creating UserDTO");
		UserDTO user = new UserDTO();
		user.setImageId(null);

		System.out.println("Step 2 : Calling delete()");
		userDAO.delete(user);

		System.out.println("Step 3 : Verifying entity remove");
		verify(entityManager).remove(user);

		System.out.println("Step 4 : Verifying attachmentDAO not called");
		verify(attachmentDAO, never()).findByPk(anyLong());

		System.out.println("TEST PASSED : deleteWithoutImage()");
	}

	@Test
	public void testSearch() {

		System.out.println("Step 1 : Creating Search DTO");
		UserDTO searchDto = new UserDTO();
		searchDto.setFirstName("Ram");

		System.out.println("Step 2 : Creating Expected List");
		List<UserDTO> expected = Arrays.asList(new UserDTO(), new UserDTO());

		System.out.println("Step 3 : Mocking CriteriaBuilder");
		when(entityManager.getCriteriaBuilder()).thenReturn(builder);

		System.out.println("Step 4 : Mocking CriteriaQuery");
		when(builder.createQuery(UserDTO.class)).thenReturn(criteriaQuery);

		System.out.println("Step 5 : Mocking Root");
		when(criteriaQuery.from(UserDTO.class)).thenReturn(root);

		System.out.println("Step 6 : Mocking TypedQuery");
		when(entityManager.createQuery(criteriaQuery)).thenReturn(typedQuery);

		System.out.println("Step 7 : Mocking Result List");
		when(typedQuery.getResultList()).thenReturn(expected);

		System.out.println("Step 8 : Calling search()");
		List<UserDTO> list = userDAO.search(searchDto, 0, 10);

		System.out.println("Step 9 : Verifying list size");
		assertEquals(2, list.size());

		System.out.println("Step 10 : Verifying pagination");
		verify(typedQuery).setFirstResult(0);

		System.out.println("Step 11 : Verifying max results");
		verify(typedQuery).setMaxResults(10);

		System.out.println("TEST PASSED : search()");
	}
}
