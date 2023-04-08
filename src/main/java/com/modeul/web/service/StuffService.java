package com.modeul.web.service;

import java.util.List;

import com.modeul.web.entity.StuffDTO;
import com.modeul.web.entity.StuffView;

public interface StuffService {
	int regStuff(StuffDTO stuffDTO);

	List<StuffView> getViewList();
}