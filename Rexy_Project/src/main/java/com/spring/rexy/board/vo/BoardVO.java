package com.spring.rexy.board.vo;

import java.util.Date;

public class BoardVO {
	private String  title, writer, content;
	private int board_seq, cnt;
	private Date regdate;
	               //검색 필터 조건         //검색 키워드 
	private String searchCondition, searchKeyword;
	
	
	
	public BoardVO() {
	
	}
	
	
	//검색 필터링 변수
	
	
	
	public String getTitle() {
		return title;
	}
	public String getSearchCondition() {
		return searchCondition;
	}


	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}


	public String getSearchKeyword() {
		return searchKeyword;
	}


	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}


	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getBoard_seq() {
		return board_seq;
	}
	public void setBoard_seq(int board_seq) {
		this.board_seq = board_seq;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	
}
