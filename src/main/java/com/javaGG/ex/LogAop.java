package com.javaGG.ex;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LogAop {
	
	public Object loggerAop(ProceedingJoinPoint jointpoint) throws Throwable { 
		// around 대상 객체의 메소드가 실행 전,후 또는 익셉션 발생시점에서 공통기능 실행
		
		String signatureStr = jointpoint.getSignature().toShortString();
		System.out.println(signatureStr + "메서드가 시작 되었습니다!");
		long st = System.currentTimeMillis();
				
		try {
			Object obj = jointpoint.proceed();
			return obj;
		} finally {
			long et = System.currentTimeMillis();
			System.out.println(signatureStr + "메서드가 종료 되었습니다!");
			System.out.println(signatureStr + "경과시간 : " + (et-st));
		}
		
	}
	
	public void beforeAdvice(JoinPoint joinPoint) { //before 대상 객체의 메소드 호출 전에 공통기능 실행
		System.out.println("before Advice가 실행됨");
	}
	
	public void afterReturningAdvice() { //after-Returning 대상 객체의 메소드가 에러 없이 실행되면 공통기능 실행
		System.out.println("afterReturning Advice가 실행됨");
	}
	
	public void afterThrowingAdvice() { //after-throwing 대상 객체의 메소드가 실행 중 에러 발생시 공통기능 실행
		System.out.println("afterThrowing Advice가 실행됨");
	}
	
	public void afterAdvice() { //after 대상 객체의 메소드가 실행된 이후에 공통기능 실행
		System.out.println("after Advice가 실행됨");
	}
	
}