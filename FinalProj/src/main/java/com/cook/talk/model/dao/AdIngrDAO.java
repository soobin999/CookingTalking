package com.cook.talk.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import com.cook.talk.model.VO.IngrVO;

@Mapper
public interface AdIngrDAO {

	public List<IngrVO> searchIngr(IngrVO ingrVO);

	public List<IngrVO> allSelectIngr();

	public void insertIngr(IngrVO ingrVO);

	public void deleteIngr(IngrVO ingrVO);

	public int selectIngrRcpCode();

}
