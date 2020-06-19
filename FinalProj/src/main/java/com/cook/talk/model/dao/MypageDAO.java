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
	
	public void modifyUserPic(UserVO userVO);

	public List<MypageDTO> getMyRecipeIng();
	public List<MypageDTO> getMyRecipeWritten();
	
	public List<MypageDTO> getMyFollow();
	public List<MypageDTO> getMyScrapedRecipe();
	public MypageDTO getSearchMyFollow(String followChef);
	
	public List<MypageDTO> getMyTalk();
	public List<TalkComVO> getMyCom();
	public List<MypageDTO> getMyRcpCom();
	public List<String> getSearchMyTalk(String talkCont);
	
	public String rqMyInq(String qnaTitle, String qnaCont);
	public List<QnAVO> getmyInq();
}
