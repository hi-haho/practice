package pack;

public class MessageImpl implements MessageInter {
	//핵심 로직 클래스 : Target
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public void sayHi() {
		System.out.println("반가워 :-) " + name +"! 비즈니스 로직 처리했어!");
		//현재 메서드 처리 시간이 길다고 가정, 인위적 지연시간을 부여
		int t = 0;
		while(t<5) {
			try {
				Thread.sleep(1000);
				System.out.print(t+"초 ");
				t++;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		System.out.println("~.~sayHi 처리 완료했어!");
	}

}
