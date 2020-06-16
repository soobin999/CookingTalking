package com.cook.talk.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import com.cook.talk.model.dto.MyPageDTO;

@Service
@Mapper
public interface MyPageDAO {

	public List<MyPageDTO> getMyRecipeIng();
	
	public List<MyPageDTO> getMyRecipeWritten();
	
}
