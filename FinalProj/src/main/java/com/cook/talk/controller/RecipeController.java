package com.cook.talk.controller;

import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cook.talk.model.VO.IngrVO;
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
		log.info("list==>" + dto);
		
		return "recipe/newList";
	}
	
//	@GetMapping("recipe/recipeView") 
//	public void recipeView(@RequestParam(value="rcpCode", required = false) String rcpCode, Model model) {
//		//List<RecipeDTO> recipeView = recipeService.recipeView();
//		model.addAttribute("recipeView", recipeService.recipeView(rcpCode));
//		model.addAttribute("rcpOrderView", recipeService.rcpOrderView(rcpCode));
//		model.addAttribute("rcpIngrView", recipeService.rcpIngrView(rcpingrCode));
//		model.addAttribute("tagView", recipeService.tagView());
//	  log.info("recipe/recipeView"); 
//}

	@GetMapping("recipe/insertRecipe")
	public String insertRecipeView(@ModelAttribute RecipeDTO recipeDTO) {
		
		return "recipe/insertRecipe";
	}

	@PostMapping("recipe/insertRecipeProc")
	public String insertRecipeProc(/* @RequestParam("file") MultipartFile multipartfile, */ 
			RecipeDTO recipeDTO) {
		BasicConfigurator.configure(); //log4j 오류처리
		recipeService.insertRecipeProc(true,
				 recipeDTO.getRecipeVO(), recipeDTO.getTypeCatVO(),
				recipeDTO.getRcpIngrVO(), recipeDTO.getRcpOrderVO(), recipeDTO.getTagVO());
		
		return "redirect:newList";
	}

}
