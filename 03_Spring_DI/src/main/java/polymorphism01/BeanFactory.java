package polymorphism01;

public class BeanFactory {
	//Factory 패턴을 적용
	//TV를 만들어 주는 공장역할 클래스의 메소드
	public Object getBean(String beanName) {
		Object bean = null;
		//요청하는 bean 이름이 samsung이면 SamsungTV를 만들고,
		//lg 면 LgTV를 만들어 전달
		if(beanName.equals("samsung")) {
			bean = new SamsungTV();
		} else if (beanName.equals("lg")) {
			bean = new LgTV();
		}
		return bean;
	}
}
