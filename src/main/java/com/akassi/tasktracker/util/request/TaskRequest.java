package com.akassi.tasktracker.util.request;

public class TaskRequest {
	private String title;
	private String description;
	private long categoryId;
	private boolean completed;
	
	public TaskRequest() {
	}

	public TaskRequest(String title, String description, long categoryId, boolean completed) {
		this.title = title;
		this.description = description;
		this.categoryId = categoryId;
		this.completed = completed;
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

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
}