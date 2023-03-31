package com.modeul.web.service;

import java.util.List;

import com.modeul.web.entity.StuffVO;
import com.modeul.web.entity.StuffViewDTO;

public interface StuffService {
	int regStuff(StuffVO stuffVO);

	List<StuffViewDTO> getViewList();
}