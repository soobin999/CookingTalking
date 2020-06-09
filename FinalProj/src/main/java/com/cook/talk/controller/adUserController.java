package com.cook.talk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cook.talk.model.VO.UserVO;
import com.cook.talk.model.dao.AdUserDAO;

@Controller
public class adUserController {
	@Autowired(required = false)
	private AdUserDAO aduserDAO;

	@GetMapping("/admin/adUser") // 모든 qna 뿌려주기 위해
	public String allSelectUserId(Model model) {
		model.addAttribute("UserList", aduserDAO.allSelectUserId());

		return "admin/adUser";
	}

	@PostMapping("/admin/updateUserNickName") // 닉네임 업데이트
	public String updateUserNickName(UserVO nickName) {
		System.out.println(nickName);
		aduserDAO.updateUserNickName(nickName);
		return "admin/adminMain";
	}

	@PostMapping("/admin/searchUserByEmail") // 회원 아이디를 통해 찾기
	public String searchUserByUserId(Model model, UserVO userId) {

		return "admin/adUser";
	}
}
