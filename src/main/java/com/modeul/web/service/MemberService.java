package com.modeul.web.service;

import java.util.List;

import com.modeul.web.entity.Member;

public interface MemberService{
	
	int addMember(Member member);
	List<Member> getMemberAll();
//	int findUidDuplicate();
	
}