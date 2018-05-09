/**
 * CookieUtil.java
 * @author  qye.zheng
 * 	version 1.0
 */
package com.hua.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * CookieUtil
 * 描述: 
 * @author  qye.zheng
 */
public final class CookieUtil
{

	//设置cookie经过多长秒后被删除。如果0，就说明立即删除。如果是负数就表明当浏览器关闭时自动删除。
	private final static int AGE=-1;

	//设置路径，这个路径即该工程下都可以访问该cookie 如果不设置路径，那么只有设置该cookie路径及其子路径可以访问
	private final static String PATH="/";
	
	/**
	 * 构造方法
	 * 描述: 
	 * @author  qye.zheng
	 */
	private CookieUtil()
	{
	}

	/**
	 * 
	 * @description 添加cookie
	 * @param response
	 * @param domain
	 * @param key 键
	 * @param value 值
	 * @author qianye.zheng
	 */
	public static final void add(final HttpServletResponse response, final String domain, final String key, final String value)
	{
		Cookie cookie = new Cookie(key, value);
		cookie.setPath(PATH);
		cookie.setMaxAge(AGE);
		cookie.setDomain(domain);
		response.addCookie(cookie);
	}
	
	/**
	 * 
	 * @description 
	 * @param request
	 * @param response
	 * @param key
	 * @return
	 * @author qianye.zheng
	 */
	public static final boolean delete(final HttpServletRequest request, final HttpServletResponse response, final String key)
	{
		final Cookie cookie = get(request, key);
		if (null != cookie)
		{
			// 0 - 立即删除
			cookie.setMaxAge(0);
			cookie.setPath(PATH);
			response.addCookie(cookie);
			
			return true;
		}
		
		return false;
	}
	
	/**
	 * 
	 * @description 
	 * @param request
	 * @param key
	 * @return
	 * @author qianye.zheng
	 */
	public static final Cookie get(final HttpServletRequest request, final String key)
	{
		final Cookie[] cookies = request.getCookies();
		if (EmptyUtil.isNotEmpty(cookies))
		{
			for (Cookie e : cookies)
			{
				if (e.getName().equals(key))
				{
					return e;
				}
			}
		}
		
		return null;
	}
	
}
