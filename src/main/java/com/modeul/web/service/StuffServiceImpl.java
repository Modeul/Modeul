package com.modeul.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modeul.web.entity.Stuff;
import com.modeul.web.entity.StuffView;
import com.modeul.web.repository.StuffRepository;

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
	public List<StuffView> getViewAll(Integer categoryId, int page) {
		int size = 10;
		int offset = (page-1)*10;
		
		return repository.findViewAll(null, categoryId, null, null, size, offset);
	}

	@Override
	public List<StuffView> getViewAll(String query, Integer categoryId,int page) {
		int size = 10;
		int offset = (page-1)*10;
		
		return repository.findViewAll(query, categoryId, null, null, size, offset);
	}
	
	// 공구상품 글 등록용
	@Override
	public int regStuff(String title, String place, String numPeople, String price, String url,String content) {
		
		return repository.insert(title, place, numPeople, price, url, content);
	}

//	@Override
//	public Stuff getById(Long id) {
//		
//		return repository.findbyId(id);
//	}
	
	
}
