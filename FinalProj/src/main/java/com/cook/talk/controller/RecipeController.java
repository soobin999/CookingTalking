package com.cook.talk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cook.talk.model.dao.RecipeDAO;
import com.cook.talk.model.dto.RecipeDTO;
import com.cook.talk.model.service.RecipeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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

	@GetMapping("/rcmmRecipe")
	public String rcmmRecipe(Model model){
		return "refrigerator/rcmmRecipe";
	}	
	
	
	@GetMapping(value = "recipe/newList")
	public String getRecipeList(Model model) {
		List<RecipeDTO> recipeList = recipeService.getRecipeList();
		model.addAttribute("recipeList", recipeList);
		model.addAttribute("recipeCount", recipeDAO.recipeCount());
		for (RecipeDTO dto : recipeList)
			log.info("list==>" + dto);
		return "recipe/newList";
	}
	
	}
