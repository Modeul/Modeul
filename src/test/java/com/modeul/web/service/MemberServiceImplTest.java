package com.modeul.web.service;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.AutoConfigureMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

// Service 계층이라서 직접적으로 Mybatis를 사용하지 않는다. 그래서, @SpringBootTest로 단위 테스트를 한다.
// 그래도 ORM을 Mybatis이라서 @SpringBootTest를 하면 @AutoConfigure라는 Mybatis 연결을 해줘야 한다.

@SpringBootTest
@AutoConfigureMybatis
class MemberServiceImplTest {
	
	@Autowired
	private MemberService service;
	
	@Test
	void testcreateMember() {
		int count = service.addMember("다시시작2", "31123", "시시작", "dtyhty@gmail.com", "dtyhty2");
		System.out.println(count);
	}

}
