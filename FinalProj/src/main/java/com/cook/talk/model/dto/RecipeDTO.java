package com.cook.talk.model.dto;

import java.util.List;

import org.springframework.data.annotation.TypeAlias;

import com.cook.talk.model.VO.RcpCatVO;
import com.cook.talk.model.VO.RcpComVO;
import com.cook.talk.model.VO.RcpIngrVO;
import com.cook.talk.model.VO.RcpOrderVO;
import com.cook.talk.model.VO.RecipeVO;
import com.cook.talk.model.VO.UserVO;

import lombok.Data;

@TypeAlias("recipeDto")
@Data
public class RecipeDTO {

	private RcpOrderVO recipeOrder;
	private RecipeVO recipe;
	private List<RcpIngrVO> recipeIngr;
	private List<RcpComVO> recipeCom;
	private List<String> tag;
	private UserVO user;
	private RcpCatVO recipeCat;
}
