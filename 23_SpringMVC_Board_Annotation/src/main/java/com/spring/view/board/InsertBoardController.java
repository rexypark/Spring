package com.spring.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;

@Controller
public class InsertBoardController{
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글등록 처리");
	
		boardDAO.insertBoard(vo);
		
		return "getBoardList.do";
	}
	
	
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
//		System.out.println(">>> 글 등록 처리");
//		//1. 전달받은 데이터 추출
//		String title = request.getParameter("title");
//		String writer = request.getParameter("writer");
//		String content = request.getParameter("content");
//		
//		//2. DB연동 처리(데이터 입력)
//		BoardVO vo = new BoardVO();
//		vo.setTitle(title);
//		vo.setWriter(writer);
//		vo.setContent(content);
//		
//		BoardDAO boardDAO = new BoardDAO();
//		boardDAO.insertBoard(vo);
//		
//		//3. 화면 네비게이션(목록페이지로 이동)
//		//response.sendRedirect("getBoardList.do");
//		//return "getBoardList.do";
//		
//		//3. ModelAndView 형식으로 뷰이름 저장 후 리턴
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("getBoardList.do");
//		
//		return mav;
//	}

}
