package com.cook.talk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cook.talk.model.dao.MyPageDAO;

@Controller
public class MyPageController {

	@Autowired
	MyPageDAO myPageDAO;
	
	@GetMapping("/mypage")
	public String mypage(Model model) {
		
		model.addAttribute("myRecipeIng", myPageDAO.getMyRecipeIng());
		
		return "/mypage/mypage";
	}
	
}
