/**
  * @filename SystemHandlerInterceptor.java
  * @description 
  * @version 1.0
  * @author qye.zheng
 */
package com.hua.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.hua.constant.SpringMVCConstant;
import com.hua.util.EmptyUtil;

 /**
 * @type SystemHandlerInterceptor
 * @description Spring 系统拦截器
 * @author qye.zheng
 */
// 或者继承 HandlerInterceptorAdapter
// public final class SystemHandlerInterceptor extends HandlerInterceptorAdapter
public final class SystemHandlerInterceptor implements HandlerInterceptor {

	/* apache commons log */
	protected Log log = LogFactory.getLog(this.getClass().getName());
	
	/**
	 * @description 前置处理 action之前执行
	 * @param request
	 * @param response
	 * @param handler
	 * @return
	 * @throws Exception
	 * @author qye.zheng
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		//String requestData = StringUtil.streamToString(request.getInputStream());
		//System.out.println(requestData);
		log.info("preHandle =====> " + request.getRemoteAddr());
		
		/*
		 * 登录成功后，服务端设置缓存，客户端-浏览器设置Cookie
		 * 然后每次授权请求都带上Cookie 去校验该用户的权限和角色
		 * 每次登录，服务端都会返回相关信息给客户端，然后在后来的每次交互中
		 * 使用一个标识来分区用户.
		 * 
		 * 服务端设置缓存
		 * 根据Cookie值来缓存用户信息，每次客户端有授权请求更新缓存值和时间，一般
		 * 客户端使用浏览器则缓存30分钟或1-2个小时，若是app或者pc客户端则可以缓存更长时间，30天或者半年.
		 * 支持一个用户可以同时登录单个或多个客户端
		 * 若缓存过期，则通知客户端跳转到登录页面，若客户端使用浏览器则可以通过重定向或页面跳转来实现.
		 * 
		 * 
		 * 客户端-浏览器设置Cookie
		 * 设置值和生存周期，例如 1天、7天、30天 或者半年
		 * 
		 * 
		 * 
		 * 服务端接收到的cookie为空或者无法找到用户信息，则通知客户端-浏览器 跳转到登录页面.
		 * 
		 */
		final Cookie[] cookies = request.getCookies();
		// 查找指定的cookie
		Cookie cookie = getCookie(cookies);
		if (null == cookie || !SpringMVCConstant.COOKIE_AUTH_VALUE.equals(cookie.getValue()))
		{
			// 重定向到登录页面
			response.sendRedirect(request.getContextPath() + "/views/login/login.html?a=b");
			cookie = new Cookie(SpringMVCConstant.COOKIE_AUTH_KEY, "");
			// 负数-不存储 0-删除，单位: 秒
			cookie.setMaxAge(0);
			// 删除cookie
			response.addCookie(cookie);
			log.warn("cookie不存在或者已经过期");
			
			return false;
		}
		
		return true;
	}

	/**
	 * @description 后置处理 视图生成之前执行
	 * postHandle中，有机会修改ModelAndView
	 * @param request
	 * @param response
	 * @param handler
	 * @param modelAndView
	 * @throws Exception
	 * @author qye.zheng
	 */
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	/**
	 * @description 完成后 用于释放资源
	 * @param request
	 * @param response
	 * @param handler
	 * @param ex
	 * @throws Exception
	 * @author qye.zheng
	 */
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// 更新cookie失效时间
		Cookie cookie = new Cookie(SpringMVCConstant.COOKIE_AUTH_KEY, SpringMVCConstant.COOKIE_AUTH_VALUE);
		// 负数-不存储 0-删除，单位: 秒
		cookie.setMaxAge(5 * 60);
		// 删除cookie
		//response.addCookie(cookie);
		//log.info("cookie value = " + cookie.getValue());
	}

	/**
	 * 
	 * @description 
	 * @param cookies
	 * @return
	 * @author qianye.zheng
	 */
	private Cookie getCookie(final Cookie[] cookies)
	{
		Cookie result = null;
		if (!EmptyUtil.isEmpty(cookies))
		{
			for (Cookie cookie : cookies)
			{
				if (SpringMVCConstant.COOKIE_AUTH_KEY.equals(cookie.getName()))
				{
					result = cookie;
					
					break;
				}
			}
		}
		
		return result;
	}
	
}
