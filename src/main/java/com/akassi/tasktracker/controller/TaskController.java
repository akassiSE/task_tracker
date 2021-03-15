package com.akassi.tasktracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akassi.tasktracker.service.TaskService;
import com.akassi.tasktracker.util.request.TaskRequest;

@RestController
@RequestMapping("/api/v1/task")
@CrossOrigin("*")
public class TaskController {
	private final TaskService taskService;

	@Autowired
	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}
	
	@PostMapping("/create")
	public void createTask(@RequestBody TaskRequest request) {
		taskService.create(request);
	}
	
	@PutMapping("/update/{id}")
	public void updateTask(@RequestBody TaskRequest request, @PathVariable("id") long id) {
		taskService.update(request, id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteTask(@PathVariable("id") long id) {
		taskService.delete(id);
	}
}