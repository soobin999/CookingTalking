package com.cook.talk.model.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cook.talk.model.VO.TalkVO;
import com.cook.talk.model.dao.TalkDAO;
import com.cook.talk.model.service.TalkService;

@Service
public class TalkServiceImpl implements TalkService {

	@Autowired
	TalkDAO talkDAO;

	public void insertTalk(TalkVO talkVO) {
		int talkNum = talkDAO.selectTalkCode() + 1;
		talkVO.setTalkCode("T-" + talkNum);
	}
//목록
	@Override
	public List<TalkVO> getTalkList() {
		// TODO Auto-generated method stub
		return talkDAO.getTalkList();
	}
//수정 
	@Override
	public boolean update(TalkVO talkVO) {
		return talkDAO.update(talkVO);
	}
//삭제
	@Override
	public boolean delete(String talkCode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void insert(TalkVO talkVO) {
		// TODO Auto-generated method stub
		int talkNum = talkDAO.selectTalkCode() + 1;
		talkVO.setTalkCode("T-" + talkNum);
		talkDAO.insert(talkVO);
	}
	
	@Override
	public TalkVO talkSearchById(String talkCode) {
		return talkDAO.talkSearchById(talkCode);
	}



}
