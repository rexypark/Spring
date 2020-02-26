package di_annotation;

import org.springframework.stereotype.Component;

@Component("apple")
public class AppleSpeaker implements Speaker{

	public AppleSpeaker() {}
	
	@Override
	public void volumeUp() {
		System.out.println(">> AppleSpeaker - 소리높여~~");
		
	}
	@Override
	public void volumeDown() {
		System.out.println(">> AppleSpeaker - 소리높여~~");
		
	}
}
