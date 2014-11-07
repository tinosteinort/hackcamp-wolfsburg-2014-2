package de.wolfsburg.hackcamp.business.user.persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import de.wolfsburg.hackcamp.business.user.persistence.entity.Role;

@Repository
public class RoleRepository {
	@PersistenceContext
	EntityManager em;

	public Role save(Role role) {
		if (role.getId() == null) {
			return em.merge(role);
		}
		
		em.persist(role);

		return role;
	}
}
