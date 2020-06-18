package com.cook.talk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cook.talk.model.dao.MypageDAO;
import com.cook.talk.model.service.MypageService;

@Controller
public class MyFreqController {

	@Autowired
	MypageDAO mypageDAO;
	
	@Autowired
	MypageService mypageService;
	
	
	@GetMapping("/mypage/myFollow")
	public String myFrequent(Model model) {
		model.addAttribute("myFollow", mypageDAO.getMyFollow());
		System.out.println(mypageDAO.getMyFollow());
		return "/mypage/myFollow";
	}
	
	@GetMapping("/mypage/myScraped")
	public String myScraped(Model model) {
		model.addAttribute("myScraped", mypageDAO.getMyScrapedRecipe());
		System.out.println(mypageDAO.getMyScrapedRecipe());
		return "/mypage/myScraped";
	}

	
}
