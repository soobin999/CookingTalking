package com.cook.talk.model.VO;

import java.sql.Date;
import java.util.List;

import lombok.Data;

@Data
public class TalkVO {

	private int talkCode;//코드 
	private String talkCont;//내용
	private String wirter;//작성자
	
	private Date talkDate;//날짜
	
	private String talkVideo;//영상
	private int talkLikeS;//좋아요 수
	private int talkComS;//댓글 수 
}
