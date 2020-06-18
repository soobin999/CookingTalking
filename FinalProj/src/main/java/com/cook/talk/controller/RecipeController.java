package com.cook.talk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cook.talk.model.VO.IngrVO;
import com.cook.talk.model.dao.RecipeDAO;
import com.cook.talk.model.dto.RecipeDTO;
import com.cook.talk.model.service.RecipeService;

import lombok.extern.java.Log;

@Log
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

	@PostMapping("/rcmmRecipe")
	public String rcmmRecipe(Model model, String selectedIngr, IngrVO ingrVO){
		System.out.println("selectedIngr:"+selectedIngr);
		model.addAttribute("rcmmList", recipeDAO.getRcmmList(selectedIngr));
		System.out.println(recipeDAO.getRcmmList(selectedIngr));
		return "refrigerator/rcmmRecipe";
	}	
	
	@GetMapping("recipe/newList")
	public String getRecipeList(Model model) {
		List<RecipeDTO> recipeList = recipeService.getRecipeList();
		model.addAttribute("recipeList", recipeList);
		model.addAttribute("recipeCount", recipeDAO.recipeCount());
		for (RecipeDTO dto : recipeList)
			System.out.println("list==>" + dto);
			/* log.info("list==>" + dto); */
		return "recipe/newList";
	}
	
//	@GetMapping("recipe/recipeView") 
//	public void recipeView(@RequestParam("rcpCode") String rcpCode, Model model) {
//		List<RecipeDTO> recipeView = recipeService.
//	  model.addAttribute("recipeView2", recipeService.recipeView2(rcpCode));
//	  model.addAttribute("recipeView3", recipeService.recipeView3());
//	  model.addAttribute("recipeView4", recipeService.recipeView4());
//	  log.info("recipe/recipeView"); 
//	  
//}
	 
//	@GetMapping("recipe/insertRecipe")
//	public String insertRecipeView() {	
//		return "recipe/insertRecipe";
//	}
//	
//	@PostMapping("recipe/insertRecipe")
//	public String insertRecipeProc(RecipeVO recipe, TypeCatVO typeCat, RcpIngrVO rcpIngr, RcpOrderVO rcpOrder, TagVO tag) {
//		recipeService.insertRecipeProc(recipe, typeCat, rcpIngr, rcpOrder, tag);
//		return "redirect:getRecipeList";
//	}



}
