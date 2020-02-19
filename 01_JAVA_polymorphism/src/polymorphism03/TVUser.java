package polymorphism03;

import polymorphism03.TV;
import polymorphism03.BeanFactory;

public class TVUser {
	public static void main(String[] args) {
		BeanFactory factory = new BeanFactory();
		TV tv = (TV)factory.getBean("samsung");
		tv.powerOn();
		tv.volumeUP();
		tv.volumeDown();
		tv.powerOff();
	}
}
