package com.modeul.web.service;

import java.util.List;

import com.modeul.web.entity.Category;

public interface CategoryService {
	List<Category> getList();
	
	// id 값에 의한 다른 칼럼을 출력하기 위해서 보통 객체로 반환값을 받는다. 
	String getNameById(Long categoryId);
}
