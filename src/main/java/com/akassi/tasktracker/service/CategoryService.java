package com.akassi.tasktracker.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akassi.tasktracker.model.Category;
import com.akassi.tasktracker.repository.CategoryRepository;
import com.akassi.tasktracker.util.dto.CategoryDTO;
import com.akassi.tasktracker.util.request.CategoryRequest;

@Service
public class CategoryService {
	private final CategoryRepository categoryRepository;
	
	@Autowired
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	public List<CategoryDTO> findAll() {
		List<CategoryDTO> categories = new ArrayList<CategoryDTO>();
		
		categoryRepository.findAll().forEach(category -> {
			categories.add(new CategoryDTO(category));
		});
		
		return categories;
	}

	public void create(CategoryRequest request) {
		Category category = new Category();
		
		category.setName(request.getName());
		
		categoryRepository.save(category);
	}

	public void update(CategoryRequest request, long id) {
		Category category = categoryRepository.findById(id).get();
		
		category.setName(request.getName());
		
		categoryRepository.save(category);
	}

	public void delete(long id) {
		categoryRepository.deleteById(id);
	}
}