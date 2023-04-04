package com.modeul.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modeul.web.repository.ImageRepository;

@Service
public class ImageServiceImpl implements ImageService{
	
	@Autowired
	private ImageRepository repository;
	
	@Override
	public String getNamebyId(Long stuffId) {
		
		return repository.findById(stuffId).getName();
	}


}
