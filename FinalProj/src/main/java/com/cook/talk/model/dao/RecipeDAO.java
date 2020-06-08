package com.cook.talk.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import com.cook.talk.model.VO.IngrVO;
import com.cook.talk.model.VO.RecipeVO;
import com.cook.talk.model.dto.RecipeDTO;

@Service
@Mapper

public interface RecipeDAO {

	//재료 리스트 받아오기
	public List<IngrVO> allSelectIngrList(IngrVO ingrVO);
	
	//재료 검색하는 곳
	public List<String> getIngrName(String chosung1, String chosung2);

	//레시피 목록 조회
	public List<RecipeDTO> getRecipeList() ;


	
	
	
}