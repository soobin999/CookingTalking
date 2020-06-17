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
public class MypageController {

	@Autowired
	MypageDAO mypageDAO;
	
	@Autowired
	MypageService mypageService;
	
	@GetMapping("/mypage/mypage")
	//@GetMapping("/mypage/mypage")
	public String mypage(Model model) {
		model.addAttribute("myRecipeIng", mypageDAO.getMyRecipeIng());
		return "/mypage/mypage";
	}
	
	
	@GetMapping("/mypage/myFrequent")
	public String myFrequent(Model model) {
		model.addAttribute("myFollow", mypageDAO.getMyFollow());	
		return "/mypage/myFrequent";
	}
	
	@GetMapping("/mypage/myActivity")
	public String myActivity(Model model) {
		model.addAttribute("myTalk", mypageDAO.getMyTalk());
		return "/mypage/myActivity";
	}
	
	@GetMapping("/mypage/myInquiry")
	public String myInquiry(Model model, @ModelAttribute QnAVO qnAVO, String qnaTitle, String qnaCont) {
		return "/mypage/myInquiry";
	}
	
	@PostMapping("/mypage/myInquiry")
	public String myInquiryProc(QnAVO qnAVO, String qnaTitle, String qnaCont) {
		mypageService.rqMyInq(qnaTitle, qnaCont);
		return "redirect:myInquiry";
	}
	
}
