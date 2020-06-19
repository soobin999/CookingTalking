package com.cook.talk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cook.talk.model.dao.MypageDAO;
import com.cook.talk.model.service.MypageService;

@Controller
public class MyActController {

	@Autowired
	MypageDAO mypageDAO;
	
	@Autowired
	MypageService mypageService;

	@GetMapping("/mypage/myTalk")
	public String myActivity(Model model) {
		model.addAttribute("myTalk", mypageDAO.getMyTalk());
		return "/mypage/myTalk";
	}
	
	@GetMapping("/mypage/myCom")
	public String myCom(Model model) {
		model.addAttribute("myAllCom", mypageDAO.getAllMyCom());
		/*
		 * model.addAttribute("myTalkCom", mypageDAO.getMyTalkCom());
		 * model.addAttribute("myRcpCom", mypageDAO.getMyRcpCom());
		 */
		return "/mypage/myCom";
	}
	
	
	
}
