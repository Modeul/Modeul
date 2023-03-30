package com.modeul.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modeul.web.entity.StuffDTO;
import com.modeul.web.entity.StuffViewDTO;
import com.modeul.web.repository.StuffRepository;

@Service
public class DefaultStuffService implements StuffService {
	
	@Autowired
	private StuffRepository repository;
	
	public int regStuff(StuffDTO stuffDTO) {
		return repository.insert(stuffDTO);
	}

	@Override
	public List<StuffViewDTO> getViewList() {
		System.out.println(1);
		return repository.findViewAll();
	}

	@Override
	public List<StuffViewDTO> getViewList(Integer categoryId) {
		System.out.println(2);
		return repository.findViewAll(categoryId);
	}
}
