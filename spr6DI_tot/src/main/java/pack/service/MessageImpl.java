package pack.service;

import pack.model.MyInfoInter;
import pack.other.OutFileInter;

public class MessageImpl implements MessageInter {
	//MessageInter 타입의 파생 클래스 중 하나로 MessageImpl 작성
	private String message1, message2 =""; //constructor Injection
	private int year;
	private MyInfoInter infoInter; //자식 클래스를 사용할 수 있다.
	
	private String spec; //setter injection용
	private OutFileInter fileInter;
	
	public MessageImpl(String message1,String message2,int year,MyInfoInter infoInter) {
		this.message1 = message1;
		this.message2 = message2;
		this.year = year;
		this.infoInter = infoInter;
	}
	
	// ------setter injection-------
	public void setSpec(String spec) {
		this.spec = spec;
	}
	
	public void setFileInter(OutFileInter fileInter) {
		this.fileInter = fileInter;
	}
	
	@Override
	public void sayHi() {
		String msg = "MessageImpl class, sayHi call: ";
		msg += "\n" + message1 +"  " + message2 +"  "
				+ (year+2000)+"년" + infoInter.myData()
				+"\n" + spec;
		
		System.out.println(msg); //console 출력
		
		//위 메시지를 파일로 출력하기
		fileInter.outFile(msg);
	}

}
