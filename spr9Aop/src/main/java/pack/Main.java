package pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("aopInit.xml"); //환경 설정을 가져온다.
		
		//AOP 적용 전
		//MessageInter inter = (MessageInter)context.getBean("targetBean");
		//inter.sayHi();
		
		//Aop 적용 후
		MessageInter inter = (MessageInter)context.getBean("proxy");
		inter.sayHi();
	}
}
