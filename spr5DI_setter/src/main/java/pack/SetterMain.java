package pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("configration.xml");
		OurProcess our = (OurProcess)context.getBean("our"); //object로 넘어온다.
		System.out.println(our);
	}

}
