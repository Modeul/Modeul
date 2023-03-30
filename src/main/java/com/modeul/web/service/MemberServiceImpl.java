package com.modeul.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modeul.web.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberRepository repository;
	

	@Override
	public int addMember(String uid, String password, String name, String email, String nickname) {
		return repository.insert(uid, password, name, email, nickname);
	}


}
