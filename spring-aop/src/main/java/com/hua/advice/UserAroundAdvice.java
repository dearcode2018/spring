/**
 * 描述: 
 * UserAroundAdvice.java
 * @author	qye.zheng
 *  version 1.0
 */
package com.hua.advice;

//import java.lang.reflect.Method;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
//import org.springframework.cglib.proxy.MethodProxy;
//import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.beans.factory.InitializingBean;

/**
 * 描述: 
 * @author  qye.zheng
 * UserAroundAdvice
 */
/*
 * 在Spring中，aop拦截器，一般声明为这样: implements MethodInterceptor,InitializingBean,Advice
 * 核心是 org.aopalliance.intercept.MethodInterceptor
 */

// 这里选择实现import org.aopalliance.intercept.MethodInterceptor;
public final class UserAroundAdvice implements MethodInterceptor
{

	/**
	 * 描述: 
	 * @author qye.zheng
	 * @param target
	 * @param method
	 * @param args
	 * @param methodProxy
	 * @return
	 * @throws Throwable
	 */
/*	@Override
	public final Object intercept(final Object target, final Method method, final 
			Object[] args, final MethodProxy methodProxy) throws Throwable
	{
		System.out.println("UserAroundAdvice.intercept() 调用切点方法 前");
		
		// 调用切点方法
		Object returnObject = methodProxy.invoke(target, args);
		
		System.out.println("UserAroundAdvice.intercept() 调用切点方法 前后");
		
		// 使用切点方法的返回值
		return returnObject;
	}*/

	 /**
	 * 描述: 
	 * @author qye.zheng
	 * @param invocation
	 * @return
	 * @throws Throwable
	 */
	@Override
	public final Object invoke(final MethodInvocation invocation) throws Throwable
	{
		System.out.println("UserAroundAdvice.invoke() 调用切点方法 前");
		
		//  目标对象:
		
		// 目标对象: 这里是 com.hua.service.impl.UserBusinessImpl
		Object _this = invocation.getThis();
		
		// 方法参数
		Object[] args = invocation.getArguments();
		
		// 调用切点方法，只能调用，不能传参数
		Object returning = invocation.proceed();
		
		
		System.out.println("UserAroundAdvice.invoke() 调用切点方法 前后");
		
		// 使用切点方法的返回值
		return returning;
	}

}
