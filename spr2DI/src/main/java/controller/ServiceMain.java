package controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.DataDao;
import model.DataDaoImpl;

public class ServiceMain {

	public static void main(String[] args) {
		//전통적인 방법
		// DB 처리 객체를 생성
		DataDaoImpl impl = new DataDaoImpl();
		DataDao dataDao = impl; //자식의 주소를 부모가 가질 수 있다. (부모 객체에 치환)
		
		//BL 관련 객체 생성
		ProcessServiceImpl serviceImpl = new ProcessServiceImpl(dataDao); //DataDaoImpl의 주소를 넣어준다
		ProcessService processService = serviceImpl; //processService(인터페이스)
		processService.selectProcess();
		
		System.out.println("------------");
		
		//Spring 방법 사용
		//ApplicationContext xml을 사용할 수 있는 객체이다. 웹에서는 묵시적 처리
		ApplicationContext context = new ClassPathXmlApplicationContext("init.xml");
		ProcessService processService2 = (ProcessService)context.getBean("serviceImpl");
		processService2.selectProcess();
	}

}
