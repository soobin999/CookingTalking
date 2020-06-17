package com.cook.talk.model.service;

import java.util.List;

import com.cook.talk.model.VO.UserVO;
import com.cook.talk.model.dto.MyPageDTO;

public interface MyPageService {

	public String user(UserVO userVO);
	
	public List<MyPageDTO> getMyRecipeIng();
	
	public List<MyPageDTO> getMyRecipeWritten();
}
