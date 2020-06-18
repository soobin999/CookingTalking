package com.cook.talk.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import com.cook.talk.model.VO.QnAVO;
import com.cook.talk.model.VO.TalkComVO;
import com.cook.talk.model.VO.UserVO;
import com.cook.talk.model.dto.MypageDTO;

@Service
@Mapper
public interface MypageDAO {

	public List<MypageDTO> getMyRecipeIng();
	public List<MypageDTO> getMyRecipeWritten();
	
	public List<MypageDTO> getMyFollow();
	public List<MypageDTO> getMyScrapedRecipe();
	
	public List<MypageDTO> getMyTalk();
	public List<TalkComVO> getMyCom();
	public List<MypageDTO> getMyRcpCom();
	
	public String rqMyInq(String qnaTitle, String qnaCont);
	public List<QnAVO> getmyInq();
}
