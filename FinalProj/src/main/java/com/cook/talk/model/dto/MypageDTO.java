package com.cook.talk.model.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class MypageDTO {
	
	private String userId;
	private String nickName;
	
	private String rcpTitle;
	private String rcpPic;
	private int registerStatus;
	
	private String followChef;
	private Date scrapedDate;
	
	private String talkCont;
	private Date talkDate;
	
	
	private String rcpCom;
	private Date rcpComDate;
	
}
