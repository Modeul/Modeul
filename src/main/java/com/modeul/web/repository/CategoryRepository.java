package com.modeul.web.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.modeul.web.entity.Category;

@Mapper
public interface CategoryRepository {
	List<Category> findAll();
}
