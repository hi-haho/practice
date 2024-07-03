package pack.model;

public class SangpumImpl implements SangpumInter {

	@Override
	public String[] calcMoney(String sang,int su, int dan) {
		//계산!
		String[] arr = new String[2];
		arr[0] = sang;
		arr[1] = Integer.toString(su*dan);
		return arr;
	}

}
