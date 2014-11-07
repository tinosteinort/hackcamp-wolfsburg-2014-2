package de.wolfsburg.hackcamp.business.blog.persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import de.wolfsburg.hackcamp.business.blog.persistence.entity.Category;

@Repository
public class CategoryRepository {
	@PersistenceContext
	EntityManager em;

	public Category save(Category category) {
		if (category.getId() == null) {
			return em.merge(category);
		}
		
		em.persist(category);

		return category;
	}
}
