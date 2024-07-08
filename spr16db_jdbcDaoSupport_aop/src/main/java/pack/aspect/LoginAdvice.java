package pack.aspect;

import java.util.Scanner;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoginAdvice {  //관심사항
	@Around("execution(public void jikwonList())") //jikwonList()가 pointcut 대상
	public Object haha(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.print("로그인 아이디 입력 : ");
		Scanner scanner = new Scanner(System.in);
		String id = scanner.nextLine();
		
		if(!id.equalsIgnoreCase("kor")) {
			System.out.println("아이디 불일치 _ 로그인 실패");
			return null; // 핵심로직 접근 불가
		}
		
		Object object = joinPoint.proceed();
		
		scanner.close();
		return object;
	};
}
