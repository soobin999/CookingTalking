package com.cook.talk.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import com.cook.talk.model.VO.TalkVO;
import com.cook.talk.model.dto.TalkDTO;

@Mapper
public interface TalkDAO {

	// 전체 목록
	public List<TalkVO> getTalkList();

	// 등록
	public int insert(TalkVO talkVO);

	// 삭제
	public int delete(String talkCode);

	// 수정
	public boolean update(TalkVO talkVO);

	public int selectTalkCode();

	public TalkVO talkSearchById(String talkCode);

}
