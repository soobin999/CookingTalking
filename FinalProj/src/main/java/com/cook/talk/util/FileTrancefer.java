package com.cook.talk.util;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

public class FileTrancefer {
	public static String requestFileTrancefer(MultipartFile file,String path) {
		//rcpPic, cookPic 업로드
		
		try {
			//basedir 주소 프로젝트 주소로 하면 배포 시 오류 생길 수 있음
			String baseDir = "C:/Users/parkc/Pictures/"; 
			baseDir+=path;
			file.transferTo(new File(baseDir + file.getOriginalFilename()));
							
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return file.getOriginalFilename();
	}
}
