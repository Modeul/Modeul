package com.modeul.web.controller.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.modeul.web.entity.Category;
import com.modeul.web.entity.Image;
import com.modeul.web.entity.Member;
import com.modeul.web.entity.Stuff;
import com.modeul.web.entity.StuffView;
import com.modeul.web.service.CategoryService;
import com.modeul.web.service.ImageService;
import com.modeul.web.service.MemberService;
import com.modeul.web.service.StuffService;

@RestController("apiStuffController")
@RequestMapping("member/stuffs")
public class StuffController{
	
	@Autowired
	public StuffService service;
	@Autowired
	public CategoryService categoryService;
	@Autowired
	public ImageService imageService;
	@Autowired
	public MemberService memberService;


	@GetMapping("reg")
	public String stuffForm() {
		return "member/stuff/reg";
	}

	@PostMapping("signup")
	public void signUp(@RequestBody Member member){
		memberService.addMember(member);
		System.out.println("회원가입 서비스 실행");
	}

	@PostMapping
	public void insert(@RequestBody Stuff stuff, @RequestParam MultipartFile[] uploadfile) {
		System.out.println("파일 이름 : " + uploadfile[0].getOriginalFilename());
		System.out.println("파일 타입 : " + uploadfile[0].getContentType());
		System.out.println("파일 크기 : " + uploadfile[0].getSize());
		
		service.regStuff2(stuff);
		// return "redirect:list";
	}
	@PostMapping(path = "/uploadImg")
	public void insertFile(@RequestBody Stuff stuff,@RequestBody MultipartFile[] imgs) {

		// 이미지 정보 담는 객체
		List<Image> imageList = new ArrayList<Image>();
		
		for(int i = 0; i < imgs.length; i++){
			
			MultipartFile img = imgs[i];
			
			if(img.isEmpty())
			continue;
			
			// 이미지 정보 객체
			Image image = new Image();
			image.setName(imgs[i].getOriginalFilename());
			
			// image.setStuffId((long)2);

			System.out.println("파일 이름 : " + imgs[i].getOriginalFilename());
			System.out.println("파일 타입 : " + imgs[i].getContentType());
			System.out.println("파일 크기 : " + imgs[i].getSize());
			imageList.add(image);
		}
		System.out.println(stuff);
		
		// service.regStuff2(stuff);

		// imageService.insert(image);
	}
	@PostMapping("/uploadImg2")
	public void insertFile(MultipartFile imgs) {

		// 이미지 정보 담는 객체
		// List<Image> list = new ArrayList();
		Image image = new Image();
		image.setName(imgs.getOriginalFilename());
		image.setStuffId((long)2);
		// for(int i = 0; i < imgs.length; i++){
		// 	// 이미지 정보 객체
		// 	image.setName(imgs[i].getOriginalFilename());
		// 	image.setStuffId((long)2);
		// 	System.out.println("파일 이름 : " + imgs[i].getOriginalFilename());
		// 	System.out.println("파일 타입 : " + imgs[i].getContentType());
		// 	System.out.println("파일 크기 : " + imgs[i].getSize());
		// }
		imageService.insert(image);
	}

	@GetMapping
	public List<StuffView> getList(
		@RequestParam(name = "c", required = false) Integer categoryId) {
		
		// List<Category> categoryList = categoryService.getList();
		List<StuffView> list = service.getViewList(categoryId);

		// model.addAttribute("categoryList", categoryList);
		// model.addAttribute("list", list);

		// return "member/stuff/list";
		return list;
	}
	@GetMapping("categories")
	public List<Category> getCategoryList(
		@RequestParam(name = "c", required = false) Integer categoryId) {
		
		List<Category> categoryList = categoryService.getList();

		return categoryList;
	}
	// @GetMapping("detail")
	// public Stuff detail(@PathVariable("id") Long id) {

	// 	Stuff stuff = service.getById(id);
	// 	String categoryName = categoryService.getNameById(stuff.getCategoryId());

	// 	return stuff;
	// }

	@GetMapping("{id}")
	public Stuff detail(@PathVariable("id") Long id) {
		
		Stuff stuff = service.getById(id);
		System.out.println(stuff);

		return stuff;
	}
	
}

	
	// @PostMapping
	// public String regStuff(
	// 		@RequestParam(name="title") String title,
	// 		@RequestParam(name="place") String place,
	// 		@RequestParam(name="numPeople") String numPeople,
	// 		@RequestParam(name="deadline") LocalDateTime deadline,
	// 		@RequestParam(name="price") String price,
	// 		@RequestParam(name="url") String url,
	// 		@RequestParam(name="content") String content
	// 		) {

	// 	return "redirect:list";
	// }