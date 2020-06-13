package com.cook.talk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cook.talk.model.VO.RecipeVO;
import com.cook.talk.model.dao.RecipeDAO;
import com.cook.talk.model.dto.RecipeDTO;
import com.cook.talk.model.service.RecipeService;

import lombok.extern.log4j.Log4j;

@Log4j 
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
	
	
	@GetMapping("recipe/newList")
	public String getRecipeList(Model model) {
		List<RecipeDTO> recipeList = recipeService.getRecipeList();
		model.addAttribute("recipeList", recipeList);
		model.addAttribute("recipeCount", recipeDAO.recipeCount());
		for (RecipeDTO dto : recipeList)
			log.info("list==>" + dto);
		return "recipe/newList";
	}
	
	/*
	 * @GetMapping("recipe/recipeView") public void
	 * recipeView(@RequestParam("rcpCode") String rcpCode, Model model) {
	 * model.addAttribute("recipeView2", recipeService.recipeView2(rcpCode));
	 * model.addAttribute("recipeView3", recipeService.recipeView3(rcpCode));
	 * model.addAttribute("recipeView4", recipeService.recipeView4(rcpCode));
	 * log.info("recipe/recipeView"); }
	 */
	@PostMapping("recipe/insertRecipe")
	public String insertRecipe(RecipeVO recipe ) {
		log.info("insert: "+recipe);		
		return "recipe/insertRecipe";
	}
	
}
