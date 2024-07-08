package pack;

public class BusinessImpl implements BusinessInter {
	//DB 처리하는 model class를 포함관계로 호출
	private SangpumInter sangpumInter;
	
	public void setSangpumInter(SangpumInter sangpumInter) {
		this.sangpumInter = sangpumInter;
	}
	
	@Override
	public void selectProcess() {
		for(SangpumDto s:sangpumInter.selectAll()) {
			System.out.println(s.getCode() + " "+s.getSang()+ " "+s.getSu()+ " "+s.getDan());
		}
	}

}
