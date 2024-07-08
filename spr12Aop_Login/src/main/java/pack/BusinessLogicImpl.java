package pack;

import org.springframework.stereotype.Service;

@Service("bImpl") //bean이라는 거지
public class BusinessLogicImpl implements BusinessLogicInter {
	
	public BusinessLogicImpl() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void startProcess() {
		System.out.println("검증이 되었으므로 핵심 로직 수행");
	}

}
