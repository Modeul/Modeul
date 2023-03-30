package com.modeul.web.repository;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberRepository {

	int insert(String uid, String password, String name, String email, String nickname);
	
}
