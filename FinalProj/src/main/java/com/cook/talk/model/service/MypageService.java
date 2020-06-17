package com.cook.talk.model.service;

import java.util.List;

import com.cook.talk.model.VO.QnAVO;
import com.cook.talk.model.VO.UserVO;
import com.cook.talk.model.dto.MypageDTO;

public interface MypageService {

	public String user(UserVO userVO);
	
	public List<MypageDTO> getMyRecipeIng();
	public List<MypageDTO> getMyRecipeWritten();
	
	public List<MypageDTO> getMyFollow();
	public List<MypageDTO> getMyScrapedRecipe();
	
	public List<MypageDTO> getMyTalk();
	public List<MypageDTO> getMyCom();
	public List<MypageDTO> getMyRcpCom();
	
	public String rqMyInq(String qnaTitle, String qnaCont);
	public List<MypageDTO> getMyInq();
}
