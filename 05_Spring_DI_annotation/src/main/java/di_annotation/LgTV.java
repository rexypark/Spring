package di_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import di_annotation.TV;

//객체 생성 요청을 하는 어노테이션
@Component
public class LgTV implements TV{
	@Autowired
	@Qualifier("apple")
	private Speaker speaker;
	
	
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
		speaker.volumeUp();
	}

	@Override
	public void volumeUP() {
		System.out.println("LgTV - 소리 크게~~");
		speaker.volumeDown();
	}

	@Override
	public void volumeDown() {
		System.out.println("LgTV - 소리 작게~~");
		
	}
}
