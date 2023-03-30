package com.modeul.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class HomeController {

	@GetMapping("index")
	public String index() {
		return "index";
	}

	@GetMapping("login")
	public String login() {
		return "login";
	}

	@GetMapping("sign-up")
	public String signUp() {
		return "sign-up";
	}

	@PostMapping("sign-up")
	public String signup(@RequestParam(name = "uid") String uid, @RequestParam(name = "password") String password,
			@RequestParam(name = "repassword") String repassword, @RequestParam(name = "name") String name,
			@RequestParam(name = "email") String email, @RequestParam(name = "reemail") String reemail) {
		// @RequestParam은 Entity(Member)가 필요 없어도 된다.

		System.out.printf("uid : %s, pw: %s, rpw: %s", uid, password, repassword);

		return "redirect:login";
		// redirect 개념 중요!!
		// 이렇게 redirect하면 html form 태그의 action 속성은 필요 없다
		// 서버에서 처리해주기 때문
	}

}
