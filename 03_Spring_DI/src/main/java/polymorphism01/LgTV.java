package polymorphism01;

import polymorphism01.TV;

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
}
