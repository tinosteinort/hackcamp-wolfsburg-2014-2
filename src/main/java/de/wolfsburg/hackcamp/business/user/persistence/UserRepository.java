package de.wolfsburg.hackcamp.business.user.persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import de.wolfsburg.hackcamp.business.user.persistence.entity.User;

@Repository
public class UserRepository {
	@PersistenceContext
	EntityManager em;

	public User save(User user) {
		if (user.getId() == null) {
			return em.merge(user);
		}

		em.persist(user);
		// instantly flush all dependent columns
		em.flush();

		return user;
	}
	
    public User findUserByName(final String username) {
        final Query query = em.createQuery("FROM User u WHERE u.username = :username");
        query.setParameter("username", username);
        final User foundUser = (User) query.getSingleResult();
        if (foundUser == null) {
            throw new IllegalArgumentException("Unknown User");
        }
        return foundUser;
    }
}
