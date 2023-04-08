package com.modeul.web.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.modeul.web.entity.Member;

@Mapper
public interface MemberRepository{
	int insert(Member member);
	Member findMemberById();
	List<Member> findMemberAll();
//	int findUidDuplicate();
}