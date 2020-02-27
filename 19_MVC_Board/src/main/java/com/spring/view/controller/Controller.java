package com.spring.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 작성 할 Controller가 처리할 메소드를 통일시키기 위해
     인터페이스를 만들고 모든 Controller는 implements 해서
     작성하도록 처리하기 위해 만든 인터페이스(표준화)
	
	
*/
public interface Controller {

	String handleRequest(HttpServletRequest request, HttpServletResponse response);
}
