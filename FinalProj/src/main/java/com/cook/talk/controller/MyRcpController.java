package com.cook.talk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cook.talk.model.VO.QnAVO;
import com.cook.talk.model.dao.MypageDAO;
import com.cook.talk.model.service.MypageService;

@Controller
public class MyRcpController {

	@Autowired
	MypageDAO mypageDAO;
	
	@Autowired
	MypageService mypageService;
	
	@GetMapping("/mypage/myRecipeIng")
	public String myRecipeIng(Model model) {
		model.addAttribute("myRecipeIng", mypageDAO.getMyRecipeIng());
		System.out.println(mypageDAO.getMyRecipeIng());
		return "/mypage/myRecipeIng";
	}
	
	@GetMapping("/mypage/myWritten")
	public String myWritten(Model model) {
		model.addAttribute("myWritten", mypageDAO.getMyRecipeWritten());
		System.out.println(mypageDAO.getMyRecipeWritten());
		return "/mypage/myWritten";
	}
	
}
