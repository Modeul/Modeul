package com.modeul.web.controller.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.modeul.web.entity.Category;
import com.modeul.web.entity.StuffDTO;
import com.modeul.web.entity.StuffViewDTO;
import com.modeul.web.service.CategoryService;
import com.modeul.web.service.StuffService;

@Controller
@RequestMapping("member/stuff")
public class StuffController2 {

	@Autowired
	StuffService service;

	@Autowired
	CategoryService categoryService;

	@GetMapping("listt")
	public String list(Model model, @RequestParam(name = "c", required = false) String c) {

		List<StuffViewDTO> list = service.getViewList();
		List<Category> categoryList = categoryService.getList();

		model.addAttribute("list", list);
		model.addAttribute("categoryList", categoryList);

		return "member/stuff/list";
	}

	@GetMapping("regg")
	public String reg(StuffDTO stuffDTO) {
		return "member/stuff/reg";
	}

	@PostMapping("regg")
	public String regStuff(StuffDTO stuffDTO) {

//		ImageVO imageVO = new ImageVO(file.getOriginalFilename());

		System.out.println(stuffDTO);

//		service.regStuff(stuffDTO);

		return "redirect:list";
	}

	@GetMapping("detaill")
	public String detail() {
		return "member/stuff/detail";
	}

	@GetMapping("gpss")
	public String gps() {
		return "member/stuff/gps";
	}

	@GetMapping("list-searchh")
	public String listSearch() {
		return "member/stuff/list-search";
	}

}
