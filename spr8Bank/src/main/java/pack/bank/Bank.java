package pack.bank;

public interface Bank {
	void inputMoney(int money);
	void outputMoney(int money);//출금
	int getMoney();//잔고 확인
}
