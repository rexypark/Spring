package polymorphism01;

import polymorphism02.TV;

public class LgTV implements TV{
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
