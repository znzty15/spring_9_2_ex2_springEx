package com.javaGG.ex;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LogAop {
	
	public Object loggerAop(ProceedingJoinPoint jointpoint) throws Throwable { 
		// around ��� ��ü�� �޼ҵ尡 ���� ��,�� �Ǵ� �ͼ��� �߻��������� ������ ����
		
		String signatureStr = jointpoint.getSignature().toShortString();
		System.out.println(signatureStr + "�޼��尡 ���� �Ǿ����ϴ�!");
		long st = System.currentTimeMillis();
				
		try {
			Object obj = jointpoint.proceed();
			return obj;
		} finally {
			long et = System.currentTimeMillis();
			System.out.println(signatureStr + "�޼��尡 ���� �Ǿ����ϴ�!");
			System.out.println(signatureStr + "����ð� : " + (et-st));
		}
		
	}
	
	public void beforeAdvice(JoinPoint joinPoint) { //before ��� ��ü�� �޼ҵ� ȣ�� ���� ������ ����
		System.out.println("before Advice�� �����");
	}
	
	public void afterReturningAdvice() { //after-Returning ��� ��ü�� �޼ҵ尡 ���� ���� ����Ǹ� ������ ����
		System.out.println("afterReturning Advice�� �����");
	}
	
	public void afterThrowingAdvice() { //after-throwing ��� ��ü�� �޼ҵ尡 ���� �� ���� �߻��� ������ ����
		System.out.println("afterThrowing Advice�� �����");
	}
	
	public void afterAdvice() { //after ��� ��ü�� �޼ҵ尡 ����� ���Ŀ� ������ ����
		System.out.println("after Advice�� �����");
	}
	
}