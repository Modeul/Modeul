package com.modeul.web.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.AutoConfigureMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.modeul.web.entity.Image;
import com.modeul.web.entity.Stuff;
import com.modeul.web.entity.StuffView;

@SpringBootTest
@AutoConfigureMybatis
class StuffServiceImplTest {

	@Autowired
	private StuffService service;
	
	// 공구 글 수정 테스트
	@Test
	void testeditStuff() {
		
		Stuff stuff = new Stuff();
		
		// 기본값 setting
		stuff.setTitle("아아 드실분~11231312313");
		stuff.setPlace("대흥역 앞");
		stuff.setNumPeople("4");
		stuff.setDeadline(LocalDateTime.now());
		stuff.setPrice("30000");
		stuff.setUrl("https://map.naver.com/v5/search/%EB%8C%80%ED%9D%A5%EB%8F%99%20%EC%8A%A4%EB%B2%85/place/99828703?placePath=%3Fentry=pll%26from=nx%26fromNxList=true&c=15,0,0,0,dh");
		stuff.setContent("대흥역 앞에서 아아 같이 사드실분 구합니다~");
		stuff.setId(365L);

		// Image 리스트를 setting 하기 위해서 리스트 새로 생성하기!
		List<Image> imageList = new ArrayList<Image>();
		
		// 가져온 리스트들을 1개씩 탐색하여 setter로 값 입력해주기
		Image image1 = new Image();
		// Image image2 = new Image();
		
		image1.setStuffId(5L);
		image1.setName("curry-2455846_1920.jpg");
		
		// image2.setStuffId(5L);
		// image2.setName("test image4");
		
		imageList.add(image1);
		//imageList.add(image2);
		
		stuff.setImageList(imageList);
		
		int updateCount = service.editStuff(stuff);
		// service.regStuff("아아 드실분~", "대흥역 앞", "4", LocalDateTime.now(), "3000", "https://map.naver.com/v5/search/%EB%8C%80%ED%9D%A5%EB%8F%99%20%EC%8A%A4%EB%B2%85/place/99828703?placePath=%3Fentry=pll%26from=nx%26fromNxList=true&c=15,0,0,0,dh","대흥역 앞에서 아아 같이 사드실분 구합니다~");
		
		System.out.println("업데이트된 공구상품 글 count : "+ updateCount);
	}

	//@Test
	void testregStuff() {
		
		// 등록에는 무조건 Stuff 객체 사용하기!!
		// Test 코드가 기가 막히게 어렵다..
		
		Stuff stuff = new Stuff();
		
		// 기본값 setting
		stuff.setTitle("아아 드실분~");
		stuff.setPlace("대흥역 앞");
		stuff.setNumPeople("4");
		stuff.setDeadline(LocalDateTime.now());
		stuff.setPrice("30000");
		stuff.setUrl("https://map.naver.com/v5/search/%EB%8C%80%ED%9D%A5%EB%8F%99%20%EC%8A%A4%EB%B2%85/place/99828703?placePath=%3Fentry=pll%26from=nx%26fromNxList=true&c=15,0,0,0,dh");
		stuff.setContent("대흥역 앞에서 아아 같이 사드실분 구합니다~");
		
		// Image 리스트를 setting 하기 위해서 리스트 새로 생성하기!
		List<Image> imageList = new ArrayList<Image>();
		
		// 가져온 리스트들을 1개씩 탐색하여 setter로 값 입력해주기
		Image image1 = new Image();
		Image image2 = new Image();
		
		image1.setStuffId(347L);
		image1.setName("test image3");
		
		image2.setStuffId(5L);
		image2.setName("test image4");
		
		imageList.add(image1);
		imageList.add(image2);
		
		stuff.setImageList(imageList);
		
		service.regStuff(stuff);
		// service.regStuff("아아 드실분~", "대흥역 앞", "4", LocalDateTime.now(), "3000", "https://map.naver.com/v5/search/%EB%8C%80%ED%9D%A5%EB%8F%99%20%EC%8A%A4%EB%B2%85/place/99828703?placePath=%3Fentry=pll%26from=nx%26fromNxList=true&c=15,0,0,0,dh","대흥역 앞에서 아아 같이 사드실분 구합니다~");
		
		System.out.println("등록된 stuffList : "+ stuff);
	}
	
	//@Test
	void testgetViewAll() {
		List<StuffView> list = service.getViewAll("제",2L,1);
		System.out.println(list);
	}
	
	
	//@Test
	void testgetById() {
		Stuff list = service.getById(5L);
		System.out.println(list);
	}

	
}
