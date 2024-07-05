package pack.gogek;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GogekMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("bankInit.xml");
		
		Gogek daniel = context.getBean("gogek",Gogek.class);
		daniel.selectBank("haha");
		daniel.playInputMoney(500);
		daniel.playOuputMoney(2500); //3000
		System.out.print("다니엘의 잔고 : " );
		daniel.showMoney();
		
		Gogek john = context.getBean("gogek",Gogek.class);
		john.selectBank("haha");
		john.playInputMoney(500);
		john.playOuputMoney(2500);
		System.out.print("존의 잔고 : " );
		john.showMoney();
		
		Gogek oscar = context.getBean("gogek",Gogek.class);
		oscar.selectBank("hoho");
		oscar.playInputMoney(500);
		oscar.playOuputMoney(200);
		System.out.print("오스카의 잔고 : " );
		oscar.showMoney();
		
		System.out.println("객체의 주소 " + daniel + " ? " + john + " ? " + oscar);
		//pack.gogek.Gogek@446a1e84 ? pack.gogek.Gogek@446a1e84 ? pack.gogek.Gogek@446a1e84
		//3개의 객체 주소가 같다. 즉, 싱글톤으로 되어있다.
		//하지만 이런 프로그램은 싱글톤이 되면 안된다.
	}

}
