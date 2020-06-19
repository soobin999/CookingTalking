package com.cook.talk.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cook.talk.model.dao.MypageDAO;
import com.cook.talk.model.service.MypageService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MypageRestController {

	@Autowired(required = false)
	MypageDAO mypageDAO;
	
	@Autowired(required = false)
	MypageService mypageService;
	
	@PostMapping("/searchMyFollow")
	public List<String> getSearchMyFollow(String followChef){
		System.out.println(followChef);
		List<String> a = mypageService.getSearchMyFollow(followChef);
		a.forEach(b -> log.info(b));
		return a;
	}
	
	@PostMapping("/searchMyTalk")
	public List<String> getSearchMyTalk(String talkCont) {
		System.out.println(talkCont);
		return mypageService.getSearchMyTalk(talkCont);
	}
	
}
