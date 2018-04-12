/**
  * @filename MyInvocationSecurityMetadataSource.java
  * @description  
  * @version 1.0
  * @author qye.zheng
 */
package com.hua.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

 /**
 * @type MyInvocationSecurityMetadataSource
 * @description 安全权限数据源
 * 该类初始化时，应获取到所有资源及其对应的角色定义
 * @author qye.zheng
 */
public final class MyInvocationSecurityMetadataSource implements
		FilterInvocationSecurityMetadataSource
{
	// 在 security-web-core 3.2.5 已经不存在
	//private UrlMatcher urlMatcher = new AntUrlPathMatcher();
	
	/* 资源 -> 配置属性集合 Map */
	private static final Map<String, Collection<ConfigAttribute>> resourceMap = 
			new HashMap<String, Collection<ConfigAttribute>>();  
	
	/**
	 * @description 构造方法
	 * @author qye.zheng
	 */
	public MyInvocationSecurityMetadataSource() {
		loadResourceDefine();
	}
	
	/**
	 * @description 获取 指定资源的权限
	 * @param object
	 * @return
	 * @throws IllegalArgumentException
	 * @author qye.zheng
	 */
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException
	{
		System.out
				.println("MyInvocationSecurityMetadataSource.getAttributes()");
		FilterInvocation invocation = (FilterInvocation) object;
		HttpServletRequest request = invocation.getHttpRequest();
		Iterator<String> it = resourceMap.keySet().iterator();
		RequestMatcher matcher = new RegexRequestMatcher("/api/admin/\\w*", "POST");
		String resourceUrl = null;
		System.out.println("request method = " + request.getMethod());
		System.out.println("request uri = " + request.getRequestURI());
		while (it.hasNext())
		{ 
			resourceUrl = it.next();
			System.out.println("resourceUrl = " + resourceUrl);
			if (matcher.matches(request))
			{
				System.out.println("request match ...");
				return resourceMap.get(resourceUrl);
			}
		}
		
		System.out.println("request not match ...");
		return null;
	}

	/**
	 * @description 
	 * @return
	 * @author qye.zheng
	 */
	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes()
	{
		return null;
	}

	/**
	 * @description 
	 * @param clazz
	 * @return
	 * @author qye.zheng
	 */
	@Override
	public boolean supports(Class<?> clazz)
	{
		return true;
	}
	
	/**
	 * 
	 * @description 加载资源定义
	 * @author qye.zheng
	 */
	private final void loadResourceDefine()
	{
		Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();
		ConfigAttribute configAttribute = new SecurityConfig("ROLE_ADMIN");
		configAttributes.add(configAttribute);
		System.out.println("MyInvocationSecurityMetadataSource.loadResourceDefine()");
		resourceMap.put("/api/admin/login", configAttributes);
		//resourceMap.put("/api/admin/search", configAttributes);
	}

}
