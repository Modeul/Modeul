package com.modeul.web.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.modeul.web.entity.Stuff;
import com.modeul.web.entity.StuffView;

@Mapper
public interface StuffRepository {
	
	int insert(Stuff Stuff);
	
	int insertImage(Map<String, Object> imageMap);
	
	List<StuffView> findViewAll();

}
