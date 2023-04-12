package com.modeul.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.modeul.web.entity.Category;
import com.modeul.web.entity.Stuff;
import com.modeul.web.entity.StuffView;
import com.modeul.web.service.CategoryService;
import com.modeul.web.service.ImageService;
import com.modeul.web.service.StuffService;

import lombok.extern.slf4j.Slf4j;


@Controller
@RequestMapping("/member/stuff")
public class StuffController {
	
	@Autowired
	private StuffService service;	// 이게 메인 서비스이다.
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ImageService imageService;

	@GetMapping("list")
	public String list(
			@RequestParam(name="q", required=false) String query,
			@RequestParam(name="c", required=false) Long categoryId, 
			@RequestParam(name="p", defaultValue="1") int page, Model model) {
		
		List<StuffView> list = service.getViewAll(query, categoryId, page);
		
		List<Category> categoryList = categoryService.getList();
		
		model.addAttribute("list", list);
		model.addAttribute("categoryList", categoryList);
		
		return "member/stuff/list";
	}
	
	@GetMapping("detail")
	public String detail(Long id, Model model) {
		
		// Stuff 객체로 반환 타입을 걸어준 이유는 List는 값을 꺼내기 위해서 index가 필요하지만 
		// id 값으로 그 해당 내용만 조회하는 용도에는 굳이 필요가 없다.
		Stuff stuff = service.getById(id);
		
		// stuff.getCategoryId()가 null 값이라서 확인했더니 
		// CategoryId 칼럼을 resultMap 설정 안했었서 설정 추가함.
		String categoryName = categoryService.getNameById(stuff.getCategoryId());
		
		// reg.html 파일 경로를 물리경로로 다시 수정할 것!
		String imageName = imageService.getNamebyId(stuff.getId());
	
		model.addAttribute("stuff", stuff);
		model.addAttribute("categoryName", categoryName);
		model.addAttribute("imageName", imageName);

		
		return "member/stuff/detail";
	}
	
	@GetMapping("listsearch")
	public String listsearch(
			@RequestParam(name="q", required=false) String query, 
			@RequestParam(name="c", required=false) Long categoryId, 
			@RequestParam(name="p", defaultValue="1") int page, Model model) {
		
		List<StuffView> list = service.getViewAll(query, categoryId, page);
		
		List<Category> categoryList = categoryService.getList();
		
		model.addAttribute("list", list);
		model.addAttribute("categoryList", categoryList);
		
		return "member/stuff/list-search";
	}
	
	
	@GetMapping("reg")
	public String stuffForm() {
		return "member/stuff/reg";
	}
	
	// deadline은 LocalDateTime의 타입으로 추가!!
	// @PostMapping("reg")
	// public String regStuff(
	// 		MultipartFile[] imgs, HttpServletRequest request,
	// 		@RequestParam(name="title") String title,
	// 		@RequestParam(name="place") String place,
	// 		@RequestParam(name="numPeople") String numPeople,
	// 		@RequestParam(name="deadline") LocalDateTime deadline,
	// 		@RequestParam(name="price") String price,
	// 		@RequestParam(name="url") String url,
	// 		@RequestParam(name="content") String content) throws IllegalStateException, IOException {
		
		
	// 	// System.out.println(insert);
		
	// 	System.out.printf("title: %s, place: %s, numPeople :%s, date: %s, price: %s, url: %s, content: %s\n",
	// 			title, place, numPeople, deadline, price, url, content);
		
	// 	List<Image> imageList = new ArrayList<Image>();
		
	// 	// 파일 여러 개 받기  
	// 	for(int i=0; i<imgs.length; i++) {
	// 		MultipartFile img = imgs[i];
			
	// 		// 파일 업로드가 안될 시, 예외 처리
	// 		if(img.isEmpty())
	// 			continue;
			
	// 		// 파일 경로 알아 내기(논리적, 물리적)** : urlPath, realPath 
	// 		String urlPath = "/images/member/stuff/" + img.getOriginalFilename();
	// 		String realPath = request.getServletContext().getRealPath(urlPath);
			
	// 		System.out.printf("%s", realPath);
			
	// 		// 물리 경로에 폴더가 없으면, 폴더도 생성
	// 		File savePath = new File(realPath);
			
	// 		if(!savePath.exists()) 
	// 			savePath.mkdirs();
			
	// 		// 그 물리적 경로로 파일 저장하는 방법**
	// 		img.transferTo(new File(realPath));
	// 		System.out.printf("%s", realPath);
			
			
	// 		// 그 이미지를 DB에 저장하기!!** 
	// 		Image image = new Image();
	// 		image.setName(img.getOriginalFilename());

			
	// 		// ArrayList에 add해서 Image 정보 넣기!
	// 		imageList.add(image);
	// 	}
		
	// 	Stuff stuff = new Stuff(title, place, numPeople, deadline, price, url, content, imageList);
		
	// 	service.regStuff(stuff);
		
	// 	// redirect가 되기 위해서 html의 form 태그의 action, method 맞춰주기!
	// 	return "redirect:list";
	// }

}
