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
//		우선 stuff Table에 stuff 정보를 넣었다

		Boolean firstFileName = stuffVO.getImageList().get(0).getOriginalFilename().equals("");

		if (firstFileName)
			return 0;
//		파일을 선택하지 않아도 공백 ""이 전달됐다. 첫 파일의 이름이 공백일 경우 0울 리턴

		String uploadFolder = "C:\\upload";
//		파일 올릴 위치 \가 두 개인 이유는 escape 문자

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		양식

		Date date = new Date();
//		오늘의 날짜

		String str = sdf.format(date);
//		양식 + 오늘의 날짜

		String datePath = str.replace("-", File.separator);
//		"-"를 애플리케이션이 실행되는 운영체제 환경에 따라 그에 맞는 경로 구분자로 변경

		File uploadPath = new File(uploadFolder, datePath);
//		File 클래스를 이용해 폴더 생성
//		첫 번째 인자로 부모 경로엔 uploadFoler 변수를 두 번째 인자로 자식 경로엔 datePath 변수

		if (uploadPath.exists() == false) {
//			폴더가 이미 존재한다면 폴더를 생성하지 않는다
			uploadPath.mkdirs();
//			여러개의 폴더를 생성해야 하기 때문에 mkdir()이 아닌 mkdirs() 메서드를 사용
		}
		
		for(MultipartFile image : stuffVO.getImageList()) {
//			이미지 갯수만큼 반복
			
			String uploadFileName = image.getOriginalFilename();
//			파일 이름
			
			String uuid = UUID.randomUUID().toString();
//			동일한 이름을 가진 파일을 저장하게 되면 기존의 파일을 덮어씌워 버리기 때문에 고유한 이름이 필요하다. UUID(범용 고유 식별자)
			
			uploadFileName = uuid + "_" + uploadFileName;
//			파일이름을 UUID_파일 명 형식으로 저장
			
			File saveFile = new File(uploadPath, uploadFileName);
//			파일 위치, 파일 이름을 합친 File 객체
			
			try {
				image.transferTo(saveFile);
//				파일 저장
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			ImageVO imageVO = new ImageVO(uploadFileName, stuffVO.getId());
			
			repository.insertImage(imageVO);
//			image Table에 이미지 정보 등록
			
		}

		return 1;
	}

	@Override
	public List<StuffViewDTO> getViewList() {
		return repository.findViewAll();
	}
}
