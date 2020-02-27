package com.spring.biz.board.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.biz.board.BoardVO;

@Repository("BoardDAOMyBatis")
public class BoardDAOMyBatis {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public BoardDAOMyBatis() {
		System.out.println(">> BoardDAOMyBatis 객체 생성");
	}
	
	//CRUD 기능의 메소드 구현
	//글등록
	public void insertBoard(BoardVO vo) {
		System.out.println("===> MyBatis로 insertBoard() 실행");
		mybatis.insert("insertBoard", vo);
	}
	
	//글 수정
	public void updateBoard(BoardVO vo) {
		System.out.println("===> MyBatis로 updateBoard() 실행");
		mybatis.update("updateBoard", vo);
	}
	
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> MyBatis로 deleteBoard() 실행");
		mybatis.delete("deleteBoard", vo);
	}
	
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> Mybatis로 getBoard()실행");
		
		return mybatis.selectOne("getBoard", vo);
	}
	
	public List<BoardVO> getBoardList() {
		System.out.println("===> MyBatis로 getBoardList() 실행");
		List<BoardVO> boardList = mybatis.selectList("getBoardList_nopara");
		return boardList;
	}
	
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> MyBatis로 getBoardList() 실행");
		List<BoardVO> boardList = mybatis.selectList("getBoardList", vo);
		return boardList;
	}
}
