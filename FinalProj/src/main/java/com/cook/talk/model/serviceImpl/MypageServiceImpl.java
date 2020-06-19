package com.cook.talk.model.serviceImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

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
	
	@Override
	public String modifyUserPic(UserVO userVO, @RequestParam("userPic") MultipartFile file) {

		String PicFromFolder = "";
		
		System.out.println("file:"+file);
		System.out.println("userVO"+userVO);
		
		try {
			
			byte[] bytes = file.getBytes();
			Path path = Paths.get(file + file.getOriginalFilename());
			Files.write(path, bytes);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		mypageDAO.modifyUserPic(userVO);
		return "정상적으로 등록되었습니다";
	}

	@Override
	public List<MypageDTO> getMyRecipeIng() {
		List<MypageDTO> getmyRecipeIng = mypageDAO.getMyRecipeIng();
		return getmyRecipeIng;
	}

	@Override
	public List<MypageDTO> getMyRecipeWritten() {
		List<MypageDTO> getMyRecipeWritten = mypageDAO.getMyRecipeWritten();
		return getMyRecipeWritten;
	}

	@Override
	public List<MypageDTO> getMyFollow() {
		List<MypageDTO> getMyFollow = mypageDAO.getMyFollow();
		return getMyFollow;
	}

	@Override
	public List<MypageDTO> getMyScrapedRecipe() {
		List<MypageDTO> getMyScrapedRecipe = mypageDAO.getMyScrapedRecipe();
		return getMyScrapedRecipe;
	}

	@Override
	public List<MypageDTO> getMyTalk() {
		List<MypageDTO> getMyTalk = mypageDAO.getMyTalk();
		return getMyTalk;
	}
	
	@Override
	public List<MypageDTO> getAllMyCom() {
		List<MypageDTO> getAllMyCom = mypageDAO.getAllMyCom();
		return getAllMyCom;
	}
	
	@Override
	public List<String> getSearchAllMyCom(String talkCom, String talkDate) {
		List<String> getSearchAllMyCom = mypageDAO.getSearchAllMyCom(talkCom, talkDate);
		return getSearchAllMyCom;
	}


	@Override
	public List<TalkComVO> getMyTalkCom() {
		List<TalkComVO> getMyTalkCom = mypageDAO.getMyTalkCom();
		return getMyTalkCom;
	}

	@Override
	public List<MypageDTO> getMyRcpCom() {
		List<MypageDTO> getMyRcpCom = mypageDAO.getMyRcpCom();
		return getMyRcpCom;
	}

	@Override
	public String rqMyInq(String qnaTitle, String qnaCont) {
		 int qnACount = qnADAO.selectQnACode() +1;
			/* recipe.setRcpCode("Q-" + qnACount); */
		String myInq = mypageDAO.rqMyInq(qnaTitle, qnaCont);
		return myInq;
	}

	@Override
	public List<QnAVO> getMyInq() {
		List<QnAVO> getMyInq = mypageDAO.getmyInq(); 
		return getMyInq;
	}

	@Override
	public List<String> getSearchMyFollow(String followChef) {
		return mypageDAO.getSearchMyFollow(followChef);
	}

	@Override
	public List<String> getSearchMyTalk(String talkCont) {
		return mypageDAO.getSearchMyTalk(talkCont);
		
	}

	@Override
	public List<String> getSearchMyScraped(String rcpTitle, String rcpPic) {
		return mypageDAO.getSearchMyScraped(rcpTitle, rcpPic);
	}


	


}
