package com.spring.biz.common;

import static org.hamcrest.CoreMatchers.instanceOf;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterThrowingAdvice {
//	public void exceptionLog() {
//		System.out.println("[예외처리-AfterThrowingAdvice.exceptionLog]"
//				+ "비즈니스 로직 수행중 예외발생시 로그");
//	}
	/*
	<aop:pointcut id="allPointcut" 
		expression="execution(* com.spring.biz..*Impl.*(..))" />
	<aop:pointcut id="getPointcut" 
		expression="execution(* com.spring.biz..*Impl.get*(..))" />
	*/
	@Pointcut("execution(* com.spring.biz..*Impl.*(..))")
	public void allPointcut(){}
	//JoinPoint 이외 바인드 변수 exceptionObj 사용
	@AfterThrowing(pointcut="allPointcut()", throwing="exceptObj")
	public void exceptionLog(JoinPoint jp, Exception exceptObj) {
		String methodName = jp.getSignature().getName();
		
		if (exceptObj instanceof IllegalArgumentException) {
			System.out.println(">> 부적합한 값이 입력되었습니다.");
		} else if (exceptObj instanceof NumberFormatException) {
			System.out.println(">> 숫자형식이 아닙니다.");
		} else if (exceptObj instanceof Exception) {
			System.out.println(">> 문제가 발생 했습니다.");
		}
		System.out.println("[예외처리] " + methodName + " 메소드"
				+ "실행 중 예외발생, 메시지 : " + exceptObj.getMessage());
	}
}
