package com.modeul.web.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class HomeController {
	
	// 파일 업로드
//	@PostMapping("reg")	// 이게 맞나? upload인가?
//	@ResponseBody
//	public String upload(MultipartFile[] imgs, HttpServletRequest request) throws IllegalStateException, IOException {
//		
//		// 파일 여러 개 받기  
//		for(int i=0; i<imgs.length; i++) {
//			MultipartFile img = imgs[i];
//			
//			// 파일 업로드가 안될 시, 예외 처리
//			if(img.isEmpty())
//				continue;
//			
//			// 파일 경로 알아 내기(논리적, 물리적)** : urlPath, realPath 
//			String urlPath = "/images/member/stuff/" + img.getOriginalFilename();
//			String realPath = request.getServletContext().getRealPath(urlPath);
//			
//			System.out.println(realPath);
//			
//			// 그 물리적 경로로 파일 저장하는 방법**
//			// img.transferTo(new File(realPath));
//			
//			// System.out.println(realPath);
//		}
//		return "ok";
//	}
	
	@GetMapping("index")
	public String index() {
		
		return "index";
	}
	
	
	
}
