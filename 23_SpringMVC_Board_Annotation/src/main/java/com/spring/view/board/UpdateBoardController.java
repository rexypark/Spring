package com.spring.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;

@Controller
public class UpdateBoardController{

	@RequestMapping("/updateBoard.do")
	public ModelAndView updateBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		boardDAO.updateBoard(vo);
		mav.setViewName("getBoardList.do");

		return mav;
	}
	
	
//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
//		System.out.println(">>> 글 수정 처리");
//		//1. 전달 받은 값 추출
//		//request.setCharacterEncoding("UTF-8");
//		String title = request.getParameter("title");
//		String writer = request.getParameter("writer");
//		String content = request.getParameter("content");
//		String seq = request.getParameter("seq");
//		
//		//2. 업무처리 - DB 연동 처리(수정) 
//		BoardVO vo = new BoardVO();
//		vo.setTitle(title);
//		vo.setWriter(writer);
//		vo.setContent(content);
//		vo.setSeq(Integer.parseInt(seq));
//		
//		BoardDAO boardDAO = new BoardDAO();
//		boardDAO.updateBoard(vo);
//		
//		//3. 화면 네비게이션 처리(목록 페이지로)
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
