package com.modeul.web.service;

import java.io.File;
import java.io.IOException;
import java.lang.System.Logger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.modeul.web.entity.ImageVO;
import com.modeul.web.entity.StuffVO;
import com.modeul.web.entity.StuffViewDTO;
import com.modeul.web.repository.StuffRepository;

@Service
public class DefaultStuffService implements StuffService {

	@Autowired
	private StuffRepository repository;

	@Transactional
	@Override
	public int regStuff(StuffVO stuffVO) {

		repository.insert(stuffVO);

		Boolean firstFileName = stuffVO.getImageList().get(0).getOriginalFilename().equals("");

		if (firstFileName)
			return 0;

		String uploadFolder = "C:\\upload";

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Date date = new Date();

		String str = sdf.format(date);

		String datePath = str.replace("-", File.separator);

		File uploadPath = new File(uploadFolder, datePath);

		if (uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}
		
		for(MultipartFile image : stuffVO.getImageList()) {
			
			String uploadFileName = image.getOriginalFilename();
			
			String uuid = UUID.randomUUID().toString();
			
			uploadFileName = uuid + "_" + uploadFileName;
			
			File saveFile = new File(uploadPath, uploadFileName);
			
			try {
				image.transferTo(saveFile);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			ImageVO imageVO = new ImageVO(uploadFileName, stuffVO.getId());
			
			repository.insertImage(imageVO);
			
		}

		return 1;
	}

	@Override
	public List<StuffViewDTO> getViewList() {
		return repository.findViewAll();
	}
}
