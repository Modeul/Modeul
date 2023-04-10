package com.modeul.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modeul.web.entity.Member;
import com.modeul.web.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberRepository repository;


	@Override
	public int addMember(Member member) {
		return repository.insert(member);
	}
	
	@Override
	public Boolean checkUid(String uid) {
		String getUid = repository.getbyUid(uid);
		Boolean result = (getUid != null) ? false : true;

		return result;
	}

	@Override
	public Boolean checkEmail(String email) {
		String getEmail = repository.getByEmail(email);
		Boolean result = (getEmail != null) ? false : true;

		return result;
	}

	@Override
	public Boolean checkNickname(String nickname) {
		String getNickname = repository.getByNickname(nickname);
		Boolean result = (getNickname != null) ? false : true;

		return result;
	}


}
