package pack;

public class LogicImpl implements LogicInter {
	private ArticleInter articlerInter;
	
	public LogicImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public LogicImpl(ArticleInter articleInter) {
		this.articlerInter = articleInter;
	}
	
	
	@Override
	public void selectDataProcess1() {
		System.out.println("selectDataProcess1 수행");
		articlerInter.selectAll(); //모델 클래스 수행 결과
	}

	@Override
	public void selectDataProcess2() {
		System.out.println("== == == == == ==");
		System.out.println("selectDataProcess2 처리!👻시작!");
		articlerInter.selectAll(); //모델 클래스 수행 결과
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("처리하는데 3초나 걸려!");
		System.out.println("처리 끝@@!");
	}

}
