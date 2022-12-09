package com.example.demo.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Aspect
public class Parameter {
	
	// 
	@Pointcut(value = "execution(* com.example.demo.controller..*.*(..))")
	public void myPointCut() {
		
	}
	
	@Before("myPointCut()")
	public void myBefore(JoinPoint joinpoint) {
		MethodSignature methodSignature = (MethodSignature) joinpoint.getSignature();
		System.out.println("리턴타입 : " + methodSignature);
		
		Method method = methodSignature.getMethod();
		log.info("method - {}", method);
		
		Object[] args = joinpoint.getArgs();
		for (Object object : args) {
			System.out.println("type : " + object.getClass().getSimpleName());
			System.out.println("valye : " + object);
		}
	}
	
	@AfterReturning(value = "myPointCut()", returning = "returnObj")
	public void myAfterReturn(JoinPoint joinpoint, Object returnObj) {
		System.out.println("▼ return value ▼");
		System.out.println(returnObj);
	}
	
}










