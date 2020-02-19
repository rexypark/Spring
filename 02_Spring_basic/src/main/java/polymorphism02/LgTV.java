package polymorphism02;

import polymorphism02.TV;

public class LgTV implements TV{
	
	
	
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
	public void volumeUP() {
		System.out.println("LgTV - 소리 크게~~");
		
	}

	@Override
	public void volumeDown() {
		System.out.println("LgTV - 소리 작게~~");
		
	}
	
	public void initMethod() {
		System.out.println("LgTV - initMethod 실행");
			
	}
	
	public void destroyMethod() {
		System.out.println("LgTV - destroyMethod 실행");
		
	}
}
