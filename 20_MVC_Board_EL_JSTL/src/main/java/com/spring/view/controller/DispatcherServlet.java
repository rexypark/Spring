package com.spring.view.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;
import com.spring.biz.user.UserVO;
import com.spring.biz.user.impl.UserDAO;

//@WebServlet("*.do") 
//web.xml 설정으로 변경
public class DispatcherServlet extends HttpServlet {
	private HandlerMapping handlerMapping;
	private ViewResolver viewResolver;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		handlerMapping = new HandlerMapping();
		viewResolver = new ViewResolver();
		viewResolver.setPrefix("./");
		viewResolver.setSuffix(".jsp");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println(">> *.do 요청에 대한 처리");
		//1. 클라이언트에서 어떤 작업요청이 왔는지 확인
		//   요청path 정보를 확인해서
		String uri = request.getRequestURI();
		System.out.println(uri);
		
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println("path : " + path);
		
		
		
		//핸들러 매핑 호출 패스값 전달 어단 값이 요청 처리 되야 하는지 확인
		//2. 클라이언트 호청 viewName에 따라 작업을 처리
		//   HandlerMapping을 통해 path에 대해서 처리할 컨트롤러 검색
		Controller ctrl = handlerMapping.getController(path);
		
		//3. 검색된 컨트롤러 실행(컨트롤러의 handleRequest 메소드 호출)
		String viewName = ctrl.handleRequest(request, response);
		System.out.println("viewName : " + viewName);
		
		//4. 이동할 view 이름 정보 작성하고 응답페이지 호출
		// viewName에 *.do로 끝나는 것 : *.do 요청처리
		// viewName에 .do가 없으면       : *.jsp 처리
		
		String view = ""; //최종 요청처리할 URL 값
		if (viewName.contains(".do")) {
			view = viewName;
		} else {
			//"./" + "viewName" + ".jsp" 문자열 리턴
			view = viewResolver.getView(viewName);
		}
		
		System.out.println("view : " + view);
		//5. 재요청 처리
		response.sendRedirect(view);
		
		
		
		/*		
		//2. 클라이언트의 요청형태에 따른 작업 처리
		if(path.equals("/login.do")) {
			
		} else if (path.equals("/insertBoard.do")) {
			System.out.println("글등록 처리");
			
			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");
			
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setContent(content);
			

			//1. 글쓰기(INSERT)
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.insertBoard(vo);
			
			response.sendRedirect("getBoardList.do");
			
		} else if (path.equals("/Logout.do")) {
			System.out.println("로그아웃 처리");
			//1. 브라우저와 연결된 세션 객체를 종료(초기화)
			request.getSession().invalidate();

			//2. 화면 네비게이션(로그인 페이지로 이동)
			response.sendRedirect("login.jsp");
			
		} else if (path.equals("/updateBoard.do")) {
			System.out.println("업데이트 처리");
			request.setCharacterEncoding("UTF-8");
			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");
			String seq = request.getParameter("seq");
			
			//2. 업무처리 - DB 연동 처리(수정) 
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setContent(content);
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.updateBoard(vo);
			
			//3. 화면 네비게이션 처리(목록 페이지로)
			response.sendRedirect("getBoardList.do");
			
		} else if (path.equals("/delete.do")) {
			System.out.println("글삭제 처리");
			
			//1. 전달받은 값 추출
			int seq = Integer.parseInt(request.getParameter("seq"));
			
			//2. 업무처리 - DB연동 작업(삭제)
			BoardDAO dao = new BoardDAO();
			BoardVO vo = new BoardVO();
			vo.setSeq(seq);
			dao.deleteBoard(vo);
			
			//3. 화면 네비게이션 처리(목록 페이지로)
			response.sendRedirect("getBoardList.do");
			
		} else if (path.equals("/getBoard.do")) {
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
			
			response.sendRedirect("getBoard.jsp");
			
			
		} else if (path.equals("/getBoardList.do")) {
			
			System.out.println(">>> 글 전체 목록 조회 처리");
			//1. 게시글 목록 조회(SELECT)
			BoardDAO boardDAO = new BoardDAO();
			List<BoardVO> boardList = boardDAO.getBoardList();
			
			//2. 검색결과를 view에서 사용 할 수 있도록 저장
			request.getSession().setAttribute("boardList", boardList);

			//3. 리스트 페이지 새창 에서 호출 (redirect)
			response.sendRedirect("getBoardList.jsp");
		}
		*/ 
	}
}
