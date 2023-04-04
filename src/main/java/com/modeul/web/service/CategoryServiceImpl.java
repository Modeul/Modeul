package com.modeul.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modeul.web.entity.Category;
import com.modeul.web.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	@Override
	public List<Category> getList() {
		return repository.findAll();
	}
	
	// Category 객체로부터 이름만 받기 위해서 getter 이용하기!
	@Override
	public String getNameById(Long categoryId) {
		return repository.findNameById(categoryId).getName();
	}
	

}
