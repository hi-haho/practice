package pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessImpl implements BusinessInter {
	//DB 처리하는 model class를 포함관계로 호출
	@Autowired
	private SangpumInter sangpumInter;
	/*
	@Override
	public void selectProcess() {
		for(SangpumDto s:sangpumInter.selectAll()) {
			System.out.println(s.getCode() + " "+s.getSang()+ " "+s.getSu()+ " "+s.getDan());
		}
	}
	*/
	//람다 표현식 사용
	@Override
	public void selectProcess() {
		sangpumInter.selectAll().forEach(s ->
		System.out.println(s.getCode() + " "+s.getSang()+ " "+s.getSu()+ " "+s.getDan()));
	}
	
}
