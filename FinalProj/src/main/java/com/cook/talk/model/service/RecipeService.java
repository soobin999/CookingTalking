package com.cook.talk.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cook.talk.model.VO.IngrVO;
import com.cook.talk.model.dto.RecipeDTO;

@Service
public interface RecipeService {

	//재료 이름 리스트
	public List<String> ingrNameList(int cs);

	//재료 검색하기 in 냉파
	public String searched(IngrVO ingrVO);
	public List<String> getSearchedIngrName(String ingrName);
	
	public List<RecipeDTO> getRcmmList(String selectedIngr);
	
	//레시피 목록 조회
	public List<RecipeDTO> getRecipeList();
	
	//레시피 총갯수
	public int recipeCount();
	
	//레시피 글보기
//	public List<RecipeDTO> recipeView();
	
//	//레시피 글등록
//	public String insertRecipeProc(RecipeVO recipe, TypeCatVO typeCat, RcpIngrVO rcpIngr, RcpOrderVO rcpOrder, TagVO tag);

	/* List<RecipeDTO> getRcmmList(IngrVO ingrVO); */


}


