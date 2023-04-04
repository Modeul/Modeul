package com.modeul.web.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.modeul.web.entity.Category;

@Mapper
public interface CategoryRepository {
	List<Category> findAll();
	
	// id 값에 의한 다른 칼럼을 출력하기 위해서 보통 객체로 반환값을 받는다. 
	Category findNameById(Long categoryId);
}
