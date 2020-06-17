package com.cook.talk.model.dto;

import org.springframework.beans.factory.annotation.Autowired;

import com.cook.talk.model.VO.RcpIngrVO;
import com.cook.talk.model.VO.RcpOrderVO;
import com.cook.talk.model.VO.RecipeVO;
import com.cook.talk.model.VO.TagVO;
import com.cook.talk.model.VO.TypeCatVO;

import lombok.Data;

@Data
public class RecipeDTO {

	private String rcpCode;
	
	@Autowired(required = false)
	private RecipeVO recipeVO;
	
	private String nickName;
	
	@Autowired(required = false)
	private TypeCatVO typeCatVO;
	
	@Autowired(required = false)
	private RcpIngrVO rcpIngrVO;
	
	@Autowired(required = false)
	private RcpOrderVO rcpOrderVO;
	
	@Autowired(required = false)
	private TagVO tagVO;
	
	
//	private RecipeDTO2 recipeDTO2;
//	private TypeCatDTO2  typeCatDTO2;
//	private RcpIngrDTO2 rcpIngrDTO2;
//	private RcpOrderDTO2 rcpOrderDTO2;
//	private TagDTO2 tagDTO2;

}
