package polymorphism01;

public class SamsungTV implements TV{
	private SonySpeaker speaker;
	
	public SamsungTV() {
		System.out.println(">> SamsungTV 생성");
		//필드에 있는 SonySpeaker에 객체 주입
		//SonySpeaker는 SamsungTV에 의존하고 있다.
		speaker = new SonySpeaker();
	}

	public void powerOn() {
		System.out.println("SamsungTV - 전원 ON");
		speaker.volumeUp();
	}
	
	public void powerOff() {
		System.out.println("SamsungTV - 전원 OFF");
	}
	
	public void volumeUP() {
		System.out.println("SamsungTV - 소리크게");
	}
	
	public void volumeDown() {
		System.out.println("SamsungTV - 소리작게");
	}
	
}
