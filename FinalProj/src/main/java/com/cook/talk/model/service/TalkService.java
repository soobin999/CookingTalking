package com.cook.talk.model.service;



import java.util.List;

import com.cook.talk.model.VO.TalkVO;

public interface TalkService {
	// 목록 가져오기
	public List<TalkVO> getTalkList();

	// 추가
	public void insert(TalkVO talkVO);

	// 수정
	public boolean update(TalkVO talkVO);

	// 삭제
	public boolean delete(String talkCode);

}
