package com.cook.talk.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cook.talk.model.dao.MypageDAO;
import com.cook.talk.model.dto.MypageDTO;
import com.cook.talk.model.service.MypageService;

@RestController
public class MypageRestController {

	@Autowired(required = false)
	MypageDAO mypageDAO;
	
	@Autowired(required = false)
	MypageService mypageService;
	
	@PostMapping("/searchMyFollow")
	public String getSearchMyFollow(String followChef, MypageDTO mypageDTO){
		System.out.println(followChef);

		System.out.println(mypageService.getSearchMyFollow(followChef));
		System.out.println("searchMyFollow");
		mypageDTO = mypageService.getSearchMyFollow(followChef);
		System.out.println(mypageDTO);
		String nickName = mypageDTO.getNickName();
		System.out.println(nickName);
		return nickName;

	}
	
	@PostMapping("/searchMyTalk")
	public List<String> getSearchMyTalk(String talkCont) {
		System.out.println(talkCont);	
		return mypageService.getSearchMyTalk(talkCont);
	}
	
}
