/**
  * @filename MySecurityInterceptor.java
  * @description  
  * @version 1.0
  * @author qye.zheng
 */
package com.hua.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

 /**
 * @type MySecurityInterceptor
 * @description  安全拦截器
 * @author qye.zheng
 */
public final class MySecurityInterceptor extends AbstractSecurityInterceptor
		implements Filter
{
	/* 过滤器调用安全元数据源 */
	private FilterInvocationSecurityMetadataSource securityMetadataSource;
	
	/**
	 * @description 
	 * @author qye.zheng
	 */
	@Override
	public void destroy()
	{
		System.out.println("MySecurityInterceptor.destroy()");
	}

	/**
	 * @description 
	 * @param request
	 * @param response
	 * @param chain
	 * @throws IOException
	 * @throws ServletException
	 * @author qye.zheng
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException
	{
		System.out.println("MySecurityInterceptor.doFilter()");
		 FilterInvocation invocation = new FilterInvocation(request, response, chain);  
	     invoke(invocation);  
	}

	/**
	 * 
	 * @description 
	 * @param invocation
	 * @throws IOException
	 * @throws ServletException
	 * @author qye.zheng
	 */
	private void invoke(FilterInvocation invocation) throws IOException, ServletException {  
        // object为FilterInvocation对象  
                  //super.beforeInvocation(fi);源码  
        //1.获取请求资源的权限  
        //执行Collection<ConfigAttribute> attributes = SecurityMetadataSource.getAttributes(object);  
        //2.是否拥有权限  
        //this.accessDecisionManager.decide(authenticated, object, attributes);  
		// 调用前，执行 doFilter之前，进行权限检查.
        InterceptorStatusToken token = super.beforeInvocation(invocation);  
        try {  
            invocation.getChain().doFilter(invocation.getRequest(), invocation.getResponse());  
        } finally {
        	// 调用后
            super.afterInvocation(token, null);  
        }  
    }  	
	
	/**
	 * @description 
	 * @param arg0
	 * @throws ServletException
	 * @author qye.zheng
	 */
	@Override
	public void init(FilterConfig arg0) throws ServletException
	{
		System.out.println("MySecurityInterceptor.init()");
	}

	/**
	 * @description 
	 * @return
	 * @author qye.zheng
	 */
	@Override
	public Class<?> getSecureObjectClass()
	{
		return FilterInvocation.class;
	}

	/**
	 * @description 
	 * @return
	 * @author qye.zheng
	 */
	@Override
	public SecurityMetadataSource obtainSecurityMetadataSource()
	{
		return securityMetadataSource;
	}

	/**
	 * @return the securityMetadataSource
	 */
	public final FilterInvocationSecurityMetadataSource getSecurityMetadataSource()
	{
		return securityMetadataSource;
	}

	/**
	 * @param securityMetadataSource the securityMetadataSource to set
	 */
	public final void setSecurityMetadataSource(
			FilterInvocationSecurityMetadataSource securityMetadataSource)
	{
		this.securityMetadataSource = securityMetadataSource;
	}

}
