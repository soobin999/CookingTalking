package com.cook.talk.model.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cook.talk.model.VO.QnAVO;
import com.cook.talk.model.VO.TalkComVO;
import com.cook.talk.model.VO.UserVO;
import com.cook.talk.model.dto.MypageDTO;

@Service
public interface MypageService {

	public String user(UserVO userVO);
	public String modifyUserPic(String userPic, MultipartFile file);
	
	public List<MypageDTO> getMyRecipeIng();
	public List<MypageDTO> getMyRecipeWritten();
	public void deleteRcp(String rcpCode);
	
	public List<MypageDTO> getMyFollow();
	public List<MypageDTO> getMyScrapedRecipe();
	public List<MypageDTO> getSearchMyFollow(String followChef);
	public List<MypageDTO> getSearchMyScraped(String rcpTitle);
	
	public List<MypageDTO> getMyTalk();
	public List<MypageDTO> getAllMyCom();
	public List<MypageDTO> getSearchAllMyCom(String talkCom);
	public List<MypageDTO> getSearchTalkCom(String talkCom);
	public List<MypageDTO> getSearchRcpCom(String rcpCom);
	public List<TalkComVO> getMyTalkCom();
	public List<MypageDTO> getMyRcpCom();
	public List<MypageDTO> getSearchMyTalk(String talkCont);
	
	public void rqMyInq(QnAVO qnAVO);
	public List<QnAVO> getMyInq();
}
