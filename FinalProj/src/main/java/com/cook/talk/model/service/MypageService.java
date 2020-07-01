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

	//마이페이지-사용자 사진 변경
	public String user(UserVO userVO);
	/* public String modifyUserPic(String userPic, MultipartFile file); */
	
	//마이페이지-레시피-1.작성중인 레시피-2.작성완료된 레시피-3.레시피 삭제 AT 작성완료된 레시피
	public List<MypageDTO> getMyRecipeIng();
	public List<MypageDTO> getMyRecipeWritten();
	public void deleteRcp(String rcpCode);
	
	//마이페이지-즐겨찾기-1.내가 팔로우한 쉐프-2.내가 스크랩한 레시피-3.쉐프 검색하기-4.레시피 검색하기
	public List<MypageDTO> getMyFollow();
	public List<MypageDTO> getMyScrapedRecipe();
	public List<MypageDTO> getSearchMyFollow(String followChef);
	public List<MypageDTO> getSearchMyScraped(String rcpTitle);
	
	//마이페이지-활동-1.내가 작성한 글-2.내가 작성한 댓글(ALL, ONLY TK, ONLY RCP)
	public List<MypageDTO> getMyTalk();
	public List<MypageDTO> getAllMyCom();
	public List<TalkComVO> getMyTalkCom();
	public List<MypageDTO> getMyRcpCom();
	
	//마이페이지-활동-1.내가 작성한 토크 검색-2.내가 작성한 댓글 검색(ALL, ONLY TK, ONLY RCP)
	public List<MypageDTO> getSearchMyTalk(String talkCont);
	public List<MypageDTO> getSearchAllMyCom(String talkCom);
	public List<MypageDTO> getSearchTalkCom(String talkCom);
	public List<MypageDTO> getSearchRcpCom(String rcpCom);
	
	//마이페이지-문의사항-1.문의사항 입력하기-2.내가 문의한 글 리스트 보기
	public void rqMyInq(QnAVO qnAVO);
	public List<QnAVO> getMyInq();
}
