package com.cook.talk.model.VO;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;

import lombok.Data;
@Alias("talkVO")
@Data
public class TalkVO {

	private String talkCode;//코드 
	private String talkCont;//내용
	private Date talkDate;//날짜
	private String talkVideo;//영상
	private int talkLike;//좋아요 수
	private int talkCom;//댓글 수 
}
