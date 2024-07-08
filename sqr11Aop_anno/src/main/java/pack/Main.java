package pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("aopInit.xml"); //환경 설정을 가져온다.
		LogicInter inter  = context.getBean("logicImpl",LogicInter.class);
		inter.selectDataProcess1(); //target
		inter.selectDataProcess2(); //target
	}
}
