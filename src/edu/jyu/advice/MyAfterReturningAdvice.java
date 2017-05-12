package edu.jyu.advice;

import java.lang.reflect.Method;

import edu.jyu.aop.AfterReturningAdvice;

public class MyAfterReturningAdvice extends AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("后置通知---方法返回值-->" + returnValue);
	}

}
