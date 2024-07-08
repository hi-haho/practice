package pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class LogicImpl implements LogicInter {
	@Autowired //매개변수가 있는 생성자 필요가 없다.(필드주입)
	private ArticleInter articlerInter;
	
	public LogicImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void selectDataProcess1() {
		System.out.println("selectDataProcess1 수행");
		articlerInter.selectAll(); //모델 클래스 수행 결과
	}

	@Override
	public void selectDataProcess2() {
		System.out.println("== == == == == ==");
	
		System.out.println("selectDataProcess2 처리!👻시작!");
		articlerInter.selectAll(); //모델 클래스 수행 결과
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("처리하는데 3초나 걸려!");
		System.out.println("처리 끝@@!");
	}

}
