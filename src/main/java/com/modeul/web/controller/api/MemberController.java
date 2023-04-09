package com.modeul.web.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.modeul.web.entity.Member;
import com.modeul.web.service.MailServiceImpl;
import com.modeul.web.service.MemberService;

@RestController("apiMemberController")
@RequestMapping("members")
public class MemberController {
	
	@Autowired
	private MemberService service;
	@Autowired
	private MailServiceImpl mailService;
	
	@PostMapping
	public int addMember(@RequestBody Member member) {
		
		int memberCount = service.addMember(member);
		return memberCount;
	}

	// 이메일 인증 (RequestParam)
	@PostMapping("mailConfirm")
	@ResponseBody
	public String mailConfirm(@RequestParam("email") String email) throws Exception{
		String code = mailService.sendConfirmMessage(email);
		System.out.println("인증코드 : " + code);
		return code;
	}


}
