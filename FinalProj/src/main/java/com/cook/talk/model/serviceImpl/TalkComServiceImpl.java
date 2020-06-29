package com.cook.talk.model.serviceImpl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cook.talk.model.VO.CriteriaVO;
import com.cook.talk.model.VO.TalkComVO;
import com.cook.talk.model.VO.TalkVO;
import com.cook.talk.model.dao.TalkComDAO;
import com.cook.talk.model.service.TalkComService;

import lombok.AllArgsConstructor;
import lombok.Setter;

@Service
public class TalkComServiceImpl implements TalkComService {
	@Autowired
	TalkComDAO comDAO;

	@Setter(onMethod_ = @Autowired)
	private TalkComService talkComService;

	// 작성
	@Override
	public void createCom(TalkComVO comVO) {
		int talkNum= comDAO.selectTalkComCode()+1;
		System.err.println(talkNum);
		comVO.setTalkComCode("TC-"+talkNum);
		comDAO.createCom(comVO);
	}
	
	
	
	
	
	

	// 수정
	@Override
	public int updateCom(TalkComVO comVO) {
		return comDAO.update(comVO);
	}

	// 삭제
	@Override
	public void deleteCom(String talkComCode) {
	comDAO.deleteCom(talkComCode);
	}

	// 목록

	@Override
	public int comcount(String talkCode) {
		return 0;
	}

	@Override
	public List<TalkComVO> searchComment(String talkCode) {
		return talkComService.searchComment(talkCode);
	}






}
