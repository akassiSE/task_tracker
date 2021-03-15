package com.akassi.tasktracker.util.dto;

import java.util.HashSet;
import java.util.Set;

import com.akassi.tasktracker.model.Category;

public class CategoryDTO {
	private long id;
	private String name;
	private Set<TaskDTO> tasks;

	public CategoryDTO() {
	}

	public CategoryDTO(Category category) {
		this.id = category.getId();
		this.name = category.getName();
		this.tasks = new HashSet<TaskDTO>();

		if (category.getTasks() != null) {
			category.getTasks().forEach(task -> {
				tasks.add(new TaskDTO(task));
			});
		}
	}

	public CategoryDTO(long id, String name, Set<TaskDTO> tasks) {
		this.id = id;
		this.name = name;
		this.tasks = tasks;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<TaskDTO> getTasks() {
		return tasks;
	}

	public void setTasks(Set<TaskDTO> tasks) {
		this.tasks = tasks;
	}
}