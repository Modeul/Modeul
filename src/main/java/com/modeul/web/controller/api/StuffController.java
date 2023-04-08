package com.modeul.web.controller.api;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.modeul.web.entity.Category;
import com.modeul.web.entity.Image;
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
		
//		List<StuffView> list = service.getViewAll(categoryId, page);
		List<StuffView> list = service.getRecentViewList(categoryId, page);
		
		return list;
	}

	@GetMapping("categories")
	public List<Category> getCategoryList(){
		
		List<Category> categoryList = categoryService.getList();
		
		return categoryList;
	}
	
	// 반환 타입 주의!
	// 해결 못함 : detail 페이지의 카테고리 이름 어떻게 뽑아냄?
	// detail 페이지 들어가는 거 router 써야함..
	@GetMapping("{id}")
	public Stuff get(
			@PathVariable("id") long id){
		
		Stuff stuff = service.getById(id);
		
//		String categoryName = categoryService.getNameById(stuff.getId());
		
		return stuff;
	}
	
	// 파일 업로드 AJAX처리(썸네일용)
	// @PostMapping("uploadimage")
	// public List<Image> uploadImage(MultipartFile[] imgs, MultipartHttpServletRequest request) throws IllegalStateException, IOException {
		
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
			
	// 		System.out.printf("%s\n\n", realPath);
			
	// 		// 물리 경로에 폴더가 없으면, 폴더도 생성
	// 		File savePath = new File(realPath);
			
	// 		if(!savePath.exists()) 
	// 			savePath.mkdirs();
			
	// 		// 그 물리적 경로로 파일 저장하는 방법**
	// 		img.transferTo(new File(realPath));
	// 		System.out.printf("%s\n\n", realPath);
			
			
	// 		// 그 이미지를 DB에 저장하기!!** 
	// 		Image image = new Image();
	// 		image.setName(img.getOriginalFilename());

			
	// 		// ArrayList에 add해서 Image 정보 넣기!
	// 		imageList.add(image);
			
	// 	}
	// 	System.out.println(imageList);

	// 	// service.regStuff(stuff);
	// 	return imageList;
	// }

	// ======================== 추후에 카테고리 Id 추가 ===========================
	
	// post 요청은 먼저 JS로 와서 JS가 해당 RESTAPI url로 
	// 요청 바디에 데이터를 실어서 해당 요청 바디에 대한 서버의 응답 데이터를 요청하고 
	// 그 응답 데이터를 받아와서 비교해서 그다음을 동작 시킨다!

	@PostMapping("upload")
	public String regStuff(
			@RequestParam MultipartFile[] imgs, MultipartHttpServletRequest request,
			@RequestParam(name="title") String title,
			@RequestParam(name="place") String place,
			@RequestParam(name="numPeople") String numPeople,
			@RequestParam(name="deadline") LocalDateTime deadline,
			@RequestParam(name="price") String price,
			@RequestParam(name="url") String url,
			@RequestParam(name="content") String content) throws IllegalStateException, IOException {
		
		// System.out.println(insert);
		
		System.out.printf("title: %s, place: %s, numPeople :%s, date: %s, price: %s, url: %s, content: %s\n",
				title, place, numPeople, deadline, price, url, content);
		
		List<Image> imageList = new ArrayList<Image>();
		
		// 파일 여러 개 받기  
		for(int i=0; i<imgs.length; i++) {
			MultipartFile img = imgs[i];
			
			// 파일 업로드가 안될 시, 예외 처리
			if(img.isEmpty())
				continue;
			
			// 파일 경로 알아 내기(논리적, 물리적)** : urlPath, realPath 
			String urlPath = "/images/member/stuff/" + img.getOriginalFilename();
			String realPath = request.getServletContext().getRealPath(urlPath);
			
			System.out.printf("%s", realPath);
			
			// 물리 경로에 폴더가 없으면, 폴더도 생성
			File savePath = new File(realPath);
			
			if(!savePath.exists()) 
				savePath.mkdirs();
			
			// 그 물리적 경로로 파일 저장하는 방법**
			img.transferTo(new File(realPath));
			System.out.printf("%s", realPath);
			
			
			// 그 이미지를 DB에 저장하기!!** 
			Image image = new Image();
			image.setName(img.getOriginalFilename());

			
			// ArrayList에 add해서 Image 정보 넣기!
			imageList.add(image);
		}
		
		Stuff stuff = new Stuff(title, place, numPeople, deadline, price, url, content, imageList);
		// stuff(title, place, numPeople, deadline, price, url, content, imageList);
		
		// 여기가 중요!!
		// stuff.setImageList(imageList);	// 여기가 중요!!

		System.out.println(stuff);
		service.regStuff(stuff);
		
		// redirect가 되기 위해서 html의 form 태그의 action, method 맞춰주기!
		return "ok";
	}

	// @PostMapping
	// public String insert(@RequestBody Stuff stuff) {
		
	// 	System.out.println(stuff); 
	// 	service.regStuff(stuff);
	// 	return "ok";
	// }
		
}
