package com.modeul.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modeul.web.entity.Category;
import com.modeul.web.repository.CategoryRepository;

@Service
public class DefaultCategoryService implements CategoryService {
	
	@Autowired
	CategoryRepository repository;
	
	@Override
	public List<Category> getList() {
		return repository.findAll();
	}
	
}
