/**
 * 描述: 
 * UserReturningAdvice.java
 * @author	qye.zheng
 *  version 1.0
 */
package com.hua.advice;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

/**
 * 描述: AfterReturning 通知 就是 After通知，在bean实现上没有和注解中对应的方案，
 * AfterReturning方案已经可以满足要求了，更加灵活的控制可以实现Around的方式
 * @author  qye.zheng
 * UserReturningAdvice
 */
public final class UserReturningAdvice implements AfterReturningAdvice
{

	/**
	 * 描述: 成功返回后执行
	 * @author qye.zheng
	 * @param returning
	 * @param method
	 * @param args
	 * @param target
	 * @throws Throwable
	 */
	@Override
	public final void afterReturning(final Object returning, final Method method,
			final Object[] args, final Object target) throws Throwable
	{
		System.out.println("return: " + returning.toString());
	}

}
