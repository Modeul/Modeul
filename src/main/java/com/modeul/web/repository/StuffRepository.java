package com.modeul.web.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.modeul.web.entity.Stuff;
import com.modeul.web.entity.StuffView;

@Mapper
public interface StuffRepository {
	
	// List<StuffView> findViewAll();	// 나중에 주석처리하기
	
	// 인자가 필요 없을 줄 알았는데 조회하기 위해서 카테고리별 조회나 검색용, 페이저 때문에 필요하다.
	// 조회용으로 데이터를 뽑아 낼 때, 사용하며 
	// 서비스 계층에서는 해당 All를 이용하여 업무상 여러 오버로드 메서스가 준비하여 사용하다.
	List<StuffView> findViewAll(String query, 
								Long categoryId, 
								String orderField, 
								String orderDir,
								Integer size, 
								Integer offset);

	Stuff findbyId(Long id);
	
	// 이것을 Member로 받아도 된다. 단, 생성자를 따로 만들어주어야 한다. 
	// 생성자가 여러 개여도 인자보고 찾아간다.
//	int insert(
//			String title, 
//			String place, 
//			String numPeople, 
//			LocalDateTime deadline,
//			String price, 
//			String url, 
//			String content);
	
	int insert(Stuff stuff);
	
	/* 공구상픔 이미지 등록 */
	int imageUpload(String name, Long stuffId);

	Long getCountList(Long categoryId);

	/* 공구상품 수정 */
	int update(Stuff stuff);	
	
	/* 특정 공구상품의 이미지만 삭제 */
	int deleteImage(Long stuffId);
	
	/* 특정 공구상품 정보 삭제 */
	void delete(Long id);

}
