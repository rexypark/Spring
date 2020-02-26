package di_annotation;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

//객체 생성 요청을 하는 어노테이션
@Component
public class LgTV implements TV {
	@Resource(name="speaker")
	private Speaker speacker;
	
	public LgTV() {
		System.out.println(">> LgTV 생성");
	}
	
	@Override
	public void powerOn() {
		System.out.println("LgTV - 전원 ON");
	}
	@Override
	public void powerOff() {
		System.out.println("LgTV - 전원 OFF");
		
	}
	@Override
	public void volumnUp() {
		System.out.println("LgTV - 소리 크게~~");
		speacker.volumnUp();
	}
	@Override
	public void volumnDown() {
		System.out.println("LgTV - 소리 작게~~");
		speacker.volumnDown();
	}

	//--------------------------------
	public void initMethod() {
		System.out.println("LgTV - initMethod() 실행");
	}
	public void destroyMethod() {
		System.out.println("LgTV - destroyMethod() 실행");
		
	}	
}
