package com.modeul.web.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

import com.modeul.web.entity.Category;

@AutoConfigureTestDatabase(replace=Replace.NONE)
@MybatisTest
class CategoryRepositoryTest {
	
	@Autowired
	private CategoryRepository repository;
	
	//@Test
	void testfindAll() {
		List<Category> list = repository.findAll();
		System.out.println(list);
	}
	
	@Test
	void testfindNameById() {
		Category categoryName = repository.findNameById(3L);
		System.out.println(categoryName);
	}

}
