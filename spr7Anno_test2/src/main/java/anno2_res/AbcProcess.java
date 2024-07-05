package anno2_res;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class AbcProcess {
	@Resource(name="aaa") //type에 의한 매핑이 아니라 객체변수 이름으로 매핑. (필드)
	private ABCD1 abcd1;
	private Abc2 abc2;
	
	@Resource(name="abc2") //type에 의한 매핑이 아니라 객체변수 이름으로 매핑. (생성자)
	public void setAbcd2(Abc2 abcd2) {
		this.abc2 = abcd2;
	}
	 void showData(){
		abcd1.setIrum("금요일");
		abc2.setNai(23);
		
		String str = "결과 : 이름은 " + abcd1.getIrum();
		str += "나이는" + abc2.getNai();
		System.out.println(str);
	}
	
}
