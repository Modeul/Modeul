package com.modeul.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.modeul.web.entity.Category;
import com.modeul.web.entity.Stuff;
import com.modeul.web.entity.StuffView;
import com.modeul.web.service.CategoryService;
import com.modeul.web.service.StuffService;

@Controller
@RequestMapping("/member/stuff")
public class StuffController {
	
	@Autowired
	private StuffService service;	// 이게 메인 서비스이다.
	
	@Autowired
	private CategoryService categoryService;

	@GetMapping("list")
	public String list(
			@RequestParam(value="q", required=false) String query, 
			@RequestParam(value="c", required=false) Integer categoryId, 
			@RequestParam(value="p", defaultValue="1") int page, Model model) {
		
		List<StuffView> list = service.getViewAll(query, categoryId, page);
		
		List<Category> categoryList = categoryService.getList();
		
		model.addAttribute("list", list);
		model.addAttribute("categoryList", categoryList);
		
		return "member/stuff/list";
	}
	
//	@GetMapping("detail")
//	public String detail(Long id, Model model) {
//		
//		Stuff stuff = service.getById(id);
//		
//		model.addAttribute("stuff", stuff);
//		
//		return "member/stuff/detail";
//	}
	
	
	@GetMapping("reg")
	public String stuffForm() {
		return "member/stuff/reg";
	}
	
	@PostMapping("reg")
	public String regStuff(
			@RequestParam(name="title") String title,
			@RequestParam(name="place") String place,
			@RequestParam(name="numPeople") String numPeople,
			@RequestParam(name="price") String price,
			@RequestParam(name="url") String url,
			@RequestParam(name="content") String content) {
		
		
		int insert = service.regStuff(title, place, numPeople, price, url, content);
		
		System.out.println(insert);
		
		System.out.printf("title: %s, place: %s, numPeople :%s, price: %s, url: %s, content: %s\n",
				title, place, numPeople, price, url, content);
		
		// redirect가 되기 위해서 html의 form 태그의 action, method 맞춰주기!
		return "redirect:list";
	}
	
}
