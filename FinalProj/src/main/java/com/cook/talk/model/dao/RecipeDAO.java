package com.cook.talk.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import com.cook.talk.model.VO.IngrVO;
import com.cook.talk.model.dto.RecipeDTO;

@Service
@Mapper
public interface RecipeDAO {

	//Call ingrNameList
	public List<IngrVO> allSelectIngrList(IngrVO ingrVO);
	
	//Searching IngrName?
	public List<String> getIngrName(String chosung1, String chosung2);
	
	//Call searched ingrName
	public List<String> getSearchedIngrName(String ingrName);
	
	public List<String> getIngrName1(String chosung1, String chosung2);
	
	//RcmmRecipe
	public List<RecipeDTO> getRcmmList();
	
	//레시피 목록 조회
	public List<RecipeDTO> getRecipeList();

	//레시피 총갯수
	public int recipeCount();
	

	
}