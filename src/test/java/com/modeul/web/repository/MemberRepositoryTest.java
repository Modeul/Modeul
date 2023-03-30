package com.modeul.web.repository;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

// Repository 계층이라서 MybatisTest로 하는 것이 맞다. 하지만 이것은 에러가 많다.
// 하지만, Service 계층에서는 Mybatis를 직접적으로 사용하지 않아서 @SpringBootTest를 이용한다.

@AutoConfigureTestDatabase(replace=Replace.NONE)
@MybatisTest
class MemberRepositoryTest {

	@Autowired
	private MemberRepository repository;
	
	@Test
	void testcreateMember() {
		int count = repository.insert("다작시", "31123", "플라라", "qwesay@hanmail.net", "asddfgdfg");
		System.out.println(count);
	}

}
