package com.example.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class TimerAOP {

	@Pointcut(value =  "execution(* com.example.demo.controller..*.*(..))")
	public void cut() {
	}
	
	@Pointcut(value = "@annotation(com.example.demo.anmo.Timer)")
	private void checkTimer() {}
	
	
	@Around("cut() && checkTimer()")
	public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		Object result = proceedingJoinPoint.proceed();
		// 메소드 실행 완료
		
		stopWatch.stop();
		System.out.println("total type : " + stopWatch.getTotalTimeSeconds());

	}
	
	
}
