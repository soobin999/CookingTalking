package com.cook.talk.model.serviceImpl;

 import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cook.talk.model.VO.IngrVO;
import com.cook.talk.model.VO.RcpIngrVO;
import com.cook.talk.model.VO.RcpOrderVO;
import com.cook.talk.model.VO.RecipeVO;
import com.cook.talk.model.VO.TagVO;
import com.cook.talk.model.VO.TypeCatVO;
import com.cook.talk.model.dao.RecipeDAO;
import com.cook.talk.model.dto.RecipeDTO;
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
	public List<RecipeDTO> getRcmmList(String selectedIngr) {
		List<RecipeDTO> getRcmmList = recipeDAO.getRcmmList(selectedIngr);
		
		return getRcmmList;
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


	@Override
	public void insertRecipeProc(RecipeVO recipeVO, TypeCatVO typeCatVO, RcpIngrVO rcpIngrVO, RcpOrderVO rcpOrderVO,
			TagVO tagVO) {
		int RcpNum = recipeDAO.selectRcpCode() + 1;
		recipeVO.setRcpCode("R-" + RcpNum);
		recipeDAO.insertRcpProc(recipeVO);

		recipeDAO.insertTypecatProc(typeCatVO);

		recipeDAO.insertRcpingrProc(rcpIngrVO);

		recipeDAO.insertRcporderProc(rcpOrderVO);
		log.info(rcpOrderVO);

		recipeDAO.insertTagProc(tagVO);
		log.info(tagVO);

	}

}
