package com.modeul.web.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.modeul.web.entity.StuffVO;
import com.modeul.web.entity.StuffViewDTO;

@Mapper
public interface StuffRepository {
	
	int insert(StuffVO stuffVO);
	
	List<StuffViewDTO> findViewAll();
}
