package com.spring.rexy.board.dao;

import java.util.List;

import com.spring.rexy.board.vo.BoardVO;

public interface BoardDAO {

	List<BoardVO> getList(BoardVO vo);
	
}
