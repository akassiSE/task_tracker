package com.akassi.tasktracker.service;

import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akassi.tasktracker.model.Category;
import com.akassi.tasktracker.model.Task;
import com.akassi.tasktracker.repository.CategoryRepository;
import com.akassi.tasktracker.repository.TaskRepository;
import com.akassi.tasktracker.util.request.TaskRequest;

@Service
public class TaskService {
	private final CategoryRepository categoryRepository;
	private final TaskRepository taskRepository;
	
	@Autowired
	public TaskService(CategoryRepository categoryRepository, TaskRepository taskRepository) {
		this.categoryRepository = categoryRepository;
		this.taskRepository = taskRepository;
	}

	public void create(TaskRequest request) {
		Task task = new Task();
		
		task.setTitle(request.getTitle());
		task.setDescription(request.getDescription());
		task.setCategory(categoryRepository.findById(request.getCategoryId()).get());
		task.setCreatedAt(LocalDateTime.now());
		
		taskRepository.save(task);
		
		Category category = categoryRepository.findById(request.getCategoryId()).get();
		Set<Task> tasks = category.getTasks();
		tasks.add(task);
		category.setTasks(tasks);
		categoryRepository.save(category);
	}

	public void update(TaskRequest request, long id) {
		Task task = taskRepository.findById(id).get();
		
		if (request.getTitle() != null) {
			task.setTitle(request.getTitle());
		}
		
		if (request.getDescription() != null) {
			task.setDescription(request.getDescription());
		}
		
		task.setCompleted(request.isCompleted());
		
		taskRepository.save(task);
	}

	public void delete(long id) {
		System.out.println(id);
		taskRepository.deleteById(id);
	}
}