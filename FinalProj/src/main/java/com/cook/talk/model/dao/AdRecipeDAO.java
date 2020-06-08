package com.cook.talk.model.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cook.talk.model.VO.RecipeVO;
import com.cook.talk.model.VO.UserVO;

@Service
public interface AdRecipeDAO {

	public List<RecipeVO> allSelectRecipe();

	public void updateRecipe(RecipeVO rcpUpdate);

	public List<RecipeVO> searchRecipeByNickName(UserVO userNickName);

	public List<RecipeVO> searchRcpByRcpCode(String rcpCode);

	public List<Integer> selectStaticMonths(String rcpCode);

	public List<Integer> selectStaticsGender(String rcpCode);

	public List<Integer> selectStaticsAge(String rcpCode);

}
