package com.cook.talk.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cook.talk.model.VO.RecipeVO;

@Mapper
public interface MainDAO {

	public List<RecipeVO> recipeList(List<String> repCode);
}
