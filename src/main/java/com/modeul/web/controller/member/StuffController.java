package com.modeul.web.controller.member;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.modeul.web.entity.Category;
import com.modeul.web.entity.StuffDTO;
import com.modeul.web.entity.StuffVO;
import com.modeul.web.entity.StuffViewDTO;
import com.modeul.web.service.CategoryService;
import com.modeul.web.service.StuffService;

@Controller
@RequestMapping("member/stuff")
public class StuffController {

	@Autowired
	StuffService service;

	@Autowired
	CategoryService categoryService;

	@GetMapping("list")
	public String list(Model model) {

		List<StuffViewDTO> list = service.getViewList();
		List<Category> categoryList = categoryService.getList();

		model.addAttribute("list", list);
		model.addAttribute("categoryList", categoryList);

		return "member/stuff/list";
	}

	@GetMapping("reg")
	public String reg() {
		return "member/stuff/reg";
	}

	@PostMapping("reg")
	public String regStuff(StuffVO stuffVO) {

		service.regStuff(stuffVO);

		return "redirect:list";
	}

	@GetMapping("detail")
	public String detail() {
		return "member/stuff/detail";
	}

	@GetMapping("gps")
	public String gps() {
		return "member/stuff/gps";
	}

	@GetMapping("list-search")
	public String listSearch() {
		return "member/stuff/list-search";
	}

}
