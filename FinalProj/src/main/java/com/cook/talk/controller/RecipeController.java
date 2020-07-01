package com.cook.talk.controller;

import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cook.talk.model.VO.IngrVO;
import com.cook.talk.model.VO.ViewsVO;
import com.cook.talk.model.dao.RecipeDAO;
import com.cook.talk.model.dto.RecipeDTO;
import com.cook.talk.model.service.RecipeService;
import com.cook.talk.util.FileTrancefer;

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
	public String rcmmRecipe(Model model, @RequestParam(value="selectedIngr", required=false) List<String> selectedIngr, IngrVO ingrVO){
		System.out.println("selectedIngr:"+selectedIngr);
		System.out.println(selectedIngr);
		
		model.addAttribute("rcmmList", recipeDAO.getRcmmList(selectedIngr));
		System.out.println(recipeDAO.getRcmmList(selectedIngr));

		return "refrigerator/rcmmRecipe";
	}
	
	@GetMapping("/ingrDetail")
	public String getIngrDetail(Model model) {
		List<IngrVO> ingrDetail = recipeService.getIngrDetail();
		model.addAttribute("ingrDetail", ingrDetail);
		
		log.info(recipeService.getIngrDetail());
		
		return "recipe/ingrDetail";
	}
	

	@GetMapping("recipe/newList")
	public String getRecipeList(Model model, ViewsVO viewsVO) {
		List<RecipeDTO> recipeList = recipeService.getRecipeList();
		model.addAttribute("recipeList", recipeList);

		model.addAttribute("recipeCount", recipeDAO.recipeCount());
		//레시피 조회이력 저장
		
		for (RecipeDTO dto : recipeList)
		log.info("list==>" + dto);
		return "recipe/newList";
	}
	
	@GetMapping("recipe/rankList")
	public String getRankList(Model model) {
		List<RecipeDTO> rankList = recipeService.getRankList();
		model.addAttribute("rankList", rankList);
		
		return "recipe/rankList";
	}

	@GetMapping("recipe/view") 
	public String getRecipeView(String rcpCode, Model model) {
		model.addAttribute("recipeDTO", recipeDAO.selectRcptpView(rcpCode));
		log.info(recipeDAO.selectRcptpView(rcpCode));
		model.addAttribute("rcpIngrView", recipeDAO.selectRcpIngrView(rcpCode));
		log.info(recipeDAO.selectRcpIngrView(rcpCode));
		model.addAttribute("rcpOrderView", recipeDAO.selectRcpOrderView(rcpCode));
		log.info(recipeDAO.selectRcpOrderView(rcpCode));
		model.addAttribute("tagView", recipeDAO.SelectTagView(rcpCode));
		log.info(recipeDAO.SelectTagView(rcpCode));
		
		recipeService.rcpViewsUpdate(rcpCode); //조회수 증가
		
		return "recipe/recipeView";

}

	@GetMapping("recipe/insert")
	public String insertRecipe(@ModelAttribute RecipeDTO recipeDTO) {
		return "recipe/insertRecipe";
	}

	@ResponseBody
	@PostMapping("recipe/insertProc")
	public String insertRecipeProc(@RequestParam("file") MultipartFile file, 
			boolean registerStatus, RecipeDTO recipeDTO) {
		BasicConfigurator.configure(); //log4j 오류처리
		
		/*
		 * recipeService.insertRecipeProc(file, registerStatus, recipeDTO.getRecipeVO(),
		 * recipeDTO.getTypeCatVO(), recipeDTO.getRcpIngrVO(),
		 * recipeDTO.getRcpOrderVO(), recipeDTO.getTagVO());
		 */
		
		//rcpPic, cookPic 업로드
		String rcpPic = FileTrancefer.requestFileTrancefer(file,"recipe/"); 
		recipeDTO.getRecipeVO().setRcpPic(rcpPic);
		
		recipeService.insertRecipeProc(registerStatus, recipeDTO);
		
		return "recipe/insertRecipe";
	}

	@PostMapping("recipe/update")
	public String updateRecipe(RecipeDTO recipeDTO) {
		return "";
	}
	
	@GetMapping("recipe/delete")
	public String deleteRecipe(String rcpCode ) {
		return "";
	}

}
