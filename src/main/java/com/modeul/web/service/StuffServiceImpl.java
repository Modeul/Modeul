package com.modeul.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.modeul.web.entity.Stuff;
import com.modeul.web.entity.StuffView;
import com.modeul.web.repository.StuffRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StuffServiceImpl implements StuffService {
	
	@Autowired
	private StuffRepository repository;
	
	// 공구상품 목록 조회용
	@Override
	public List<StuffView> getViewAll() {
		
		return repository.findViewAll("", null, null, null, 10, 0);
	}

	@Override
	public List<StuffView> getViewAll(int page) {
		int size = 10;
		int offset = (page-1)*10;
		
		return repository.findViewAll("", null, null, null, size, offset);
	}

	@Override
	public List<StuffView> getViewAll(String query, int page) {
		int size = 10;
		int offset = (page-1)*10;
		
		return repository.findViewAll(query, null, null, null, size, offset);
	}
 
	@Override
	public List<StuffView> getViewAll(Long categoryId, int page) {
		int size = 10;
		int offset = (page-1)*10;
		
		return repository.findViewAll(null, categoryId, null, null, size, offset);
	}

	@Override
	public List<StuffView> getViewAll(String query, Long categoryId,int page) {
		int size = 10;
		int offset = (page-1)*10;
		
		return repository.findViewAll(query, categoryId, null, null, size, offset);
	}
	
	// 공구상품 글 등록용, 트랜잭션 처리!
	@Transactional
	@Override
	public void regStuff(Stuff stuff) {

		int insertCount = repository.insert(stuff);
		log.info("insertCount={}", insertCount);
		
		if(stuff.getImageList() == null || stuff.getImageList().size() <= 0) {
			return;
		}
		
		stuff.getImageList().forEach(image -> {
			image.setStuffId(stuff.getId());
			repository.imageUpload(image.getName(), image.getStuffId());
		});
		
	}

	@Override
	public Stuff getById(Long id) {
		
		return repository.findbyId(id);
	}
	
	
}
