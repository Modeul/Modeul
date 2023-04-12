package com.modeul.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
		System.out.printf("inserCount: %d",insertCount); 
		
		// 이미지 유효성 검사
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

	@Override
	public List<StuffView> getRecentViewList(Long categoryId, int page) {
		
		int size = page * 7;
		return repository.findViewAll(null, categoryId, "reg_date", "desc", size, 0);
	}

	@Override
	public void deleteStuff(Long id) {
		
		repository.delete(id);
	}
	
	public Long getListCount(Long categoryId, int page) {
		
		Long countList = repository.getCountList(categoryId) - (page * 7);
		Long result = countList <= 0 ? 0 : countList;
		return result;
	}


	/* 공구상품 정보 수정 */
	@Transactional
	@Override
	public int editStuff(Stuff stuff) {

		int updateCount = repository.update(stuff);
		
		if(updateCount == 1 && stuff.getImageList() != null && stuff.getImageList().size() > 0) {
			repository.deleteImage(stuff.getId());
			
			stuff.getImageList().forEach(image -> {
				image.setStuffId(stuff.getId());
				repository.imageUpload(image.getName(), image.getStuffId());
			});
		}
		return updateCount;
	}
	
	



}
