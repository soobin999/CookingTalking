package com.cook.talk.model.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import com.cook.talk.model.VO.TalkVO;

@Service

public interface TalkService {
//게시글 작성 
	public void wirte(TalkVO talkVO) throws Exception;

	// 게시글 상세 보기
	public TalkVO read(int talkCode) throws Exception;

	// 게시글 수정
	public TalkVO update(TalkVO talkVO) throws Exception;

	// 게시물 삭제
	public void delete(int talkCode) throws Exception;

	//게시글 전체 목록 
	public List<TalkVO> listAll() throws Exception;
	
	//게시글 조회
	public void increaseViewcount(int talkCode,HttpSession session) throws Exception;
}
