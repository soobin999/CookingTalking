package com.cook.talk.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cook.talk.model.VO.RecipeVO;
import com.cook.talk.model.dto.RecipeDTO;

@Service
public interface RecipeService {

	//재료 이름 리스트
	public List<String> ingrNameList(int cs);

	
	
	
	//레시피 목록 조회
	public List<RecipeDTO> getRecipeList();
	
	
	
}


