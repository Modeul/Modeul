package com.modeul.web.controller.member.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.modeul.web.entity.Category;
import com.modeul.web.entity.StuffDTO;
import com.modeul.web.entity.StuffView;
import com.modeul.web.service.CategoryService;
import com.modeul.web.service.StuffService;

@RestController("apiStuffController")
@RequestMapping("/stuff")
public class StuffController {
	
	@Autowired
	StuffService service;

	@Autowired
	CategoryService categoryService;
	
	@GetMapping
	public Map<String, Object> list(Model model) {
		List<StuffView> list = service.getViewList();
		List<Category> categoryList = categoryService.getList();
		
		Map<String, Object> data = new HashMap<>();
		data.put("list", list);
		data.put("categoryList", categoryList);
		
		return data;
	}
	
	@GetMapping("reg")
	public String reg() {
		return "member/stuff/reg";
	}

	@PostMapping
	public String regStuff(@ModelAttribute StuffDTO stuffDTO) {

		System.out.println(stuffDTO);
		
		System.out.println(stuffDTO.getStuff());
		
		System.out.println(stuffDTO.getImageList().get(0).getOriginalFilename());

		service.regStuff(stuffDTO);

		return "ok";
	}
}
