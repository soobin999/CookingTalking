package com.cook.talk.model.dto;

import org.springframework.beans.factory.annotation.Autowired;

import com.cook.talk.model.VO.RecipeVO;
import com.cook.talk.model.VO.TypeCatVO;

import lombok.Data;

@Data
public class RecipeDTO {

	private String rcpCode;

	/*
	 * private String rcpTitle; private String rcpPic;
	 */

	@Autowired(required = false)
	private RecipeVO recipeVO;

	private String nickName;

	@Autowired(required = false)
	private TypeCatVO typeCatVO;

}
