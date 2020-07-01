package com.cook.talk.util;

import java.io.File;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class FileTrancefer {
<<<<<<< HEAD
	public static String requestFileTrancefer(MultipartFile file, String path) {
		// rcpPic, cookPic 업로드

		try {
			// basedir 주소 프로젝트 주소로 하면 배포 시 오류 생길 수 있음
			String baseDir = "C:/Pictures/";
=======
	public static String requestFileTrancefer(MultipartFile file,String path) {
		//rcpPic, cookPic 업로드
		
		try {
			//basedir 주소 프로젝트 주소로 하면 배포 시 오류 생길 수 있음
			String baseDir = "C:/"; 
>>>>>>> 53e6304f5f77087466033920af70d6d5cec2c3c3
			baseDir+=path;
			file.transferTo(new File(baseDir + file.getOriginalFilename()));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return file.getOriginalFilename();
	}
}
