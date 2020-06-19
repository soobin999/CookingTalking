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
		System.out.println(mypageService.getSearchMyFollow(followChef));

		return mypageService.getSearchMyFollow(followChef);

	}
	
	@PostMapping("/searchMyTalk")
	public List<String> getSearchMyTalk(String talkCont) {
		System.out.println(talkCont);
		System.out.println(mypageService.getSearchMyTalk(talkCont));
		return mypageService.getSearchMyTalk(talkCont);
	}
	
	
	@PostMapping("/searchMyScrap")
	public List<String> getSearchMyScraped(String rcpTitle, String rcpPic){
		System.out.println(rcpTitle);
		System.out.println(mypageService.getSearchMyScraped(rcpTitle, rcpPic));
		return mypageService.getSearchMyScraped(rcpTitle, rcpPic);
	}
	
	@PostMapping("/searchMyAllCom")
	public List<String> getSearchAllMyCom(String talkCom, String talkDate){
		System.out.println(talkCom);
		System.out.println(mypageService.getSearchAllMyCom(talkCom, talkDate));
		return mypageService.getSearchAllMyCom(talkCom, talkDate);
	}
	
}
