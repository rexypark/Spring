package com.spring.rexy.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.rexy.board.vo.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO{

	@Autowired
	private SqlSessionTemplate mybatis;
	
	@Override
	public List<BoardVO> getList(BoardVO vo) {
		List<BoardVO> list = mybatis.selectList("getList", vo);
		return list;
	}
	
}
