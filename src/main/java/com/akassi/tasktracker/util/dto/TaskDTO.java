package com.akassi.tasktracker.util.dto;

import java.time.LocalDateTime;

import com.akassi.tasktracker.model.Task;

public class TaskDTO {
	private long id;
	private String title;
	private String description;
	private LocalDateTime createdAt;
	private boolean completed;
	
	public TaskDTO() {
	}
	
	public TaskDTO(Task task) {
		this.id = task.getId();
		this.title = task.getTitle();
		this.description = task.getDescription();
		this.createdAt = task.getCreatedAt();
		this.completed = task.isCompleted();
	}

	public TaskDTO(long id, String title, String description, LocalDateTime createdAt, boolean completed) {
		this.id = id;
		this.title = title;
		this.description = description;
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
}