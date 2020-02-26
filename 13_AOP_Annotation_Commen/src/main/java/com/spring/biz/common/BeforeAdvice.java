package com.spring.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service //객체(인스턴스) 생성 [xml bean태그]
@Aspect
public class BeforeAdvice {
	
	//어드바이스 메소드
	//어드바이스에 동작시점 설정 + 포인트 컷 지정
	@Before("PointcutCommen.getPointcut()")
	public void beforeLog(JoinPoint jp) {
		String methodName = jp.getSignature().getName(); //실행될 메소드명
		Object[] args = jp.getArgs();
		
		String paramStr = "파라미터 없음";
		if (args.length != 0 && args != null) {
			paramStr = args[0].toString();
		}
		System.out.println("[사전처리] " + methodName + " 메소드"
				+ ", args 정보 : " + paramStr);
		
	}
}
