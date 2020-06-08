package com.cook.talk.restController;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cook.talk.model.VO.IngrVO;
import com.cook.talk.model.dao.RecipeDAO;
import com.cook.talk.model.service.RecipeService;
import com.cook.talk.model.serviceImpl.RecipeServiceImpl;

@RestController
public class RecipeRestController {

	@Autowired(required = false)
	RecipeDAO recipeDAO;

	@Autowired(required = false)
	RecipeService recipeService;

	@GetMapping(value = "/chosung")
	public List<String> chosung(IngrVO ingrVO, HttpSession session, int cs) {

		// 재료 리스트
		List<String> ingrs = recipeService.ingrNameList(cs);

		return ingrs;

	}

	@RequestMapping(value = "/searched", method = RequestMethod.POST)
	public String searched(IngrVO ingrVO) {
		
		recipeService.searched(ingrVO);

		ingrVO.getIngrName();
		System.out.println("ingrVO" + ingrVO);
		return recipeService.searched(ingrVO);
	}

}
