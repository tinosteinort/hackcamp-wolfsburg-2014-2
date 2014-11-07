package de.wolfsburg.hackcamp.business.app.event;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import de.wolfsburg.hackcamp.business.blog.persistence.BlogPostRepository;
import de.wolfsburg.hackcamp.configuration.persistence.HibernateConfiguration;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HibernateConfiguration.class)
public class OnStartupListenerITest {
	@Autowired
	ApplicationContext ctx;

	@Autowired
	AutowireCapableBeanFactory autowireBeanFactory;

	@Autowired
	BlogPostRepository blogPostRepository;

	@Test
	@Transactional
	public void test() {
		OnStartupListener listener = new OnStartupListener();
		// autowire repositories lately. We don't want the listener be
		// automatically fired
		autowireBeanFactory.autowireBean(listener);
		listener.onApplicationEvent(null);

		assertEquals(new Long(OnStartupListener.categorieNames.length
				* OnStartupListener.postsPerCategory),
				blogPostRepository.countAll());
	}
}
