package com.modeul.web.repository;

import java.time.LocalDateTime;
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

	// Stuff 등록하기
	@Test
	void testinsert() {
		
		// insert는 무조건 추가 생성자를 만들어서 객체로 이용하자!!
		// 테스트 코드 만들 때, 진짜 힘들다!
		
		Stuff stuff = new Stuff();
		
		stuff.setTitle("아아 드실분~");
		stuff.setPlace("대흥역 앞");
		stuff.setNumPeople("4");
		stuff.setDeadline(LocalDateTime.now());
		stuff.setPrice("30000");
		stuff.setUrl("https://map.naver.com/v5/search/%EB%8C%80%ED%9D%A5%EB%8F%99%20%EC%8A%A4%EB%B2%85/place/99828703?placePath=%3Fentry=pll%26from=nx%26fromNxList=true&c=15,0,0,0,dh");
		stuff.setContent("대흥역 앞에서 아아 같이 사드실분 구합니다~");
		
		System.out.println("BeforeStuff : " + stuff);
		
		//int insertCount = repository.insert(stuff.getTitle(),stuff.getPlace(),stuff.getNumPeople(),stuff.getDeadline(),stuff.getPrice(),stuff.getUrl(),stuff.getContent());
		int insertCount = repository.insert(stuff);
		System.out.println(insertCount);
		
		
		System.out.println("AfterStuff : " + stuff);
		

	}
	
	// 사진 업로드
	//@Test
	void testimageUpload() {
		
		int imageUpload = repository.imageUpload("test.png",5L);
		System.out.println(imageUpload);
	}
	
	//@Test
	void testfindViewAll() {
		List<StuffView> list= repository.findViewAll("제", 2L, null, null, 10, 0);
		System.out.println(list);
	}
	
	//@Test
	void testfindbyId() {
		Stuff stuff= repository.findbyId(8L);
		System.out.println(stuff);
	}
	

}
