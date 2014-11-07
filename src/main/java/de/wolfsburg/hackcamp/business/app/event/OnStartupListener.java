package de.wolfsburg.hackcamp.business.app.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import de.wolfsburg.hackcamp.business.blog.persistence.BlogPostRepository;
import de.wolfsburg.hackcamp.business.blog.persistence.CategoryRepository;
import de.wolfsburg.hackcamp.business.blog.persistence.entity.BlogPost;
import de.wolfsburg.hackcamp.business.blog.persistence.entity.Category;
import de.wolfsburg.hackcamp.business.user.persistence.RoleRepository;
import de.wolfsburg.hackcamp.business.user.persistence.UserRepository;
import de.wolfsburg.hackcamp.business.user.persistence.entity.Role;
import de.wolfsburg.hackcamp.business.user.persistence.entity.User;

@Component
public class OnStartupListener implements
		ApplicationListener<ContextRefreshedEvent> {
	private static boolean isInitialized = false;

	public final static String[] categorieNames = new String[] { "Java", "PHP",
			"C#", "Oracle", "PostgreSQL" };

	public final static int postsPerCategory = 5;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	BlogPostRepository blogPostRepository;

	@Transactional
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		// ContextRefreshedEvent gets fired multiple times
		if (isInitialized) {
			return;
		}

		isInitialized = true;

		// create default roles
		Role roleUser = roleRepository.save(new Role(1L, "ROLE_USER",
				"Benutzer"));
		Role roleAdmin = roleRepository.save(new Role(2L, "ROLE_ADMIN",
				"Administrator"));

		// create default users
		User author = userRepository.save(new User("user", "user",
				"Hackcamp-Benutzer"));
		author.getRoles().add(roleUser);
		userRepository.save(author);

		User admin = userRepository.save(new User("admin", "admin",
				"Administrator"));
		admin.getRoles().add(roleAdmin);
		userRepository.save(admin);

		// create default categories
		for (int i = 0, m = categorieNames.length; i < m; i++) {
			Category category = categoryRepository.save(new Category(
					categorieNames[i]));

			for (int j = 1; j <= postsPerCategory; j++) {
				BlogPost post = new BlogPost(author, "Überschrift " + j,
						"Inhalt" + j);
				post.getCategories().add(category);
				blogPostRepository.save(post);
			}
		}
	}
}
