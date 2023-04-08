package com.modeul.web.service;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.AutoConfigureMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.modeul.web.entity.Member;

// Service 계층이라서 직접적으로 Mybatis를 사용하지 않는다. 그래서, @SpringBootTest로 단위 테스트를 한다.
// 그래도 ORM을 Mybatis이라서 @SpringBootTest를 하면 @AutoConfigure라는 Mybatis 연결을 해줘야 한다.

@SpringBootTest
@AutoConfigureMybatis
class MemberServiceImplTest {
	
	@Autowired
	private MemberService service;
	
	@Test
	void testaddMember() {
		// insert는 객체로 받는 게 맞다. 나중에 수정할 때 유리하다.
		Member member = new Member();
		
		member.setUid("다작시");
		member.setPwd("31123");
		member.setName("나플라라");
		member.setEmail("qwesay@hanmail.net");
		member.setNickname("asddfgdfg");
		
		int count = service.addMember(member);
		System.out.println(count);
		
	}

}
