package com.cook.talk.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import com.cook.talk.model.VO.IngrVO;
import com.cook.talk.model.VO.RcpIngrVO;
import com.cook.talk.model.VO.RcpOrderVO;
import com.cook.talk.model.VO.RecipeVO;
import com.cook.talk.model.VO.TagVO;
import com.cook.talk.model.VO.TypeCatVO;
import com.cook.talk.model.dto.RecipeDTO;

@Service
@Mapper
public interface RecipeDAO {

	//재료 리스트 받아오기
	public List<IngrVO> allSelectIngrList(IngrVO ingrVO);
	
	//재료 검색하는 곳
	public List<String> getIngrName(String chosung1, String chosung2);
	
	//검색한 애 불러오기
	public List<String> getSearchedIngrName(String ingrName);
	
	public List<String> getIngrName1(String chosung1, String chosung2);
	
	
	//레시피 목록 조회
	public List<RecipeDTO> getRecipeList();

	//레시피 총갯수
	public int recipeCount();
	
	//레시피 글보기
//	public List<RecipeDTO> recipeView();
	
//	//레시피 글등록
//	public void insertRecipeProc(RecipeVO recipe, TypeCatVO typeCat, RcpIngrVO rcpIngr, RcpOrderVO rcpOrder, TagVO tag);
//
//	//rcpCode 자동생성
//	public int selectRcpCode();

	

	
}