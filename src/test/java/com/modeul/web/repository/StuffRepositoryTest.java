package com.modeul.web.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.modeul.web.entity.StuffVO;

@SpringBootTest
class StuffRepositoryTest {
	
	@Autowired
	StuffRepository repo;

	@Test
	void test() {
		
		StuffVO stuff = new StuffVO();
		
		stuff.setTitle("제목");
		stuff.setPlace("장소");
		stuff.setPrice("가격");
		stuff.setContent("내용1");
		stuff.setCategoryId(1);
		
		System.out.println(stuff);
		
		repo.insert(stuff);
		
		System.out.println(stuff);
	}

}
