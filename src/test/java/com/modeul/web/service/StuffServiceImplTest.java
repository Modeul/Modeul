package com.modeul.web.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.AutoConfigureMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.modeul.web.entity.Stuff;
import com.modeul.web.entity.StuffView;

@SpringBootTest
@AutoConfigureMybatis
class StuffServiceImplTest {

	@Autowired
	private StuffService service;
	
	//@Test
	void testregStuff() {
		int regCount = service.regStuff("아아 드실분~", "대흥역 앞", "3", "3000", "https://map.naver.com/v5/search/%EB%8C%80%ED%9D%A5%EB%8F%99%20%EC%8A%A4%EB%B2%85/place/99828703?placePath=%3Fentry=pll%26from=nx%26fromNxList=true&c=15,0,0,0,dh","대흥역 앞에서 아아 같이 사드실분 구합니다~");
		System.out.println(regCount);
	}
	
	//@Test
	void testgetViewAll() {
		List<StuffView> list = service.getViewAll("제",2,1);
		System.out.println(list);
	}
	
	
//	@Test
//	void testgetById() {
//		Stuff list = service.getById(5L);
//		System.out.println(list);
//	}

}
