package polymorphism04;

public class AppleSpeaker implements Speaker{

	public AppleSpeaker() {
	}
	@Override
	public void volumeUp() {
		System.out.println(">> AppleSpeaker - 소리높여~~");
		
	}
	@Override
	public void volumeDown() {
		System.out.println(">> AppleSpeaker - 소리높여~~");
		
	}
}
