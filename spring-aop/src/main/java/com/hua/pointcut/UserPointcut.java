/**
 * 描述: 
 * UserPointcut.java
 * @author	qye.zheng
 *  version 1.0
 */
package com.hua.pointcut;

import java.lang.reflect.Method;

import org.springframework.aop.support.NameMatchMethodPointcut;

/**
 * 描述: 
 * @author  qye.zheng
 * UserPointcut
 */
@SuppressWarnings("serial")
public final class UserPointcut extends NameMatchMethodPointcut
{

	 /**
	 * 描述: 
	 * @author qye.zheng
	 * @param method
	 * @param targetClass
	 * @return
	 */
	@Override
	public final boolean matches(final Method method, final Class<?> targetClass)
	{
		// 单个方法匹配
		String mappedName = "add";
		this.setMappedName(mappedName);
		
		// 也可以使用 * 进行多个匹配
		//this.setMappedName("get*");
		
		// 设置多个方法匹配
		String[] mappedNames = {"add", "delete"};
		this.setMappedNames(mappedNames);
		
		return super.matches(method, targetClass);
	}
}
