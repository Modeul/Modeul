package com.modeul.web.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.modeul.web.entity.StuffVO;
import com.modeul.web.entity.StuffViewDTO;
import com.modeul.web.repository.ImageRepository;
import com.modeul.web.repository.StuffRepository;

@Service
public class DefaultStuffService implements StuffService {

	@Autowired
	private StuffRepository repository;

	@Autowired
	private ImageRepository imageRepository;

	@Override
	public int regStuff(StuffVO stuffVO) {
		

		int result = repository.insert(stuffVO);

		for (MultipartFile file : stuffVO.getFileList()) {
			
			String uploadFileName = file.getOriginalFilename();
			
			File saveFile = new File("/", uploadFileName);
			
			try {
				file.transferTo(saveFile);
			} catch (IllegalStateException e) {

				e.printStackTrace();
			} catch (IOException e) {

				e.printStackTrace();
			}
			
			imageRepository.insert(file.getOriginalFilename());
		}

		return result;
	}

	@Override
	public List<StuffViewDTO> getViewList() {
		return repository.findViewAll();
	}
}
