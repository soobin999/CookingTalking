package com.cook.talk.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cook.talk.model.VO.IngrVO;

@Mapper
public interface AdIngrDAO {

	public List<IngrVO> searchIngr(String ingrVO);

	public List<IngrVO> allSelectIngr();

	public void insertIngr(IngrVO ingrVO);

	public void deleteIngr(List<String> rcpingrCode);

	public int selectIngrRcpCode();

}
