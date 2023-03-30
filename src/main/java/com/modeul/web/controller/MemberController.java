package com.modeul.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.modeul.web.service.MemberService;

@Controller
@RequestMapping("/")
public class MemberController {
	
	@Autowired
	private MemberService service;	// 생성자 주입을 안해줘도 되는지?
	
	@GetMapping("login")
	public String login() {
		return "login";	
	}
	
	@GetMapping("signup")
	public String signupForm() {
		return "sign-up";
	}
	
	
	@PostMapping("signup")
	public String createMember(
			@RequestParam(name="uid") String uid,
			@RequestParam(name="password") String password,
			@RequestParam(name="name") String name,
			@RequestParam(name="email") String email,
			@RequestParam(name="nickname") String nickname) {
			// @RequestParam은 Entity(Member)가 필요 없어도 된다. 
		
		int createMember = service.addMember(uid, password, name, email, nickname);
		
		System.out.printf("회원 등록 인원수 : ", createMember);
		
		System.out.printf("uid : %s, pw: %s, nickname: %s", uid, password, nickname);
		
		return "redirect:login";	
		// redirect 개념 중요!
		// 서버에서 처리해주기 때문
	}
	

}





 