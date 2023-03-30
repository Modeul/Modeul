package com.modeul.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.modeul.web.entity.Category;
import com.modeul.web.service.CategoryService;

@Controller
@RequestMapping("/admin/category")
public class CategoryController {
	
	@Autowired
	private CategoryService service;
	
	@GetMapping("list")
	public String list(Model model) {
		
		List<Category> list = service.getList();
		model.addAttribute("list", list);
		
		return "admin/category/list";
	}

}
