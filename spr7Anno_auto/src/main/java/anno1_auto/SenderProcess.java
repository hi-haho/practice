package anno1_auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 //@Component로 만들어도 되지만 단순히 객체를 만드는 것인 경우만 사용
@Service //service 제공하는 경우 사용하면 가독성이 높아진다. 도메인 레이어이다.
//Domain layer : 어플리케이션 중심이며 업무처리를 담당 @Service .. 
//즉, service 어노테이션은 domain layer의 일종이다.
public class SenderProcess { //싱글톤(scope 기본값)으로 객체변수는 자동으로 senderProcess로 생성된다.
	//@Autowired : Bean의 자동 삽입을 위해 사용하는 어노테이션. (*type 으로 매핑)
	@Autowired //필드 주입 (코드가 간결하지만 외부에 변경이 힘들다)
	private Sender sender; // 부모의 인터페이스가 있으면 인터페이스를 사용해야한다. Sender 타입에 인스턴스의 주소가 들어간다.
	
	/*
	@Autowired //수정자 주입 (코드가 장황해진다.setter 메서드를 public으로 열어두어야 하기 때문에 언제 어디서든 변경이 가능)
	public void setSender(Sender sender) {
		this.sender = sender;
	}
	
	@Autowired //생성자 주입 (Spring Framwork reference에서 추천하는 방법, 불변성과 테스트가 편하지만 너무 생성자가 많아진다. )
	public SenderProcess(Sender sender) {
		this.sender = sender;
	}
	*/
	public Sender getSender() {
		return sender;
	}
	public void dispData() {
		sender.show();
	}
}
