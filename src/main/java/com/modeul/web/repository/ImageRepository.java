package com.modeul.web.repository;

import org.apache.ibatis.annotations.Mapper;

import com.modeul.web.entity.StuffVO;

@Mapper
public interface ImageRepository {
	int insert(String fileName);

}
