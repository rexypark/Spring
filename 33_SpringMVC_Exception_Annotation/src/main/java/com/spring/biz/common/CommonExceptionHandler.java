package com.spring.biz.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//@ControllerAdvice : 객체생성 + 적용범위 설정
//com.spring.view 포함 하위패키지에서 발생하는 예외를 처리하는 클래스
@ControllerAdvice("com.spring.view") //해당 경로에서 발생 한 예외는 현재 이곳에서 처리한다.
public class CommonExceptionHandler {
	
	//@ExceptionHandler : 해당 예외 발생 시 메소드 실행
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception e) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("exception", e);
		mav.setViewName("/common/errorException.jsp");
		return mav;
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ModelAndView handleException(IllegalArgumentException e) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("exception", e);
		mav.setViewName("/common/errorIllegalArgumentException.jsp");
		return mav;
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView handleException(NullPointerException e) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("exception", e);
		mav.setViewName("/common/errorNullPointerException.jsp");
		return mav;
	}
}
