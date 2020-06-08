package com.cook.talk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cook.talk.model.dao.ChefDAO;

@Controller
public class ChefController {

	@Autowired
	ChefDAO chefDAO;

	@GetMapping("/chefRank")
	public String chefRank(Model model,String status) {
		model.addAttribute("chefList", chefDAO.allSelectChef(status));
		return "/chef/chefRank";
	}

	@GetMapping("/chefInfo")
	public String chefInfo(Model model,String userId,String chefId) {
		chefId="zleda9@naver.com";
		userId="zleda9@naver.com";
		model.addAttribute("follow",chefDAO.selectFollow(userId, chefId));
		model.addAttribute("chefInfo",chefDAO.selectRecipe(chefId));
		model.addAttribute("chefDetail",chefDAO.selectChefDetail(chefId));
		return "/chef/chefInfo";
	}
	
}

