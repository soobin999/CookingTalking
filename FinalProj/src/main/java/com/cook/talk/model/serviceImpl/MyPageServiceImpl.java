package com.cook.talk.model.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cook.talk.model.VO.IngrVO;
import com.cook.talk.model.dao.RecipeDAO;
import com.cook.talk.model.dto.RecipeDTO;
import com.cook.talk.model.service.RecipeService;

@Service
public class MyPageServiceImpl implements RecipeService{

	@Autowired
	private RecipeDAO recipeDAO;
	@Autowired(required = false)
	private IngrVO ingrVO;
	
	//재료 초성 분류 
	public List<String> ingrNameList(int cs) {
		String[] chosungList = {"가","나","다","라","마","바","사","아","자","차","카","타","파","하","가"};
		
		List<String> ingrNameList = recipeDAO.getIngrName1(chosungList[cs], chosungList[cs+1]);
		return ingrNameList;
	}
	
	@Override
	public String searched(IngrVO ingrVO) {
		if (ingrVO.getIngrName() != null) {
			ingrVO.getIngrName();
			return ingrVO.getIngrName();
		} else {
			return "일치하는 재료 없어요";
		}

	}
	 
	
	@Override
	public List<RecipeDTO> allSelectRecipeList(RecipeDTO recipe) {
		return null;
	}
	
	@Override
	public String deleteRecipe() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String insertRecipe(RecipeDTO recipe) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateRecipe(RecipeDTO recipe) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RecipeDTO getRecipeView() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getSearchedIngrName(String ingrName) {
		// TODO Auto-generated method stub
		return recipeDAO.getSearchedIngrName(ingrName);
	}

}
