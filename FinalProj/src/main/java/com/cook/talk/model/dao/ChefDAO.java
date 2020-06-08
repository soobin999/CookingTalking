package com.cook.talk.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import com.cook.talk.model.VO.RecipeVO;
import com.cook.talk.model.dto.ChefDTO;

@Mapper
public interface ChefDAO {

	public ChefDTO selectChefDetail(String userId);

	public int selectFollow(String userId,String chefId);

	public List<ChefDTO> selectRecipe(String userId);

	public List<ChefDTO> allSelectChef(String status);

}