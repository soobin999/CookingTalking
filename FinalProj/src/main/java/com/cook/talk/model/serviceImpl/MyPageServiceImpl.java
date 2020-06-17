package com.cook.talk.model.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cook.talk.model.VO.IngrVO;
import com.cook.talk.model.VO.UserVO;
import com.cook.talk.model.dao.MyPageDAO;
import com.cook.talk.model.dao.RecipeDAO;
import com.cook.talk.model.dto.MyPageDTO;
import com.cook.talk.model.dto.RecipeDTO;
import com.cook.talk.model.service.MyPageService;
import com.cook.talk.model.service.RecipeService;

@Service
public class MyPageServiceImpl implements MyPageService{

	@Autowired(required = false)
	private MyPageDAO myPageDAO;
	
	@Override
	public String user(UserVO userVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MyPageDTO> getMyRecipeIng() {
		List<MyPageDTO> getmyRecipeIng = myPageDAO.getMyRecipeIng();
		return getmyRecipeIng;
	}

	@Override
	public List<MyPageDTO> getMyRecipeWritten() {
		List<MyPageDTO> getMyRecipeWritten = myPageDAO.getMyRecipeWritten();
		return getMyRecipeWritten;
	}


}
