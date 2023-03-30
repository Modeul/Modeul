package com.modeul.web.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.modeul.web.entity.StuffDTO;
import com.modeul.web.entity.StuffViewDTO;

@SpringBootTest
class StuffRepositoryTest {

	@Autowired
	StuffRepository repository;
	
	
	@Test
	void test() {
		List<StuffViewDTO> list = repository.findViewAll();
		System.out.println(list);
	}

}
