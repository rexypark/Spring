package com.spring.rexy.board.service;

import java.util.List;


import com.spring.rexy.board.vo.BoardVO;

public interface BoardService {
	List<BoardVO> getList(BoardVO vo);
}
