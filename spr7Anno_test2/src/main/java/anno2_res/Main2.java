package anno2_res;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main2 {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("anno2.xml");
		AbcProcess process = context.getBean("abcProcess",AbcProcess.class);
		process.showData();
	}

}
