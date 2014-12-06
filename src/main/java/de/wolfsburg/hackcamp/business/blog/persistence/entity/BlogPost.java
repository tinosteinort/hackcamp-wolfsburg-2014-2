package de.wolfsburg.hackcamp.business.blog.persistence.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.util.Assert;

import de.wolfsburg.hackcamp.business.user.persistence.entity.User;

@Entity
public class BlogPost {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	@NotNull
	private String subject;

	// TODO Time
	@Column(nullable = true)
	// @NotNull
	private LocalDateTime createdOn;

	@Column(nullable = false)
	@NotNull
	private String content;

	@ManyToOne
	@JoinColumn
	private User author;

	@ManyToMany
	private List<Category> categories = new ArrayList<Category>();

	public BlogPost() {
	}

	public BlogPost(User author, String subject, String content) {
		Assert.notNull(author);
		Assert.notNull(subject);
		Assert.notNull(content);

		this.author = author;
		this.subject = subject;
		this.content = content;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}
}
