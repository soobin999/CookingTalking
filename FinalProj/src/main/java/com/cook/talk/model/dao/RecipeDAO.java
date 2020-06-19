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

	//Call ingrNameList
	public List<IngrVO> allSelectIngrList(IngrVO ingrVO);
	
	//Searching IngrName?
	public List<String> getIngrName(String chosung1, String chosung2);
	
	//Call searched ingrName
	public List<String> getSearchedIngrName(String ingrName);
	
	public List<String> getIngrName1(String chosung1, String chosung2);
	
	public List<RecipeDTO> getRcmmList(String selectedIngr);
	
	
	
	
	//레시피 목록 조회
	public List<RecipeDTO> getRecipeList();

	//레시피 총갯수
	public int recipeCount();
	
	//레시피 글보기
	public RecipeDTO selectRcptpView(String rcpCode, String typeCode/* String connectCode, String rcpTagCode*/);
	//RecipeDTO.selectRcptpView(rcpCode, typeCode);
/*	RecipeDTO.selectRcpIngrView(connectCode, rcpCode);
	RecipeDTO.selectRcpOrderView(rcpCode);
	RecipeDTO.SelectTagView(rcpTagCode);*/
		
		
	//rcpCode 자동생성
	public int selectRcpCode();
	//typeCode 자동생성
	public int selectTypeCode();
	//rcpingr.connectcode 자동생성
	public int selectConnectcode();

	//레시피 글등록
	public void insertRecipeProc(RecipeVO recipeVO, TypeCatVO typeCatVO, RcpIngrVO rcpIngrVO,
			RcpOrderVO rcpOrderVO, TagVO tagVO);
	void insertRcpProc(RecipeVO recipeVO);
	void insertTypecatProc(TypeCatVO typeCatVO);
	void insertRcpingrProc(RcpIngrVO rcpIngrVO);
	void insertRcporderProc(RcpOrderVO rcpOrderVO);
	void insertTagProc(TagVO tagVO);

			
	//레시피 수정
	//레시피 삭제

	
}

