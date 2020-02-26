package polymorphism04;

public class SonySpeaker implements Speaker{
	
    public SonySpeaker() {
	
    }
	
	@Override
	public void volumeUp() {
		System.out.println(">> SonySpeaker - 소리높여~~");
	}
	@Override
	public void volumeDown() {
		System.out.println(">> SonySpeaker - 소리내려~~");
		
	}
	
}
