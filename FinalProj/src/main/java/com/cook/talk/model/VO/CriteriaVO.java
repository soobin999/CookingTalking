package com.cook.talk.model.VO;

import lombok.Data;

@Data

public class CriteriaVO {

	/** 현재 페이지 번호 */
	private int currentPageNo;

	/** 페이지당 출력할 데이터 개수 */
	private int perPageNum;

	/** 화면 하단에 출력할 페이지 사이즈 */
	private int pageSize;


	public CriteriaVO() {
		this.currentPageNo = 1;
		this.perPageNum = 10;
		this.pageSize = 10;
	}

	public int getStartPage() {
		return (currentPageNo - 1) * perPageNum;
	}

}