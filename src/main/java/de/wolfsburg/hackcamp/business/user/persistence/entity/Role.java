package de.wolfsburg.hackcamp.business.user.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.util.Assert;

@Entity
public class Role {
	@Id
	@NotNull
	private Long id;

	@Column(nullable = false)
	@NotNull
	private String name;

	@Column(nullable = false)
	@NotNull
	private String displayName;

	public Role() {
	}
	
	public Role(Long id, String name, String displayName) {
		Assert.notNull(id);
		Assert.notNull(name);
		Assert.notNull(displayName);
		this.id = id;
		this.name = name;
		this.displayName = displayName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
}
