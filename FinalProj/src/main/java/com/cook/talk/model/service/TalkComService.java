package com.cook.talk.model.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cook.talk.model.VO.TalkComVO;

public interface TalkComService {

	//등록
	public int comInsert(TalkComVO comVO );
	
	//읽기
	public TalkComVO readCom (String talkComCode);
	
	//수정
	public int updateCom (TalkComVO comVO);
	
	//삭제 
	public int deleteCom (int talkComCode);
	
	/*
	 * public List<TalkComVO> getListWithPaging(
	 * 
	 * @Param("talkComCode") )
	 */
	
	
}
