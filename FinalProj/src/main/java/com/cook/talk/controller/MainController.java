package com.cook.talk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cook.talk.model.dao.ChefDAO;
import com.cook.talk.model.service.MainService;

@Controller
public class MainController {

	@Autowired(required = false)
	private ChefDAO chef;
	@Autowired(required = false)
	private MainService mainService;
	@GetMapping("/index")
	public String index(Model model) {
		return "/main/index";
	}

	@GetMapping("/loginIndex")
	public String loginIndex(Model model, String expl) {
		System.out.println(mainService.recipeList("R-000001"));
		model.addAttribute("rcpList", mainService.recipeList("R-000001"));
		
		return "/main/loginIndex";
	}

	@PostMapping("/qnAGo")
	public String qnaGo() {
		return "/admin/complain";
	}
}
