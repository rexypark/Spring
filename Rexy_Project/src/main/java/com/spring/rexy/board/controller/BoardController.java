package com.spring.rexy.board.controller;

import org.springframework.web.servlet.ModelAndView;

import com.spring.rexy.board.vo.BoardVO;

public interface BoardController {

	ModelAndView getList(BoardVO vo, ModelAndView mav);
}
