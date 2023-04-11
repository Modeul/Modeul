package com.modeul.web.service;

import java.util.List;

import com.modeul.web.entity.Stuff;
import com.modeul.web.entity.StuffView;

public interface StuffService {
	
	// 레코드 행이 2개로 반환 되어서 List<Stuff> 형으로 타입 바꾸기
	void regStuff(Stuff stuff);
	
	List<StuffView> getViewAll();	// 전체 페이지 목록 조회용
	List<StuffView> getViewAll(int page);	// 페이지 더보기용
	List<StuffView> getViewAll(String query, int page);	// 검색용
	List<StuffView> getViewAll(Long categoryId, int page);	// 카테고리별 페이지 조회용
	List<StuffView> getViewAll(String query, Long categoryId, int page);	// 카테고리별 검색용 

	List<StuffView> getRecentViewList(Long categoryId, int page);
	
	Stuff getById(Long id);

	void updateStuff(Stuff stuff);

	void deleteStuff(Long id);

}
