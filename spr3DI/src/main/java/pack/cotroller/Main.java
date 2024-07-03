package pack.cotroller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("init.xml"); //인스턴스
		Myinter myInter = (Myinter)context.getBean("myProcess");
		myInter.inputMoney();
		myInter.showResult();
	}

}
