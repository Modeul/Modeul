package com.modeul.web.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.modeul.web.entity.Category;
import com.modeul.web.service.CategoryService;

@RestController("apiCateogrycontroller")
@RequestMapping("member/stuff/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService service;
	
	// 해결 못함 : list 페이지의 카테고리 버튼 누를때마다 카테고리별 select되는거 어떻게 함?
	@GetMapping
	public List<Category> getList(){
		
		List<Category> list = service.getList();
		
		return list;
	}
	
	// 해결 못함 : detail 페이지의 카테고리 이름 어떻게 뽑아냄?
//	@GetMapping("{id}")
//	public String get(@PathVariable(name="id") Long id){
//		
//		Stuff stuff = new Stuff();
//		
//		String categoryName = service.getNameById(categoryId);
//		
//		return categoryName;
//	}
}
