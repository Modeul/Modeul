package com.modeul.web.service;

import java.util.List;

import com.modeul.web.entity.Image;

public interface ImageService {
	String getNamebyId(Long stuffId);
	Image getbyId(Long stuffId);
	// List<Image> getList();
	List<Image> getListById(Long stuffId);
}
