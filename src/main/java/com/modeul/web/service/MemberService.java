package com.modeul.web.service;

import com.modeul.web.entity.Member;

public interface MemberService {
	

	int addMember(Member member);
	
	Boolean checkUid(String uid);

	Boolean checkEmail(String email);

	Boolean checkNickname(String nickname);
	
}

