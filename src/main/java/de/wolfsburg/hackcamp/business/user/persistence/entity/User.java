package de.wolfsburg.hackcamp.business.user.persistence.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.springframework.util.Assert;

import de.wolfsburg.hackcamp.business.blog.persistence.entity.Category;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	@NotNull
	private String username;

	@Column(nullable = false)
	@NotNull
	private String password;

	@Column(nullable = false)
	@NotNull
	private String displayName;

	@OneToMany
	private List<Role> roles = new ArrayList<Role>();

	public User() {
	}
	
	public User(String username, String password, String displayName) {
		Assert.notNull(username);
		Assert.notNull(password);
		Assert.notNull(displayName);
		this.username = username;
		this.password = password;
		this.displayName = displayName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
}
