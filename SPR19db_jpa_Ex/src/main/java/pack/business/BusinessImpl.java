package pack.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pack.model.DataInterface;
import pack.model.JikwonDto;

@Service
public class BusinessImpl implements BusinessInterface {

	@Autowired
	private DataInterface dataInterface;
	@Override
	public void dataPrint() {
		List<JikwonDto> mlist = dataInterface.selectDataAll();
		System.out.println("=== 전체 직원 ===");
		mlist.forEach(m -> System.out.println(m.getJikwon_no()+" "+m.getJikwon_name()+" "+m.getBuser_num()+" "+m.getJikwon_ibsail()));
	}
	
	@Override
	public void buserTot() {
		List<Object[]> list = dataInterface.buserCount();
		System.out.println("=== 부서별 : 인원수 ===");
		list.forEach(l -> System.out.println(l[0]+"\t:\t"+l[1]));
		//캐스팅을 원하면 String / Long으로 
	}

}
