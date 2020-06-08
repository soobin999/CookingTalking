package com.cook.talk.model.service;

import java.util.List;

import com.cook.talk.model.VO.RecipeVO;

public interface MainService {

	public List<RecipeVO> recipeList(String expl);
}
