package com.modeul.web.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

import com.modeul.web.entity.Stuff;
import com.modeul.web.entity.StuffView;


@AutoConfigureTestDatabase(replace=Replace.NONE)
@MybatisTest
class StuffRepositoryTest {
	
	@Autowired
	private StuffRepository repository;
	
	//@Test
	void testinsert() {
		
		int insertCount = repository.insert("아아 드실분~", "대흥역 앞", "3", "3000", 
				"https://map.naver.com/v5/search/%EB%8C%80%ED%9D%A5%EB%8F%99%20%EC%8A%A4%EB%B2%85/place/99828703?placePath=%3Fentry=pll%26from=nx%26fromNxList=true&c=15,0,0,0,dh",
				"대흥역 앞에서 아아 같이 사드실분 구합니다~");
		
		System.out.println(insertCount);
	}
	
	//@Test
	void testfindViewAll() {
		List<StuffView> list= repository.findViewAll("제", 2, null, null, 10, 0);
		System.out.println(list);
	}
	
//	@Test
//	void testfindbyId() {
//		Stuff stuff= repository.findbyId(8L);
//		System.out.println(stuff);
//	}
}
