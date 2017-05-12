package edu.jyu.aop;

import java.lang.reflect.Method;

/**
 * 前置通知接口
 * 
 * @author Jason
 */
public interface MethodBeforeAdvice {

	/**
	 * 
	 * @param method
	 *            目标方法
	 * @param args
	 *            目标方法所需的参数
	 * @param target
	 *            目标对象
	 */
	void before(Method method, Object[] args, Object target);

}
