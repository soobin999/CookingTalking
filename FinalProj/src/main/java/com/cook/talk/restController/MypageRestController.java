package com.cook.talk.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cook.talk.model.dao.MypageDAO;
import com.cook.talk.model.service.MypageService;

@RestController
public class MypageRestController {

	@Autowired(required = false)
	MypageDAO mypageDAO;
	
	@Autowired(required = false)
	MypageService mypageService;
	
	@PostMapping("/searchMyFollow")
	public List<String> getSearchMyFollow(String followChef){
		System.out.println(followChef);
		return mypageService.getSearchMyFollow(followChef);
	}
	
	@PostMapping("/searchMyTalk")
	public List<String> getSearchMyTalk(String talkCont) {
		System.out.println(talkCont);
		return mypageService.getSearchMyTalk(talkCont);
	}
	
}
