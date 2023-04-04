package com.modeul.web.service;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.AutoConfigureMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@AutoConfigureMybatis
class ImageServiceImplTest {
	
	@Autowired
	private ImageService service;
	
	
	@Test
	void testgetNamebyId() {
		
		String ImageName = service.getNamebyId(5L);
		System.out.println(ImageName);
	}

}
