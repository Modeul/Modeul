package com.modeul.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modeul.web.entity.Image;
import com.modeul.web.repository.ImageRepository;

@Service
public class ImageServiceImpl implements ImageService{
	
	@Autowired
	private ImageRepository repository;
	
	@Override
	public String getNamebyId(Long stuffId) {
		return repository.findById(stuffId).getName();
	}

	@Override
	public Image getbyId(Long stuffId) {
		return repository.findById(stuffId);
	}

	@Override
	public List<Image> getListById(Long stuffId) {
		
		return repository.findListById(stuffId);
	}

	// @Override
	// public List<Image> getList() {
	// 	return repository.findAll();
	// }

}
