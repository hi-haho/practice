package pack.controller;

import java.util.Scanner;

import pack.model.SangpumInter;

public class MyImpl implements MyInter { //extends를 하면 해당 타입만 사용할 수 있다. inter를 쓰면 다양한 것을 사용할 수 있다.
	private SangpumInter inter; //SangpumImpl 클래스를 주면 해당 타입만 사용할 수 있다. inter 타입의 어떤거든 사용할 수 있다.
	private String[] res;
	
	public MyImpl(SangpumInter inter) { //inter중 어떤 것을 사용할지는 생성자에서 선택할 수 있다.
		this.inter = inter; //생성자 DI야! Ioc(역전) 객체를 개발자가 직접하지 않는다.
	}
	@Override
	public void inputData() {
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.print("상품명 : ");
			String sang = scanner.nextLine();
			
			System.out.println();
			System.out.print("수량 : ");
			int su = scanner.nextInt();
			
			System.out.println();
			System.out.print("단가 : ");
			int dan = scanner.nextInt();
			res = inter.calcMoney(sang,su,dan); //생성자를 통해 가져온 주소에따라 사용할 수 있다.
			
		} catch (Exception e) {
			System.out.println("inputData err : " + e.getMessage());
		}

	}

	@Override
	public void showData() {
		StringBuilder sb = new StringBuilder();
		sb.append("상품명 : " + res[0]);
		sb.append("\n가격 : " + res[1]);
		System.out.println(sb.toString());
	}

}
