package com.cook.talk.model.serviceImpl;

 import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cook.talk.model.VO.IngrVO;
import com.cook.talk.model.dao.RecipeDAO;
import com.cook.talk.model.dto.RcpIngrDTO2;
import com.cook.talk.model.dto.RcpOrderDTO2;
import com.cook.talk.model.dto.RecipeDTO;
import com.cook.talk.model.dto.RecipeDTO2;
import com.cook.talk.model.dto.TagDTO2;
import com.cook.talk.model.dto.TypeCatDTO2;
import com.cook.talk.model.service.RecipeService;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class RecipeServiceImpl implements RecipeService{

	@Autowired(required = false)
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
	public List<String> getSearchedIngrName(String ingrName) {
		// TODO Auto-generated method stub
		return recipeDAO.getSearchedIngrName(ingrName);
	}
	
	

	@Override
	public List<RecipeDTO> getRecipeList() {
		List<RecipeDTO> recipeList = recipeDAO.getRecipeList();
		return recipeList;
	}
	
	@Override
	public int recipeCount() {
		int recipeCount = recipeDAO.recipeCount();
		return recipeCount();
	}

//	@Override
//	public String insertRecipeProc(RecipeVO recipeVO, TypeCatVO typeCatVO, 
//			RcpIngrVO rcpIngrVO, RcpOrderVO rcpOrderVO, TagVO tagVO) {
//	 int RcpNum = recipeDAO.selectRcpCode() +1;
//	 recipeVO.setRcpCode("R-" + RcpNum);
	// recipeDAO.insertRecipeProc(recipe, typeCat, rcpIngr, rcpOrder, tag);
//	 System.out.println(recipeVO);
	 // recipeDAO.insertRcpProc(recipeVO);
	  
//	  System.out.println(typeCatVO);
	  //recipeDAO.insertTypecatProc(typeCatVO);
	  
//	  System.out.println(rcpIngrVO);
	  //recipeDAO.insertRcpingrProc(rcpIngrVO);
	  
//	  System.out.println(rcpOrderVO);
	  //recipeDAO.insertRcporderProc(rcpOrderVO);
//	  
//	  System.out.println(tagVO);
	  //recipeDAO.insertTagProc(tagVO);
	  
	 
	
//	 return "?????";
//	}

	@Override
	public void insertRecipeProc(RecipeDTO2 recipeDTO2, TypeCatDTO2 typeCatDTO2, RcpIngrDTO2 rcpIngrDTO2,
			RcpOrderDTO2 rcpOrderDTO2, TagDTO2 tagDTO2) {
		int RcpNum = recipeDAO.selectRcpCode() +1;
		 recipeDTO2.setRcpCode("R-" + RcpNum);
		 recipeDAO.insertRcpProc(recipeDTO2);
		 System.out.println(recipeDTO2);
		 recipeDAO.insertTypecatProc(typeCatDTO2);
		 System.out.println(typeCatDTO2);
		 recipeDAO.insertRcpingrProc(rcpIngrDTO2);
		 System.out.println(rcpIngrDTO2);
		 recipeDAO.insertRcporderProc(rcpOrderDTO2);
		 System.out.println(rcpOrderDTO2);
		 recipeDAO.insertTagProc(tagDTO2);
		 log.info(tagDTO2);
	}


}
