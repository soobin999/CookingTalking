package com.cook.talk.model.dto;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("recipeShortDTO")
public class RecipeShortDTO{

	private RecipeDTO2 recipeDTO2;
	private TypeCatDTO2  typeCatDTO2;
	private RcpIngrDTO2 rcpIngrDTO2;
	private RcpOrderDTO2 rcpOrderDTO2;
	private TagDTO2 tagDTO2;
	
}
