package com.spring.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;

@Controller
public class GetBoardController{
	@RequestMapping("/getBoard.do")
	public ModelAndView getBoardDetail(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		System.out.println(">>> 글 상세 조회 처리");
		//1. 전달받은 데이터 추출
		BoardVO board = boardDAO.getBoard(vo);
		mav.addObject("board", board); //데이터 저장
		mav.setViewName("getBoard.jsp");
		
		return mav;
	}
	
	
//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
//		System.out.println(">>> 글 상세 조회 처리");
//		//1. 전달받은 데이터 추출
//		String seq = request.getParameter("seq");
//		
//		//2. DB 연동 처리(하나의 글 조회)
//		BoardVO vo = new BoardVO();
//		vo.setSeq(Integer.parseInt(seq));
//		
//		BoardDAO boardDAO = new BoardDAO();
//		BoardVO board = boardDAO.getBoard(vo);
//		
//		//3. 검색결과를 세션에 저장(뷰에서 사용토록)하고 상세보기 화면으로 이동
//		HttpSession session = request.getSession();
//		session.setAttribute("board", board);
//		
//		//response.sendRedirect("getBoard.jsp");
//		//return "getBoard";
//		
//		//3. ModelAndView 형식으로 데이터와 뷰이름 저장
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("board", board); //데이터 저장
//		mav.setViewName("getBoard.jsp");
//		
//		return mav;
//	}
//
}
