/**
 * 描述: 
 * UserAfterThrowingAdvice.java
 * @author	qye.zheng
 *  version 1.0
 */
package com.hua.advice;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;


/**
 * 描述: 
 * @author  qye.zheng
 * UserAfterThrowingAdvice
 */
public final class UserAfterThrowingAdvice implements ThrowsAdvice
{

	/**
	 异常通知，接口不包含任何方法，通知方法需要自定义
	 注意: 方法名必须是afterThrowing，否则会抛异常
	 方法名固化
	 */
	
	/**
	 * 
	 * 描述: 抛出异常后
	 * @author qye.zheng
	 * @param method
	 * @param args
	 * @param target
	 * @param throwable
	 */
	public void afterThrowing(final Method method, final Object[] args, 
			final Object target, final Throwable throwable)
	{
		System.out.println("method: " + target.getClass().getName() 
				+ "." + method.getName() + " throw exception ");
		// 输出异常信息
		throwable.printStackTrace();
	}
}
