package pack.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pack.model.SangpumDto;
import pack.model.SangpumInter;

@Service
public class BusinessImpl implements BusinessInter {
	//모델 클래스를 호출(포함)
	@Autowired
	private SangpumInter inter ;

	@Override
	public void dataPrint() {
		List<SangpumDto> list = inter.selectDataAll();
		
		//console 출력
		/*
		for(SangpumDto s : list) {
			System.out.println(s.getCode() + " " + s.getSang()+ " " + s.getSu()+ " " + s.getDan());
		}
		*/
		list.forEach(s->System.out.println(s.getCode() + " " + s.getSang()+ " " + s.getSu()+ " " + s.getDan()));
	}

}
