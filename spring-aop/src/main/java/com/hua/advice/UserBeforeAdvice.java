/**
 * 描述: 
 * UserBeforeAdvice.java
 * @author	qye.zheng
 *  version 1.0
 */
package com.hua.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/**
 * 描述: 用户业务 - 前置通知
 * @author  qye.zheng
 * UserBeforeAdvice
 */
public final class UserBeforeAdvice implements MethodBeforeAdvice
{

	/**
	 * 描述: 
	 * @author qye.zheng
	 * @param method
	 * @param args
	 * @param target
	 * @throws Throwable
	 */
	@Override
	public final void before(final Method method, final Object[] args, final Object target)
			throws Throwable
	{
		//  代理对象: this， 目标对象: target，代理的的方法: method 代理方法参数: args
		System.out.println("begining method: " + target.getClass().getName()
				+ "." + method.getName());
	}

}
