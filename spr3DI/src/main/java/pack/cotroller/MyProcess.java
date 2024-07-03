package pack.cotroller;

import java.util.Scanner;

import pack.model.MoneyInter;

public class MyProcess implements Myinter {
	private MoneyInter inter; //moeryCalc를 쓰면 다형성이 아니다
	private int re[];
	
	public MyProcess( MoneyInter inter) {
		this.inter = inter;
	}
	@Override
	public void inputMoney() {
		//금액 입력 후 MoneyInter 타입의 클래스를 이용해 금액 단위별 갯수 계산한 결과 얻기
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.print("금액입력 : ");
			int mymoney = scanner.nextInt();
			re = inter.calcMoney(mymoney);
		} catch (Exception e) {
			System.out.println("inputMoney err : " + e.getMessage());
		}
	}

	@Override
	public void showResult() {
		StringBuffer sb = new StringBuffer(); //String 더하기를하면 부하 > 버퍼와 빌더
		sb.append("10000원 : " + re[0] + "\n"); 
		sb.append("1000원 : " + re[1] + "\n"); 
		sb.append("100원 : " + re[2] + "\n"); 
		sb.append("10원 : " + re[3] + "\n"); 
		sb.append("1원 : " + re[4] + "\n");
		System.out.println(sb.toString());
	}

}
