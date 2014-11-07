package de.wolfsburg.hackcamp.configuration.web;

import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import de.wolfsburg.hackcamp.configuration.DefaultConfiguration;

@Order(1)
public class MvcInitializer extends
		AbstractAnnotationConfigDispatcherServletInitializer {

	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { DefaultConfiguration.class };
	}

	/**
	 * Konfiguriert den Servlet-Kontext. Dies ist i.a.R. Spring MVC.
	 */
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { MvcConfiguration.class };
	}

	/**
	 * Bindung des zentralen {@link DispatcherServlet} an die URLs der
	 * Applikation. Dies wird in den meisten Fällen "/" sein.
	 */
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}