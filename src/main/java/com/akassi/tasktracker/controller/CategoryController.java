package com.akassi.tasktracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.akassi.tasktracker.service.CategoryService;
import com.akassi.tasktracker.util.dto.CategoryDTO;
import com.akassi.tasktracker.util.request.CategoryRequest;

@RestController
@RequestMapping("/api/v1/category")
@CrossOrigin("*")
public class CategoryController {
	private final CategoryService categoryService;

	@Autowired
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@GetMapping("/all")
	public List<CategoryDTO> findAll() {
		return categoryService.findAll();
	}
	
	@PostMapping("/create")
	public void createCategory(@RequestBody CategoryRequest request) {
		categoryService.create(request);
	}
	
	@PutMapping("/update/{id}")
	public void updateCategory(@RequestBody CategoryRequest request, @PathVariable("id") long id) {
		categoryService.update(request, id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteCategory(@PathVariable("id") long id) {
		categoryService.delete(id);
	}
}