/**
  * @filename SystemHandlerInterceptor.java
  * @description 
  * @version 1.0
  * @author qye.zheng
 */
package com.hua.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.MethodParameter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.hua.annotation.NotBlank;
import com.hua.bean.ValidateResult;
import com.hua.validate.NotBlankValidator;

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
		

		HandlerMethod handlerMethod = (HandlerMethod) handler;
		MethodParameter[] methodParameters = handlerMethod.getMethodParameters();
		NotBlank notBlank = null;
		for (MethodParameter e : methodParameters)
		{
			notBlank = e.getParameterAnnotation(NotBlank.class);
			//AnnotatedElement annotatedElement = e.getAnnotatedElement();
			//notBlank = annotatedElement.getDeclaredAnnotation(NotBlank.class);
			//notBlank = e.getParameterAnnotation(NotBlank.class);
/*			if (null != notBlank)
			{
				final ValidateResult validateResult = NotBlankValidator.validate(handlerMethod.getMethod());
			}*/
		}
		
		log.info("preHandle =====> " + request.getRemoteAddr());
		
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
	}

}
