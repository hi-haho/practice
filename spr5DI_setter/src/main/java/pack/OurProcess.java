package pack;

public class OurProcess {
	private String name;
	private int su;
	private Gugudan gugudan;
	
	public void setName(String name) {
		this.name = name;
	}
	public void setSu(int su) {
		this.su = su;
	}
	public void setGugudan(Gugudan gugudan) {
		this.gugudan = gugudan;
	}
	
	@Override
	public String toString() { //원래는 객체의 주소를 찍는다
		int[] result = gugudan.numberCalc(su);
		String str = "";
		for (int i = 0; i < result.length; i++) {
			str += su + "*" + (i+1) + " = "+ result[i] + "\n";
		}
		return "작성자 : " + name + "\n" + su + "단 결과 : \n" + str;
	}
}
