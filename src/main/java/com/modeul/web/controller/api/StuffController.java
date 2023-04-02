package com.modeul.web.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.modeul.web.entity.Stuff;
import com.modeul.web.entity.StuffView;
import com.modeul.web.service.CategoryService;
import com.modeul.web.service.StuffService;

// 데이터만 전송하는 것이 Rest인 것을 까먹음.. 즉, RestController이다.
@RestController("apiMenuController")
@RequestMapping("member/stuffs")
public class StuffController {
	
	@Autowired
	private StuffService service;
	
	
	@Autowired
	private CategoryService categoryService;
	
	// 반환 타입 주의!
	@GetMapping
	public List<StuffView> getList(
			@RequestParam(name="p", defaultValue = "1") int page,		
			@RequestParam(name="c", required=false) Long categoryId
			){
		
		List<StuffView> list = service.getViewAll(categoryId, page);
		
		return list;
				
	}
	
	// 반환 타입 주의!
	// 해결 못함 : detail 페이지의 카테고리 이름 어떻게 뽑아냄?
	// detail 페이지 들어가는 거 router 써야함..
	@GetMapping("{id}")
	public Stuff get(
			@PathVariable("id") long id){
		
		Stuff stuff = service.getById(id);
		
		String categoryName = categoryService.getNameById(stuff.getId());
		
		return stuff;
	}
	
	
	
	
}
