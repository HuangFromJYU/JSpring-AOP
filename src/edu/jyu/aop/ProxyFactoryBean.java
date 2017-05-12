package edu.jyu.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 用于生产代理对象的类
 * 
 * @author Jason
 */
public class ProxyFactoryBean {
	// 目标对象
	private Object target;
	// 通知
	private Object interceptor;
	// 代理实现的接口
	private String proxyInterface;

	// 提供setter让容器注入属性

	public void setTarget(Object target) {
		this.target = target;
	}

	public void setInterceptor(Object interceptor) {
		this.interceptor = interceptor;
	}

	public void setProxyInterface(String proxyInterface) {
		this.proxyInterface = proxyInterface;
	}

	/**
	 * 创建代理对象
	 * 
	 * @return
	 */
	public Object createProxy() {
		// 判断有没有指定proxyInterface，没有指定就用CGLib方式
		if (proxyInterface == null || proxyInterface.trim().length() == 0)
			return createCGLibProxy();
		// 使用JDK中的代理
		return createJDKProxy();
	}

	/**
	 * JDK方式创建代理对象
	 * 
	 * @return
	 */
	private Object createJDKProxy() {
		Class<?> clazz = null;
		try {
			clazz = Class.forName(proxyInterface);// 实现的接口
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(proxyInterface + "找不到，请注意填写正确");
		}
		// JDK方式生成的代理对象
		Object proxyInstance = Proxy.newProxyInstance(clazz.getClassLoader(), new Class[] { clazz },
				new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						Object result = null;

						// 要先判断interceptor是哪种通知类型，以决定执行目标方法的位置
						// 判断interceptor是否为前置通知类型
						if (interceptor instanceof MethodBeforeAdvice) {
							MethodBeforeAdvice advice = (MethodBeforeAdvice) interceptor;
							// 在目标方法执行前执行前置通知代码
							advice.before(method, args, target);
							// 执行目标方法
							result = method.invoke(target, args);
						}
						return result;
					}
				});
		return proxyInstance;
	}

	/**
	 * CGLib方式创建代理对象
	 * 
	 * @return
	 */
	private Object createCGLibProxy() {
		return null;
	}

}
