package pack.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		/**/
		
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:tot.xml");
		System.out.println(" == singleton 확인하세요 ==");
		
		MessageImpl impl1 = (MessageImpl)context.getBean("mImpl");
		impl1.sayHi();
		MessageImpl impl2 = (MessageImpl)context.getBean("mImpl");
		impl2.sayHi();
		System.out.println("객체 주소 : " + impl1 +" - " + impl2); // 스프링은 bean을 인스턴스할 때 싱글톤을 기본으로 만든다.***
		
		//다형성 처리
		System.out.println("\n++ 다형성 처리하세요 ++");
		MessageInter inter = (MessageInter)context.getBean("mImpl");
		inter.sayHi();
		
		System.out.println("\n-- 다형성 처리하세요 --");
		MessageInter inter2 = context.getBean("mImpl",MessageInter.class);
		inter2.sayHi();
		
		context.close();
	}
}
