package com.spring.rexy.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.rexy.board.dao.BoardDAO;
import com.spring.rexy.board.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	BoardDAO boardDAO;
	
	@Override
	public List<BoardVO> getList(BoardVO vo) {
			List<BoardVO> list = boardDAO.getList(vo);
		return list;
	}
}
