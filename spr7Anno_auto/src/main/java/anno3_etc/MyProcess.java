package anno3_etc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("my")
public class MyProcess {
	/*
	 * SpEL 표현식은 # 기호로 시작하며 중괄호로 묶어서 표현한다.
	 * #{표현식}  속성 값을 참조할 때는 $ 기호와 중괄호로 묶어서 표현한다. ${property.name}
	 * */
	//@Value 변수에 값을 초기화하기 위해 사용할 수도 있다.
	@Value("#{dataInfo.name}") //값을 직접 주입. Spring EL : #{표현식}, 만들어진 Component 객체를 이용, private는 getter를 이용해서 가져옴
	private String name;
	private String part;
	
	@Autowired
	//public MyProcess(@Value("호이호이부서") String part) {
	public MyProcess(@Value("#{dataInfo.part}") String part) {
		this.part = part;
	}
	
	@Value("123") //"" 안붙이면 Type mismatch: cannot convert from int to String 떨어진다. 기본이 String
	private int age;
	
	@Value("1,2,3,4")
	private int arr[];
	public void showData() {
		System.out.println("name : " + name);
		System.out.println("part : " + part);
		System.out.println("age : " + age);
		System.out.println("arr[0] : " + arr[0]+" arr[1] : " + arr[1]+" arr[2] : " + arr[2]+"arr[3] : " + arr[3]);
	}
}
