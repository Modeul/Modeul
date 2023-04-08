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


}
