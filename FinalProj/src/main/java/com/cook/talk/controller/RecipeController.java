package com.cook.talk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cook.talk.model.VO.RecipeVO;
import com.cook.talk.model.dao.RecipeDAO;
import com.cook.talk.model.dto.RecipeDTO;
import com.cook.talk.model.service.RecipeService;

import jdk.internal.jline.internal.Log;
import lombok.extern.log4j.Log4j;

@Controller
public class RecipeController {
	
	@Autowired
	RecipeService recipeService;
	
	@Autowired
	RecipeDAO recipeDAO;

	@GetMapping("/ingrSelect")
	public String refrigeratorSearch(Model model) {
		model.addAttribute("ingrs", recipeDAO.getIngrName("가", "나"));
		System.out.println(recipeDAO.getIngrName("가", "나"));
		return "refrigerator/ingrSelect";
	}

	
	@GetMapping(value = "/list")
	public String getRecipeList(Model model) {
		List<RecipeDTO> recipeList = recipeService.getRecipeList();
		model.addAttribute("recipeList", recipeList);
		System.out.println("list==>"+recipeList);
		return "recipe/list";
	}
	
	}
