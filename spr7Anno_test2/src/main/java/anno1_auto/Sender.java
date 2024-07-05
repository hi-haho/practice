package anno1_auto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component //singleton pattern으로 Sender객체 생성 : 객체 변수명 sender로 자동으로 만들어진다.
//@Component("sender") //자세히 정의하면 이와 같이 할 수 있다.
//@Component("send") //기본이름을 사용하고 싶지 않으면 명시적으로 작성해야한다.
//@Scope("singleton")
public class Sender implements SenderInter{ //포함관계르 사용할거아냐, Sender타입이 들어간다?!
	public void show() {
		System.out.println("\"Sender\" show method!");
	}
}
