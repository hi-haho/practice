package controller;

import model.DataDao;

public class ProcessServiceImpl implements ProcessService{
	private DataDao dataDao; //클래스의 포함관계 (상속X)
	
//	public ProcessServiceImpl(){ //기본 생성자 쓰자
//		
//	}
	
	public ProcessServiceImpl(DataDao dataDao){
		this.dataDao = dataDao;
	}
	
	
	@Override
	public void selectProcess() {
		System.out.println("selectProcess 처리 시작");
		dataDao.selectData(); // model 영역의 클래스가 수행되고 있다.
		System.out.println("selectProcess 처리 끝");
	}
}
