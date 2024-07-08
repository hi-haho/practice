package pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// @Configuration //xml안쓰는 것도 가능
public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("init.xml");
		BusinessInter inter = context.getBean("busine",BusinessInter.class);
		inter.selectProcess();;
	}

}
