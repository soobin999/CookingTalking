package com.cook.talk.model.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cook.talk.model.VO.TalkComVO;
import com.cook.talk.model.service.TalkComService;

import lombok.AllArgsConstructor;
import lombok.Setter;

@Service
public class TalkComServiceImpl implements TalkComService {


@Setter(onMethod_ = @Autowired)
private TalkComService talkComService;


	@Override
	public int comInsert(TalkComVO comVO) {
		// TODO Auto-generated method stub
		return talkComService.comInsert(comVO);
	}

	@Override
	public TalkComVO readCom(String talkComCode) {
		// TODO Auto-generated method stub
		return talkComService.readCom(talkComCode);
	}

	@Override
	public int updateCom(TalkComVO comVO) {
		// TODO Auto-generated method stub
		return talkComService.updateCom(comVO);
	}

	@Override
	public int deleteCom(int talkComCode) {
		// TODO Auto-generated method stub
		return talkComService.deleteCom(talkComCode);
	}

	
}
