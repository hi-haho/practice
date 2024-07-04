package pack;

public class MyProcess { //setter injection
	private int nai;
	private String name;
	private ShowData showData; //참조형(포함관계)
	//강결합인 상속은 지양한다. 유지보수가 힘들다.
	
	public MyProcess() {
		//여기에서 showData를 받을 수도 있다. 이런경우 생성자 주입이 발생
	}
	
	public void setNai(int nai) {
		this.nai = nai;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setShowData(ShowData showData) {
		this.showData = showData;
	}
	
	public void displayData() {
		System.out.println("이름은 " + name + ", 나이는 " + nai + ", 별명은 " + showData.processNickname() + ", 취미는 " + showData.processHobby());
	}
}
