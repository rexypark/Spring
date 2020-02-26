package di_collection;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanClient {
	
	public static void main(String[] args) {
		System.out.println("--- 컨테이너 구동 전 ---");
		//1. 스프링 컨테이너 구동
		AbstractApplicationContext factory = 
			new GenericXmlApplicationContext("applicationContext.xml");
		System.out.println("--- 컨테이너 구동 후 ---");
		
		//2. 스프링 컨테이너에 생성한 객체 요청(Lookup)
		System.out.println(">> 객체 요청 전");
		System.out.println("--- List 타입 ---");
		CollectionBean bean = (CollectionBean)factory.getBean("collectionBean");
		System.out.println("bean list : " + bean.getAddressList());
		System.out.println("bean set : " + bean.getAddressSet());
		System.out.println("bean map : " + bean.getAddressMap());
		System.out.println("bean addressProp : " + bean.getAddressProp());
		//3. 컨테이너 닫기
		factory.close();
	}
}
