package polymorphism01;

import polymorphism01.TV;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import polymorphism01.BeanFactory;

public class TVUser {
	public static void main(String[] args) {
		/*
		BeanFactory factory = new BeanFactory();
		TV tv = (TV)factory.getBean("samsung");
		tv.powerOn();
		tv.volumeUP();
		tv.volumeDown();
		tv.powerOff();
		*/
		System.out.println("---컨테이너 구동 전---");
		//1.스프링 컨테이너 구동(스프링 설정파일 읽어서)
		AbstractApplicationContext factory = 
				new GenericXmlApplicationContext("applicationContext01.xml");
		System.out.println("---컨테이너 구동 후---");
		
		
		//2. 스프링컨테이너에 생성된 객체 요청(Lookup)
		System.out.println("---객체를 요청하기 전---");
		TV tv = (TV)factory.getBean("tv1Samsung");
		tv.powerOn();
		tv.volumeUP();
		tv.volumeDown();
		tv.powerOff();
		
		
		//3. 스프링 컨테이너 객체 닫기
		factory.close();
		System.out.println("---factory close---");
	}
}
