package pack;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect //관심사항
@Component
public class OurAdvice { //Aspect클래스 : Advice(삽입되어 동작할 수 있는 코드)용
	@Around("execution(* *..*LogicInger*.*(..)) or execution(public void selectAll())") //핵심 메서드 앞뒤에
	public Object haha(ProceedingJoinPoint joinPoint) throws Throwable{
		// 수행 시간 체크
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		//Aspect가 길면 클래스를 만들어 포함관계로 불러주면 된다.
		System.out.println("핵심 메서드 수행 전 관심사항(Aspect) 실행. login,logging..");
		
		Object object = joinPoint.proceed(); // 선택된 핵심 메소드 수행 (proxy에 실제 메서드가 수행)
		System.out.println("핵심 메서드 수행 후 실행");
		
		stopWatch.stop(); //모니터링의 일종
		System.out.println("처리 시간 : " + stopWatch.getTotalTimeSeconds());
		
		return object;
	};
}
