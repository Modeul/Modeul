package com.modeul.web.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.modeul.web.entity.StuffDTO;
import com.modeul.web.entity.StuffView;
import com.modeul.web.repository.StuffRepository;

@Service
public class DefaultStuffService implements StuffService {

	@Autowired
	private StuffRepository repository;

	@Transactional
	@Override
	public int regStuff(StuffDTO stuffDTO) {

		repository.insert(stuffDTO.getStuff());

		Boolean firstFileName = stuffDTO.getImageList().get(0).getOriginalFilename().equals("");

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
		
		for(MultipartFile image : stuffDTO.getImageList()) {
			
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
			
			Map<String, Object> imageMap = new HashMap<>();
			
			imageMap.put("uploadFileName", uploadFileName);
			imageMap.put("stuffId", stuffDTO.getStuff().getId());

			repository.insertImage(imageMap);
			
		}

		return 1;
	}

	@Override
	public List<StuffView> getViewList() {
		return repository.findViewAll();
	}
}
