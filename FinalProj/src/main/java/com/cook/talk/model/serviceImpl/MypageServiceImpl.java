package com.cook.talk.model.serviceImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cook.talk.model.VO.QnAVO;
import com.cook.talk.model.VO.TalkComVO;
import com.cook.talk.model.VO.UserVO;
import com.cook.talk.model.dao.MypageDAO;
import com.cook.talk.model.dao.QnADAO;
import com.cook.talk.model.dto.MypageDTO;
import com.cook.talk.model.service.MypageService;

@Service
public class MypageServiceImpl implements MypageService{

	@Autowired(required = false)
	private MypageDAO mypageDAO;
	
	@Autowired(required = false)
	private QnADAO qnADAO;
	
	@Override
	public String user(UserVO userVO) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	/*
	 * //마이페이지 유저 사진 업로드 OR 수정
	 * 
	 * @Override public String modifyUserPic(String
	 * userPic, @RequestParam("userPic") MultipartFile file) {
	 * 
	 * String save =
	 * "C:/git/cookingtalking/FinalProj/src/main/resources/static/userImg/";
	 * 
	 * System.out.println("file:"+file);
	 * 
	 * 
	 * try {
	 * 
	 * byte[] bytes = file.getBytes(); Path path = Paths.get(save +
	 * file.getOriginalFilename()); Files.write(path, bytes);
	 * 
	 * } catch (IOException e) { e.printStackTrace(); }
	 * 
	 * mypageDAO.modifyUserPic(userPic); return "정상적으로 등록되었습니다"; }
	 */

	
	//작성중인 레시피 가져오기
	@Override
	public List<MypageDTO> getMyRecipeIng() {
		List<MypageDTO> getmyRecipeIng = mypageDAO.getMyRecipeIng();
		return getmyRecipeIng;
	}

	
	//작성완료된 레시피 가져오기
	@Override
	public List<MypageDTO> getMyRecipeWritten() {
		List<MypageDTO> getMyRecipeWritten = mypageDAO.getMyRecipeWritten();
		return getMyRecipeWritten;
	}

	
	//팔로우한 쉐프 목록 가져오기
	@Override
	public List<MypageDTO> getMyFollow() {
		List<MypageDTO> getMyFollow = mypageDAO.getMyFollow();
		return getMyFollow;
	}

	
	//스크랩한 레시피 목록 가져오기
	@Override
	public List<MypageDTO> getMyScrapedRecipe() {
		List<MypageDTO> getMyScrapedRecipe = mypageDAO.getMyScrapedRecipe();
		return getMyScrapedRecipe;
	}

	
	//내가 작성한 토크 목록 가져오기
	@Override
	public List<MypageDTO> getMyTalk() {
		List<MypageDTO> getMyTalk = mypageDAO.getMyTalk();
		return getMyTalk;
	}
	
	
	//내가 작성한 모든 댓글(RCP+TK) 가져오기
	@Override
	public List<MypageDTO> getAllMyCom() {
		List<MypageDTO> getAllMyCom = mypageDAO.getAllMyCom();
		return getAllMyCom;
	}
	
	//내가 작성한 토크 댓글만 가져오기
	@Override
	public List<TalkComVO> getMyTalkCom() {
		List<TalkComVO> getMyTalkCom = mypageDAO.getMyTalkCom();
		return getMyTalkCom;
	}
	
	//내가 작성한 레시피 댓글만 가져오기
	@Override
	public List<MypageDTO> getMyRcpCom() {
		List<MypageDTO> getMyRcpCom = mypageDAO.getMyRcpCom();
		return getMyRcpCom;
	}
	
	//모든 댓글(RCP+TK) 검색하기
	@Override
	public List<MypageDTO> getSearchAllMyCom(String talkCom) {
		List<MypageDTO> getSearchAllMyCom = mypageDAO.getSearchAllMyCom(talkCom);
		return getSearchAllMyCom;
	}


	@Override
	public void rqMyInq(QnAVO qnAVO) {
			/* recipe.setRcpCode("Q-" + qnACount); */
		int qnACode = mypageDAO.selectQnACode() + 1;
		qnAVO.setQnaCode("Q-"+qnACode);
		mypageDAO.rqMyInq(qnAVO);
	}

	@Override
	public List<QnAVO> getMyInq(String userId) {
		List<QnAVO> getMyInq = mypageDAO.getmyInq(userId); 
		return getMyInq;
	}

	@Override
	public List<MypageDTO> getSearchMyFollow(String followChef) {
		return mypageDAO.getSearchMyFollow(followChef);
	}

	@Override
	public List<MypageDTO> getSearchMyTalk(String talkCont) {
		return mypageDAO.getSearchMyTalk(talkCont);
		
	}

	@Override
	public List<MypageDTO> getSearchMyScraped(String rcpTitle) {
		return mypageDAO.getSearchMyScraped(rcpTitle);
	}

	@Override
	public List<MypageDTO> getSearchTalkCom(String talkCom) {
		return mypageDAO.getSearchTalkCom(talkCom);
	}

	@Override
	public List<MypageDTO> getSearchRcpCom(String rcpCom) {
			return mypageDAO.getSearchRcpCom(rcpCom);
	}

	@Transactional
	public void deleteRcp(String rcpCode) {
		mypageDAO.deleteRcp(rcpCode);
	}

}
