package com.cook.talk.model.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cook.talk.model.VO.TalkVO;

@Service
public interface TalkDAO {

	// 게시글 작성
	public void write(TalkVO talkVO) throws Exception;

	// 상세보기
	public TalkVO read(int talkCode) throws Exception;

	// 수정
	public TalkVO update(TalkVO talkVO)throws Exception;
	
	//삭제
	public void delete(int talkCode)throws Exception;

	//전체 목록
	public List<TalkVO> listAll() throws Exception;

	public void increaseViewconut(int talkCode)throws Exception;

	

}
