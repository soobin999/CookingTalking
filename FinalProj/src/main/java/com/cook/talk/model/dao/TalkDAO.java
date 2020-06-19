package com.cook.talk.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cook.talk.model.VO.TalkVO;

@Mapper
public interface TalkDAO {

	// 전체 목록
	public List<TalkVO> getTalkList();

	// 등록
	public int insert(TalkVO talkVO);

	// 삭제
	public int delete(String talkCode);

	// 수정
	public int update(TalkVO talkVO);

	//코드 증가
	public int selectTalkCode();
	
	//보기 
	public TalkVO detail(String talkCode);

}
