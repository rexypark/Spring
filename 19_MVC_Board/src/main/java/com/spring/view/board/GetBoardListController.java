package com.spring.view.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;
import com.spring.view.controller.Controller;

public class GetBoardListController implements Controller {
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(">>> 글 전체 목록 조회 처리");
		//1. 게시글 목록 조회(SELECT)
		BoardDAO boardDAO = new BoardDAO();
		List<BoardVO> boardList = boardDAO.getBoardList();
		
		//2. 검색결과를 view에서 사용 할 수 있도록 저장
		request.getSession().setAttribute("boardList", boardList);

		//3. 리스트 페이지 새창 에서 호출 (redirect)
		return "getBoardList";
	}
}
