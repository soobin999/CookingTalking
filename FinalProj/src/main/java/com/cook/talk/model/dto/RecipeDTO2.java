package com.cook.talk.model.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class RecipeDTO2 {
	
	private String rcpCode;
	private String rcpTitle;
	private String rcpPic;
	private String personnel;
	private String cookTime;
	private String level;
	private String video;
	private String rcpExpl;
	private Date rcpDate;
	private boolean registerStatus;
	private int rcpViews;
	
}
