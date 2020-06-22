package com.cook.talk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cook.talk.model.dao.ChefDAO;
import com.cook.talk.model.dao.MainDAO;

@Controller
public class ChefController {

	@Autowired
	ChefDAO chefDAO;
	@Autowired
	MainDAO maindao;
	@GetMapping("/chefRank/{status}")
	public String chefRank(Model model, @PathVariable String status) {
		status=(status!=null)? status:"rcpUploads";
		model.addAttribute("status",status);
		model.addAttribute("chefList", chefDAO.allSelectChef(status));
		return "/chef/chefRank";
	}

	@GetMapping("/chefInfo/{page}/{chefId}")
	public String chefInfo(Model model,String userId,@PathVariable String chefId,@PathVariable int page) {
		userId="zleda9@naver.com";
		model.addAttribute("follow",chefDAO.selectFollow(userId, chefId));
		model.addAttribute("chefInfo",chefDAO.selectRecipe(chefId,(page-1)*20));
		model.addAttribute("chefDetail",chefDAO.selectChefDetail(chefId));
		model.addAttribute("totalPage",Math.ceil(chefDAO.recipeCount(chefId)/20.0));
		System.out.println(chefDAO.recipeCount(chefId));
		return "chef/chefInfo";
	}
	@PostMapping("/chefsearch")
	public String chefsearch(String chefNick,Model model) {
		model.addAttribute("chefList",maindao.selectChef(chefNick));
		return "/chef/chefRank";
	}
}

