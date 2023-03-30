package com.modeul.web.service;

import java.util.List;

import com.modeul.web.entity.Stuff;
import com.modeul.web.entity.StuffView;

public interface StuffService {
	
	int regStuff(String title, String place, String numPeople, String price, String url, String content);
	
	List<StuffView> getViewAll();	// 전체 페이지 목록 조회용
	List<StuffView> getViewAll(int page);	// 페이지 더보기용
	List<StuffView> getViewAll(String query, int page);	// 검색용
	List<StuffView> getViewAll(Integer categoryId, int page);	// 카테고리별 페이지 조회용
	List<StuffView> getViewAll(String query, Integer categoryId, int page);	// 카테고리별 검색용 

//	Stuff getById(Long id);

}
