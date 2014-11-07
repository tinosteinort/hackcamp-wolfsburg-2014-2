package de.wolfsburg.hackcamp.business.blog.persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import de.wolfsburg.hackcamp.business.blog.persistence.entity.BlogPost;
import de.wolfsburg.hackcamp.business.blog.persistence.entity.Category;

@Repository
public class BlogPostRepository {
	@PersistenceContext
	EntityManager em;

	public BlogPost save(BlogPost post) {
		if (post.getId() == null) {
			return em.merge(post);
		}

		em.persist(post);

		return post;
	}

	/**
	 * Counts the amount of total blog posts
	 * 
	 * @return
	 */
	public Long countAll() {
		return em.createQuery("SELECT COUNT(bp) FROM BlogPost bp", Long.class)
				.getSingleResult().longValue();
	}
}
