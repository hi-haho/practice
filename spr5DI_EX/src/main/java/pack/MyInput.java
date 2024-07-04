package pack;
import java.util.Scanner;


public class MyInput{
	private SangpumImpl impl;
	private String[] res;
	public void setImpl(SangpumImpl impl) {
		this.impl = impl;
	}
	
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
			res = impl.calcMoney(sang,su,dan); //생성자를 통해 가져온 주소에따라 사용할 수 있다.
			
		} catch (Exception e) {
			System.out.println("inputData err : " + e.getMessage());
		}

	}

	public void showData() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("상품명 : " + res[0]);
		sb.append("\n가격 : " + res[1]);
		System.out.println(sb.toString());
	}

}
