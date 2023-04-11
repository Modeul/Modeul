package com.modeul.web.controller.api;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.modeul.web.entity.Category;
import com.modeul.web.entity.Image;
import com.modeul.web.entity.Stuff;
import com.modeul.web.entity.StuffView;
import com.modeul.web.service.CategoryService;
import com.modeul.web.service.ImageService;
import com.modeul.web.service.StuffService;

// 데이터만 전송하는 것이 Rest인 것을 까먹음.. 즉, RestController이다.
@RestController("apiMenuController")
@RequestMapping("member/stuffs")
public class StuffController {
	
	@Autowired
	private StuffService service;
	
	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ImageService imageService;

	// 반환 타입 주의!
	@GetMapping
	public Map<String,Object> getList(
			@RequestParam(name="p", defaultValue = "1") int page,		
			@RequestParam(name="c", required=false) Long categoryId
			){
		
//		List<StuffView> list = service.getViewAll(categoryId, page);
		// 3중 조인 필수..
		List<StuffView> list = service.getRecentViewList(categoryId, page);
		List<Category> categoryList = categoryService.getList();

		Map<String, Object> dataList = new HashMap<>();
		dataList.put("list", list);
		dataList.put("categoryList", categoryList);

		return dataList;
	}

	@GetMapping("categories")
	public List<Category> getCategoryList(){
		
		List<Category> categoryList = categoryService.getList();
		
		return categoryList;
	}

	@GetMapping("{id}")
	public Map<String, Object> get(
			@PathVariable("id") long id){
		
		Stuff stuff = service.getById(id);
		Category category = categoryService.getById(stuff.getCategoryId());
		Image image = imageService.getbyId(stuff.getId());

		Map<String, Object> data = new HashMap<>();
		data.put("stuff",stuff);
		data.put("image",image);
		data.put("category",category);

		return data;
	}
	
	// ======================== 추후에 카테고리 Id 추가 ===========================
	
	// post 요청은 먼저 JS로 와서 JS가 해당 RESTAPI url로 
	// 요청 바디에 데이터를 실어서 해당 요청 바디에 대한 서버의 응답 데이터를 요청하고 
	// 그 응답 데이터를 받아와서 비교해서 그다음을 동작 시킨다!

	@PostMapping("upload")
	public String regStuff(
			@RequestBody MultipartFile[] imgs, MultipartHttpServletRequest request,
			@RequestParam(name="title") String title,
			@RequestParam(name="place") String place,
			@RequestParam(name="numPeople") String numPeople,
			//@RequestParam(name="categoryId") String categoryId,
			@RequestParam(name="deadline") LocalDateTime deadline,
			@RequestParam(name="price") String price,
			@RequestParam(name="url") String url,
			@RequestParam(name="content") String content) throws IllegalStateException, IOException {
		
		// System.out.printf("title: %s, place: %s, numPeople :%s, categoryId: %s,date: %s, price: %s, url: %s, content: %s\n",
		// 		title, place, numPeople, categoryId, deadline, price, url, content);
		
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
		stuff.setImageList(imageList);

		System.out.println(stuff);
		service.regStuff(stuff);
		
		return "ok";
	}
		
	@PutMapping("{id}")
	public String updateStuff(
			@RequestBody MultipartFile[] imgs, MultipartHttpServletRequest request,
			@RequestParam(name="title") String title,
			@RequestParam(name="place") String place,
			@RequestParam(name="numPeople") String numPeople,
			//@RequestParam(name="categoryId") String categoryId,
			@RequestParam(name="deadline") LocalDateTime deadline,
			@RequestParam(name="price") String price,
			@RequestParam(name="url") String url,
			@RequestParam(name="content") String content) throws IllegalStateException, IOException {
		
		// System.out.printf("title: %s, place: %s, numPeople :%s, categoryId: %s,date: %s, price: %s, url: %s, content: %s\n",
		// 		title, place, numPeople, categoryId, deadline, price, url, content);
		
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
		stuff.setImageList(imageList);

		System.out.println(stuff);
		service.updateStuff(stuff);
		
		return "ok";
	}

	// @PutMapping("{id}")
	// public String updateStuff(
	// 	@PathVariable("id") Long id){
	// 		service.updateStuff(id);
	// 		return "menu edit";
	// 	}
	

	@DeleteMapping("{id}")
	public String deleteStuff(
			@PathVariable("id") Long id){
				service.deleteStuff(id);
		return "menu del:";		
	}
	
	

	

}
