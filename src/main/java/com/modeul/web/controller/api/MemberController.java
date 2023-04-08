package com.modeul.web.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.modeul.web.entity.Member;
import com.modeul.web.service.MemberService;

@RestController("apiMemberController")
@RequestMapping("members")
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@PostMapping
	public int addMember(@RequestBody Member member) {
		
		int memberCount = service.addMember(member);
		return memberCount;
	}

}
