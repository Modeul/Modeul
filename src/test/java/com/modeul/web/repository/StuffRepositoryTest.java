package com.modeul.web.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StuffRepositoryTest {
	
	@Autowired
	StuffRepository repo;

	@Test
	void test() {
		System.out.println(repo.findViewAll());
		
	}

}
