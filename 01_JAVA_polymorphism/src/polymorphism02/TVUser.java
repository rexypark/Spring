package polymorphism02;

public class TVUser {
	public static void main(String[] args) {
		//삼성TV
		SamsungTV ssTV = new SamsungTV();
		//엘지TV
		LgTV  lgTV = new LgTV();
		/*
		ssTV.powerOn();
		ssTV.volumeUP();
		ssTV.volumeDown();
		ssTV.powerOff();
		*/
		lgTV.on();
		lgTV.off();
		lgTV.soundUp();
		lgTV.soundDown();
	}
}
