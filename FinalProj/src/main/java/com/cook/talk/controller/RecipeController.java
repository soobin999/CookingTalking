package com.cook.talk.controller;

import java.io.File;
import java.security.Principal;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.PastOrPresent;

import org.apache.log4j.BasicConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cook.talk.model.VO.IngrVO;
import com.cook.talk.model.VO.TalkVO;
import com.cook.talk.model.VO.ViewsVO;
import com.cook.talk.model.dao.RecipeDAO;
import com.cook.talk.model.dto.RecipeDTO;
import com.cook.talk.model.service.RecipeService;
import com.cook.talk.util.FileTrancefer;

import groovy.util.FileNameByRegexFinder;
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
		List<RecipeDTO> recipeList2 = recipeDAO.getRcpListPaiging(1);
		model.addAttribute("recipeList", recipeList);
		model.addAttribute("recipeList2", Math.ceil(recipeDAO.recipeCount() / 20.0));
		model.addAttribute("recipeCount", recipeDAO.recipeCount());
		//레시피 조회이력 저장
				
		return "recipe/newList";
	}
	
	@GetMapping("recipe/rankD")
	public String getRankD(Model model) {
		model.addAttribute("getRankD", recipeDAO.getRankD());
		log.info(recipeDAO.getRankD());
		
		return "recipe/rankListD";
	}
	
	@GetMapping("recipe/rankW")
	public String getRankW(Model model) {
		model.addAttribute("getRankW", recipeDAO.getRankW());
		log.info(recipeDAO.getRankW());

		return "recipe/rankListW";
	}
	@GetMapping("recipe/rankM")
	public String getRankM(Model model) {
		model.addAttribute("getRankM", recipeDAO.getRankM());
		log.info(recipeDAO.getRankM());
		
		return "recipe/rankListM";
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

		
	@PostMapping("recipe/insertProc")
	public String insertRecipeProc(MultipartHttpServletRequest multi,
			boolean registerStatus, RecipeDTO recipeDTO) {
		BasicConfigurator.configure(); //log4j 오류처리
		FileTrancefer.requestMultiFilesTrancefer(multi,recipeDTO);  
		  
		  recipeService.insertRecipeProc(registerStatus, recipeDTO);
		 
		return "redirect:/recipe/newList";
	}
	
	
	@GetMapping("recipe/update")
	public String updateRecipe(Model model, RecipeDTO recipeDTO, String rcpCode) {
		model.addAttribute("updateRcptp", recipeDAO.selectRcptpView(rcpCode));
		model.addAttribute("updateRcpIngr", recipeDAO.selectRcpIngrView(rcpCode));
		model.addAttribute("updateRcpOrder", recipeDAO.selectRcpOrderView(rcpCode));
		model.addAttribute("updatetag", recipeDAO.SelectTagView(rcpCode));
		
		return "recipe/updateRecipe";
	}
		
	
	@PostMapping("recipe/updateProc")
	public String updateRecipeProc(Principal pricipal, RecipeDTO recipeDTO) {
		recipeDTO.getUserVO().setUserId(pricipal.getName());
	//	recipeService.updateRecipeProc(recipeDTO);
		
		return "redirect:/recipe/view";
	}		
	

	@GetMapping("recipe/delete/{rcpCode}")
	public String deleteRecipe(@PathVariable("rcpCode") String rcpCode) {
		recipeService.deleteRecipe(rcpCode);
		return "redirect:/recipe/newList";
	}

	
	/*
	 * @GetMapping("recipe/delete") public String deleteRecipe(String rcpCode ) {
	 * return ""; }
	 */
	/*
	 * @GetMapping("recipe/update") public String updateRecipe (String rcpCode ) {
	 * return "recipe/updateRecipe"; }
	 */

}
