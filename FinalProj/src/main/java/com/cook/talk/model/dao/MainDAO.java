package com.cook.talk.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cook.talk.model.VO.RecipeVO;
import com.cook.talk.model.dto.ChefDTO;
import com.cook.talk.model.dto.MainDTO;

@Mapper
public interface MainDAO {

	public List<RecipeVO> recipeList(List<String> repCode);
	public MainDTO totalSelect();
	public List<RecipeVO> recipeSearch(String searchWord,String status);
	public List<String> selectTitle(String searchWord);
	public List<ChefDTO> selectChef(String chefNick);
}
