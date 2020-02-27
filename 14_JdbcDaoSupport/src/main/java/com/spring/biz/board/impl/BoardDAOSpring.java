package com.spring.biz.board.impl;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.spring.biz.board.BoardVO;

@Repository("boardDAOSpring")
public class BoardDAOSpring extends JdbcDaoSupport{
	//SQL문
	private final String BOARD_INSERT
		= "INSERT INTO BOARD (SEQ, TITLE, WRITER, CONTENT)"
		+ "VALUES ((SELECT NVL(MAX(SEQ), 0) + 1 FROM BOARD), ?, ?, ?)";
	private final String BOARD_UPDATE
		= "UPDATE BOARD SET TITLE = ?, CONTENT = ? WHERE SEQ = ?";
	private final String BOARD_DELETE
		= "DELETE FROM BOARD WHERE SEQ = ?";
	private final String BOARD_GET
		= "SELECT * FROM BOARD WHERE SEQ = ?";
	private final String BOARD_LIST
		= "SELECT * FROM BOARD ORDER BY SEQ DESC";
	
	@Autowired //파라미터 타입과 동일 객체 주입하면서 메소드 호출 실행
	void setSuperDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	//CRUD 기능의 메소드 구현
	
	public void insertBoard(BoardVO vo) {
		System.out.println("====> Spring JDBC로 insertBoard() 실행");
		Object[] args = {vo.getTitle(), vo.getWriter(), vo.getContent()};
		getJdbcTemplate().update(BOARD_INSERT, args);
		
	}

	public void updateBoard(BoardVO vo) {
		System.out.println("====> Spring JDBC로 updateBoard() 실행");
		getJdbcTemplate().update(BOARD_UPDATE, vo.getTitle(), vo.getContent());
		
	}
	public void deleteBoard(BoardVO vo) {
		System.out.println("====> Spring JDBC로 deleteBoard() 실행");
		getJdbcTemplate().update(BOARD_DELETE, vo.getSeq());
	}
	
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("====> Spring JDBC로 getBoard() 실행");
		Object[] args = {vo.getSeq()};
		
		return getJdbcTemplate().queryForObject(BOARD_GET, args, new BoardRowMapper());
	}
	
	public List<BoardVO> getBoardList() {
		System.out.println("====> Spring JDBC로 getBoardList() 실행");
		return  getJdbcTemplate().query(BOARD_LIST, new BoardRowMapper());
	}
}
