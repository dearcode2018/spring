/**
  * @filename MyAccessDecisionManager.java
  * @description  
  * @version 1.0
  * @author qye.zheng
 */
package com.hua.security;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

 /**
 * @type MyAccessDecisionManager
 * @description  访问决策管理器
 * @author qye.zheng
 */
public final class MyAccessDecisionManager implements AccessDecisionManager
{

	/**
	 * @description 决定
	 * @param authentication
	 * @param object
	 * @param configAttributes
	 * @throws AccessDeniedException
	 * @throws InsufficientAuthenticationException
	 * @author qye.zheng
	 */
	@Override
	public void decide(Authentication authentication, Object object,
			Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException
	{
		/*
		 * 配置属性为空(不存在对该资源的权限定义，直接放行)
		 * 若找到正确的角色，则认为拥有权限，否则抛出 拒绝访问异常
		 */
		if (null == configAttributes)
		{
			System.out.println("configAttributes is null");
			
			return;
		}
		
		System.out.println("url = " + object.toString());
		
		// 资源 所需配置属性 迭代器
		Iterator<ConfigAttribute> wantIt = configAttributes.iterator();
		SecurityConfig securityConfig = null;
		String needRole = null;
		String userRole = null;
		while (wantIt.hasNext())
		{
			securityConfig = (SecurityConfig) wantIt.next();
			needRole = securityConfig.getAttribute();
			for (GrantedAuthority auth : authentication.getAuthorities())
			{
				userRole = auth.getAuthority();
				if (needRole.equals(userRole))
				{
					return;
				}
			}
		}
		
		// 抛出 没有权限访问异常
		throw new AccessDeniedException(" no right ");
	}

	/**
	 * @description 知否支持
	 * @param attribute
	 * @return
	 * @author qye.zheng
	 */
	@Override
	public boolean supports(ConfigAttribute attribute)
	{
		return true;
	}

	/**
	 * @description 知否支持
	 * @param clazz
	 * @return
	 * @author qye.zheng
	 */
	@Override
	public boolean supports(Class<?> clazz)
	{
		return true;
	}

}
