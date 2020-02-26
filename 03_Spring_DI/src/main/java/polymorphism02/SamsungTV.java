package polymorphism02;

public class SamsungTV implements TV{
	private SonySpeaker speaker;
	private int price;
	private int width;
	private int height;
	
	
	public SamsungTV() {
		System.out.println(">> SamsungTV 생성");
	}
	
	public SamsungTV(SonySpeaker speaker) {
		System.out.println(">> SamsungTV(Speaker) 객체생성");
		this.speaker = speaker;
	}
	public SamsungTV(SonySpeaker speaker, int price) {
		System.out.println(">> SamsungTV(Speaker, price) 객체생성");
		this.speaker = speaker;
		this.price = price;
	}
	
	public SamsungTV(SonySpeaker speaker, int width, int height) {
		System.out.println(">> SamsungTV(Speaker,width , height) 객체생성");
		this.speaker = speaker;
		this.width = width;
		this.height = height;
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
