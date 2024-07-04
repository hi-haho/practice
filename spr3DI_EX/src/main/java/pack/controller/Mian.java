package pack.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mian {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("init.xml"); //인스턴스
		MyInter inter = (MyInter)context.getBean("myImpl");
		//getbean으로 객체를 불러오는거야.
		//MyInter로 인터페이스를 사용하는 것도 다양하게 사용하기 위해서야. 그래서 부모로 강제타입변환을 하는거지.
		inter.inputData();
		inter.showData();
	}
}
