package com.cook.talk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MyPageController {

	@PostMapping("/mypage")
	public String mypage() {
		return "/mypage/mypage";
	}
	
}
