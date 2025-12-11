package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rays.dto.AttachmentDTO;
import com.rays.dto.RoleDTO;
import com.rays.dto.UserDTO;
import com.rays.service.AttachmentService;

@Repository
public class UserDAO {

	@PersistenceContext
	public EntityManager entityManager;

	@Autowired
	public RoleDAO roleDao;

	@Autowired
	AttachmentService attachmentService;

	public void populate(UserDTO dto) {
		RoleDTO roleDto = roleDao.findByPk(dto.getRoleId());
		dto.setRoleName(roleDto.getName());

		if (dto.getId() != null && dto.getId() > 0) {
			UserDTO userData = findByPk(dto.getId());
		}
	}

	public long add(UserDTO dto) {
		populate(dto);
		entityManager.persist(dto);
		return dto.getId();
	}

	public void update(UserDTO dto) {
		populate(dto);
		entityManager.merge(dto);
	}

	public void delete(UserDTO dto) {

		AttachmentDTO adto = attachmentService.findById(dto.getImageId());

		if (adto != null) {
			attachmentService.delete(adto.getId());
		}

		entityManager.remove(dto);
	}

	public UserDTO findByPk(long pk) {
		UserDTO dto = entityManager.find(UserDTO.class, pk);
		return dto;
	}

	public List<UserDTO> search(UserDTO dto, int pageNo, int pageSize) {

		// CriteriaBuilder SQL query programmatically banane ke kaam aata hai(sql query banane ke liye)
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		// UserDTO type ki query banate hain (result UserDTO hoga)(CriteriaQueiry DTO Type ki query banane ke liye)
		CriteriaQuery<UserDTO> cq = builder.createQuery(UserDTO.class);

		// Query kis table/entity par chalegi - yaha UserDTO table
		Root<UserDTO> qRoot = cq.from(UserDTO.class);

		// Dynamic WHERE conditions store karne ke liye empty list
		List<Predicate> predicateList = new ArrayList<>();

		// Agar dto null nahi hai toh hi filters check karenge
		if (dto != null) {

			// Agar firstName diya hai toh LIKE search add kar denge
			if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {
				predicateList.add(builder.like(qRoot.get("firstName"), dto.getFirstName() + "%"));
			}

			// Agar roleId diya hai aur > 0 hai toh equal condition add hogi
			if (dto.getRoleId() != null && dto.getRoleId() > 0) {
				predicateList.add(builder.equal(qRoot.get("roleId"), dto.getRoleId()));
			}

			// Agar dob (date of birth) diya hai toh usse match karenge
			if (dto.getDob() != null && dto.getDob().getTime() > 0) {
				predicateList.add(builder.equal(qRoot.get("dob"), dto.getDob()));
			}
		}

		// Sare dynamic predicates ko WHERE clause me set karna
		cq.where(predicateList.toArray(new Predicate[predicateList.size()]));

		// Criteria query ko executable query me convert karna
		TypedQuery<UserDTO> tq = entityManager.createQuery(cq);

		// Pagination logic: starting row + max records
		if (pageSize > 0) {
			tq.setFirstResult(pageNo * pageSize); // index
			tq.setMaxResults(pageSize); // total no of records
		}

		// Query execute karna aur result list lana
		List<UserDTO> list = tq.getResultList();

		// Final result return karna
		return list;
	}

	public UserDTO findByUniqueKey(String attribute, String value) {

		// CriteriaBuilder se programmatically SQL query banate hain
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		// Query banayi jati hai jiska result UserDTO type ka hoga
		CriteriaQuery<UserDTO> cq = builder.createQuery(UserDTO.class);

		// Query kis table/entity par chalegi - yaha UserDTO par
		Root<UserDTO> qRoot = cq.from(UserDTO.class);

		// WHERE condition banate hain -> attribute = value
		// Example: loginId = "abc@gmail.com"
		Predicate condition = builder.equal(qRoot.get(attribute), value);

		// Condition ko query ke WHERE clause me lagate hain
		cq.where(condition);

		// Query ko executable query me convert karte hain
		TypedQuery<UserDTO> tq = entityManager.createQuery(cq);

		// Query run karke result list le aate hain
		List<UserDTO> list = tq.getResultList();

		// Result ko store karne ke liye object banate hain
		UserDTO dto = null;

		// Agar list me data hai toh first record return karenge
		if (list.size() > 0) {
			dto = list.get(0); // unique field hai toh pehla hi enough hai
		}

		// Final result return karte hain
		return dto;
	}

}