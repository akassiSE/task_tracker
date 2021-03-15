package com.akassi.tasktracker.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tasks")
public class Task {
	@Id
	@SequenceGenerator(
			name = "tasks_sequence",
			sequenceName = "tasks_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "tasks_sequence"
	)
	private long id;
	private String title;
	private String description;
	@ManyToOne(fetch = FetchType.EAGER)
	private Category category;
	private LocalDateTime createdAt;
	private boolean completed;
	
	public Task() {
	}

	public Task(String title, String description, Category category, LocalDateTime createdAt, boolean completed) {
		this.title = title;
		this.description = description;
		this.category = category;
		this.createdAt = createdAt;
		this.completed = completed;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", title=" + title + ", description=" + description + ", category=" + category
				+ ", createdAt=" + createdAt + ", completed=" + completed + "]";
	}
}