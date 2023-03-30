package com.modeul.web.service;

import java.util.List;

import com.modeul.web.entity.StuffDTO;
import com.modeul.web.entity.StuffViewDTO;

public interface StuffService {
	int regStuff(StuffDTO stuffDTO);

	List<StuffViewDTO> getViewList();
}
