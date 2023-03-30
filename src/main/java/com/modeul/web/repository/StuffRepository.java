package com.modeul.web.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.modeul.web.entity.StuffDTO;
import com.modeul.web.entity.StuffViewDTO;

@Mapper
public interface StuffRepository {
	
	int insert(StuffDTO stuffDTO);

	List<StuffViewDTO> findViewAll();
	
	
}
