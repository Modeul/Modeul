package com.modeul.web.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.AutoConfigureMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.modeul.web.entity.Category;

@AutoConfigureMybatis
@SpringBootTest
class CategoryServiceImplTest {

	@Autowired
	private CategoryService service;
	
	@Test
	void testgetList() {
		List<Category> list = service.getList();
		System.out.println(list);
	}

}
