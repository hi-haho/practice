package pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("configration.xml");
		MyInput my = (MyInput)context.getBean("my"); //object로 넘어온다.
		my.inputData();
		my.showData();
		//System.out.println(my);
	}

}
