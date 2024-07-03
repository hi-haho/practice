package pack.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mian {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("init.xml"); //인스턴스
		MyInter inter = (MyInter)context.getBean("myImpl");
		inter.inputData();
		inter.showData();
	}
}
