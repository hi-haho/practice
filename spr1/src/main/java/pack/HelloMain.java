package pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloMain {

	public static void main(String[] args) {
		//처리1 (레거시)
		Message1 m1 = new Message1();
		m1.sayHello("신짱구");
		Message2 m2 = new Message2();
		m2.sayHello("신짱아");
		
		System.out.println("\n-------\n");
		
		MessageInter inter;
		inter = m1;
		inter.sayHello("봉미선");
		inter = m2;
		inter.sayHello("신형만");
		System.out.println("\n-------\n");
		
		//처리2 (Spring 사용)/xml 사용
		ApplicationContext context = new ClassPathXmlApplicationContext("init.xml");// == classpath:init.xml
		//ApplicationContext context = new ClassPathXmlApplicationContext("classpath:pack.init.xml"); //init.xml의 위치가 다른 경우
		MessageInter inter2 = (MessageInter)context.getBean("mes1");
		inter2.sayHello("철수");
		MessageInter inter3 = (MessageInter)context.getBean("mes2");
		inter3.sayHello("유리");
	}

}
