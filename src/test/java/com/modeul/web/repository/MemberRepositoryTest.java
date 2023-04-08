package com.modeul.web.repository;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

import com.modeul.web.entity.Member;

// Repository 계층이라서 MybatisTest로 하는 것이 맞다. 하지만 이것은 에러가 많다.
// 하지만, Service 계층에서는 Mybatis를 직접적으로 사용하지 않아서 @SpringBootTest를 이용한다.

@AutoConfigureTestDatabase(replace=Replace.NONE)
@MybatisTest
class MemberRepositoryTest {

	@Autowired
	private MemberRepository repository;

	@Test
	void testinsert() {
		
		// insert는 객체로 받는 게 맞다. 나중에 수정할 때 유리하다.
		Member member = new Member();
		
		member.setUid("다작시");
		member.setPwd("31123");
		member.setName("나플라라");
		member.setEmail("qwesay@hanmail.net");
		member.setNickname("asddfgdfg");
		
		//int count = repository.insert(member.getUid(),member.getPwd(),member.getName(),member.getEmail(),member.getNickname());
		int count = repository.insert(member);
		System.out.println(count);
	}


}
