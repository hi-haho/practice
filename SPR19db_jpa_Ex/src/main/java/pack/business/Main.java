package pack.business;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// @Configuration //xml안쓰는 것도 가능
public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("init.xml");
		BusinessInterface inter = context.getBean("businessImpl", BusinessInterface.class);
		inter.dataPrint(); //전체 직원
		inter.buserTot(); //부서별 직원 수
	}

}
