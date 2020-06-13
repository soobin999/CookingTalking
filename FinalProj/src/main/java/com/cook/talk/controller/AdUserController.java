package com.cook.talk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cook.talk.model.VO.UserVO;
import com.cook.talk.model.dao.AdUserDAO;
import com.cook.talk.model.dto.UserDTO;

@Controller
public class AdUserController {
	@Autowired(required = false)
	private AdUserDAO aduserDAO;

	@GetMapping("/admin/adUser") // 모든 qna 뿌려주기 위해
	public String allSelectUserId(Model model) {
		List<UserDTO> users = aduserDAO.allSelectUserId();
		model.addAttribute("UserList", users);
		System.out.println(users);
		return "admin/adUser";
	}

	@PostMapping("/admin/searchUserByEmail") // 회원 아이디를 통해 찾기
	public String searchUserByUserId(Model model, UserVO userId) {

		return "admin/adUser";
	}
}