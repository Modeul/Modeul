package com.modeul.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modeul.web.entity.Member;
import com.modeul.web.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	MemberRepository repository;
	
	@Override
	public int addMember(Member member) {
		repository.insert(member);
		return 1;
	}

	@Override
	public List<Member> getMemberAll() {
		// TODO Auto-generated method stub
		return null;
	}
}