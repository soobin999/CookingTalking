package com.cook.talk.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cook.talk.model.dto.RecipeDTO;

@Service
public interface RecipeService {

	//재료 이름 리스트
	public List<String> ingrNameList(int cs);

	//레시피 목록 조회
	public List<RecipeDTO> allSelectRecipeList(RecipeDTO recipe);
	
	//레시피 등록
	public String insertRecipe(RecipeDTO recipe);
	
	//레시피 수정
	public String updateRecipe(RecipeDTO recipe);
	
	//레시피 삭제
	public String deleteRecipe();
	
	//레시피 상세조회+조회수 증가
	public RecipeDTO getRecipeView();
	
}


