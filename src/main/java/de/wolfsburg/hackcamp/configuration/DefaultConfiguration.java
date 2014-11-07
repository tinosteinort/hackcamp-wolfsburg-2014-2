package de.wolfsburg.hackcamp.configuration;

import org.springframework.context.annotation.Import;

import de.wolfsburg.hackcamp.configuration.persistence.HibernateConfiguration;

@Import(value = { HibernateConfiguration.class })
public class DefaultConfiguration {

}
