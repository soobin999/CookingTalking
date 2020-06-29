package com.cook.talk.restController;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cook.talk.model.VO.TalkComVO;
import com.cook.talk.model.VO.TalkVO;
import com.cook.talk.model.service.TalkComService;
import com.cook.talk.model.service.TalkService;

import groovy.util.logging.Log4j;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@Log4j
public class TalkRestController {
	private TalkService service;

	
	
	
	
	
	
	
	@PostMapping("com/upload")
	public void imgload(MultipartFile multipartFile) {
		service.upload(multipartFile);
	}

	// 이미지 업로드
	@PostMapping("talk/upload")
	public void talkImg(MultipartFile file) {
		service.upload(file);
	}

	// 좋아요
	@RequestMapping(value = "/insertLike.do", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public String insertLike(TalkVO talkLike) {
		String msg = "";
		int insertNum = service.insertLike(talkLike);
		if (insertNum > 0)
			msg = "success";
		else
			msg = "fail";
		return msg;
	}

	
	
	@RequestMapping(value = "/deleteLike.do", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	public String deleteLike(TalkVO talkVO) {
		service.deleteLike(talkVO);
         			return  "success";
	}

	
}
