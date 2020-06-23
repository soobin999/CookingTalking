package com.cook.talk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cook.talk.model.VO.QnAVO;
import com.cook.talk.model.dao.MypageDAO;
import com.cook.talk.model.service.MypageService;

@Controller
public class MyInqController {

	@Autowired
	MypageDAO mypageDAO;
	
	@Autowired
	MypageService mypageService;
	
	
	@GetMapping("/mypage/myInquiry")
	public String myInquiry(Model model, String qnaTitle, String qnaCont) {
		
		return "/mypage/myInquiry";
	}
	
	@PostMapping("/mypage/inputInq")
	public String myInquiryProc(@ModelAttribute QnAVO qnAVO, Model model) {
		mypageService.rqMyInq(qnAVO);
		System.out.println("mypageService.rqMyInq(qnAVO)");
		
		model.addAttribute("myInqList", mypageDAO.getmyInq());
		
		return "/mypage/myInquiryList";
	}
	
	@GetMapping("/mypage/myInquiryList")
	public String myInquiryList(Model model) {
		
		model.addAttribute("myInqList", mypageDAO.getmyInq());
		return "/mypage/myInquiryList";
	}
	
}
