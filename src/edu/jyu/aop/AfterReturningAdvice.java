package edu.jyu.aop;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 后置通知接口
 * 
 * @author Jason
 */
public abstract class AfterReturningAdvice implements MethodInterceptor {

	/**
	 * 在目标方法执行后执行
	 * 
	 * @param returnValue
	 *            目标方法返回值
	 * @param method
	 *            目标方法
	 * @param args
	 *            目标方法所需参数
	 * @param target
	 *            目标对象
	 * @throws Throwable
	 */
	public abstract void afterReturning(Object returnValue, Method method, Object[] args, Object target)
			throws Throwable;

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		// 目标方法执行
		Object result = proxy == null ? method.invoke(obj, args) : proxy.invokeSuper(obj, args);
		// 后置通知方法，在目标方法后执行
		afterReturning(result, method, args, obj);
		return result;
	}

}