package pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
@Configuration //환경을 여기서 설정하겠다는 의미 (xml이 필요없다. 6 버전)
@ComponentScan(basePackages ="pack") //해당 pack를 스캔한다.(인스턴스가 되는 시점)
//스캐너는 한개만 존재하지 않는다. 
public class Main1 {
	public static void main(String[] args) {
		// @Autowired에 대한 메인
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main1.class);
		//xml 대신에 class를 가지고 환경을 잡겠다는 의미.
		//당연히 어노테이션을 안쓰겠다면 xml을 사용해야한다.
		//ApplicationContext context = new ClassPathXmlApplicationContext("anno1.xml");
		SenderProcess process = context.getBean("senderProcess",SenderProcess.class);
		process.dispData();
	}

}
