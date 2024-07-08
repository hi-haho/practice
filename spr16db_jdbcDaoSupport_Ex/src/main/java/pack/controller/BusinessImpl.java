package pack.controller;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pack.model.JikwonImpl;
import pack.model.JikwonInter;
@Service
public class BusinessImpl implements BusinessInter {
	@Autowired
	private JikwonInter inter;
	
	@Override
	public void jikwonlist() {
		System.out.print("고객번호 : ");
		Scanner scanner = new Scanner(System.in);
		String gogek_num = scanner.nextLine();
		//scanner.nextLine();
		
		System.out.print("고객이름 : ");
		Scanner scanner2 = new Scanner(System.in);
		String gogek_name = scanner.nextLine();
		
		inter.selectOen(gogek_num,gogek_name).forEach(s->
		System.out.println(s.getJikwon_name()+" "+s.getJikwon_jik()+" "+ s.getJikwon_gen()));
	}

}
