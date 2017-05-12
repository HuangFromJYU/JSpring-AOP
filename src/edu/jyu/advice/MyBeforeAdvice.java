package edu.jyu.advice;

import java.lang.reflect.Method;

import edu.jyu.aop.MethodBeforeAdvice;

/**
 * 自定义前置通知类
 * 
 * @author Jason
 */
public class MyBeforeAdvice extends MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) {
		System.out.println("前置通知");
	}

}