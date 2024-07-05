package pack.gogek;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import pack.bank.Bank;
import pack.bank.HahaBank;
import pack.bank.HohoBank;

@Service
@ComponentScan("pack.bank")
@Scope("prototype")
public class Gogek {
	private Bank bank;
	
	//@Autowired(required = false) //type으로 연결 : hahaBank가 인스턴스가 없으면 안사용하고 있으면 사용
	@Autowired(required = true)
	private HahaBank hahaBank;
	
	@Resource(name = "hohoBank") //이름으로 매핑
	private HohoBank hohoBank;
	
	public void selectBank(String sel) {
		if(sel.equals("haha")) {
			bank = hahaBank;
		}else if(sel.equals("hoho")) {
			bank = hohoBank;
		}
	}
	public void playInputMoney(int money) {
		bank.inputMoney(money); // haha 일 수도 있고 hoho일 수 있음
	}
	public void playOuputMoney(int money) {
		bank.outputMoney(money);
	}
	private String msg;
	@PostConstruct //생성자 처리 후 자동 호출 : 초기화 작업 가능
	public void abc() {
		msg ="계좌 잔고(@PostConstruct > abc()) : ";
	}
	
	@PreDestroy //웹 서비스 종료직전 자동 호출 : 마무리 작업 가능
	public void def() {
		if(hahaBank != null) {
			hahaBank = null;
		}
		if(hohoBank != null) {
			hohoBank = null;
		}
	}
	
	public void showMoney() {
		//System.out.println("계좌 잔고 : " + bank.getMoney());
		System.out.println( msg + bank.getMoney());
	}
}
