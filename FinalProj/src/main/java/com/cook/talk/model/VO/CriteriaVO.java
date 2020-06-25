package com.cook.talk.model.VO;

public class CriteriaVO {
	private int page;
	private int perpageNum;
	private int pageStart;

	public CriteriaVO() {
		this.page = 1;
		this.perpageNum = 10;
	}

	public int getPage() {
		return this.page;
	}
	
	public void setPage(int page) {
		if(page<=0) this.page=1;
		else this.page=page;
	}
	public int getPageNum() {
		return perpageNum;
	}
	
	public void setperpageNum(int pageCount) {
		int cnt= this.perpageNum;
		if(pageCount != cnt) this.perpageNum=cnt;
		else this.perpageNum=pageCount;
	}
	
	public int getpageStart() {
		return this.pageStart=(this.page-1)*perpageNum;
	}
	
}
