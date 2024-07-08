package pack;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("busine")
public class BusinessImpl implements BusinessInter {
	//모델 클래스를 사용
	@Autowired //필드(타입에 의한 매핑)di
	//@Qualifier("sangpumInter") //여러개 있다면 구체적으로 알려줘야한다.
	private SangpumInter inter;

	@Override
	public void selectProcess() {
		ArrayList<SangpumDto> mylist = inter.selectAll();
		for(SangpumDto s :mylist) {
			System.out.println(s.getCode() + " "+s.getSang()+ " "+s.getSu()+ " "+s.getDan());
		}
	}
}
