package com.spring.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;

@Controller
public class DeleteBoardController {

	@RequestMapping("/deleteBoard.do")
	public ModelAndView deleteBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		boardDAO.deleteBoard(vo);
		mav.setViewName("getBoardList.do");
		
		return mav;
	}
	
//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
//		System.out.println(">>> 글 삭제 처리");
//		//1. 전달받은 값 추출
//		String seq = request.getParameter("seq");
//		
//		//2. 업무처리-DB연동작업(삭제)
//		BoardVO vo = new BoardVO();
//		vo.setSeq(Integer.parseInt(seq));
//		
//		BoardDAO boardDAO = new BoardDAO();
//		boardDAO.deleteBoard(vo);
//		
//		//3. 화면 네비게이션 처리(목록)
//		//response.sendRedirect("getBoardList.do");
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("getBoardList.do");
//		
//		//return "getBoardList.do";
//		return mav;
//	}

}
