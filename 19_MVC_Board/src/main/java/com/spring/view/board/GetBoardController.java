package com.spring.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;
import com.spring.view.controller.Controller;

public class GetBoardController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(">>> 글 조회 처리");
		
		//1. 전달받은 데이터 추출
		int seq = Integer.parseInt(request.getParameter("seq"));	
		
		
		//2. DB 연동 처리(하나의 글 조회)
		BoardDAO boardDAO = new BoardDAO();
		BoardVO vo = new BoardVO();
		vo.setSeq(seq);
		
		BoardVO board = boardDAO.getBoard(vo);
		
		//board 데이터 저장
		request.getSession().setAttribute("board", board);
		
		return "getBoard";
	}

}
