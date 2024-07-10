package pack.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pack.model.JikwonDto;
import pack.model.JikwonInter;

@Service
public class BusinessImpl implements BusinessInter {
	//모델 클래스를 호출(포함)
	@Autowired
	private JikwonInter inter ;
	
	@Override
	public void dataAllPrint() { //모든 직원 자료 뿌리기
		System.out.println("직원 자료");
		List<JikwonDto> list = inter.selectAll();
		for (JikwonDto j : list) {
			if(j.getBuser_name() == null) {
				j.setBuser_name("무소속");
			}
		}
		//System.out.print("!!!!  "+list.get);
		System.out.println("사번\t이름\t부서명\t입사년");
		list.forEach(j->System.out.println(j.getJikwon_no()+" "+j.getJikwon_name()+" "+j.getBuser_name()+" "+j.getJikwon_ibsail().substring(0, 4)));
	}
	
	@Override
	public void groupBuserPrint() {
		System.out.println("\n부서별 인원수");
		List<Object[]> list = inter.groupBuser();
		list.forEach(bu->System.out.println(bu[0] + " - " + bu[1]));
	}
	
	@Override
	public void topBuserPayPrint() {
		System.out.println("\n부서별 최대 급여자");
		List<Object[]> list = inter.topBuserPay();
		list.forEach(p->System.out.println(p[0] + " : " + p[1] + " ( "+p[2]+" )"));
	}

}
