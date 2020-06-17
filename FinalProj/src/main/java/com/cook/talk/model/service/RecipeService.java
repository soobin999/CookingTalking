package com.cook.talk.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cook.talk.model.VO.IngrVO;
import com.cook.talk.model.VO.RcpIngrVO;
import com.cook.talk.model.VO.RcpOrderVO;
import com.cook.talk.model.VO.RecipeVO;
import com.cook.talk.model.VO.TagVO;
import com.cook.talk.model.VO.TypeCatVO;
import com.cook.talk.model.dto.RcpIngrDTO2;
import com.cook.talk.model.dto.RcpOrderDTO2;
import com.cook.talk.model.dto.RecipeDTO;
import com.cook.talk.model.dto.RecipeDTO2;
import com.cook.talk.model.dto.TagDTO2;
import com.cook.talk.model.dto.TypeCatDTO2;

@Service
public interface RecipeService {

	//재료 이름 리스트
	public List<String> ingrNameList(int cs);

	//재료 검색하기 in 냉파
	public String searched(IngrVO ingrVO);

	
	public List<String> getSearchedIngrName(String ingrName);
	
	
	
	//레시피 목록 조회
	public List<RecipeDTO> getRecipeList();
	
	//레시피 총갯수
	public int recipeCount();

	public void insertRecipeProc(RecipeDTO2 recipeDTO2, TypeCatDTO2 typeCatDTO2, RcpIngrDTO2 rcpIngrDTO2,
			RcpOrderDTO2 rcpOrderDTO2, TagDTO2 tagDTO2);
	
	//레시피 글보기
//	public List<RecipeDTO> recipeView();
	
	//레시피 글등록
	//public String insertRecipeProc(RecipeVO recipe, TypeCatVO typeCat, RcpIngrVO rcpIngr, RcpOrderVO rcpOrder, TagVO tag);

}


