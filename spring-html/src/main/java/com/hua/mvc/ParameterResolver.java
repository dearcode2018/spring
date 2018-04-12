/**
  * @filename ParameterResolver.java
  * @description  
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.mvc;

import java.beans.PropertyEditorSupport;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.hua.util.DateTimeUtil;
import com.hua.util.StringUtil;

 /**
 * @type ParameterResolver
 * @description  参数解析器
 * contentType = application/x-www-form-urlencoded 解析此类型的参数
 * @author qianye.zheng
 */
// Spring 4.x已经改成 HandlerMethodArgumentResolver
//public class ParameterResolver implements WebArgumentResolver
public class ParameterResolver implements HandlerMethodArgumentResolver
{
	protected Log log = LogFactory.getLog(this.getClass().getName());
	
	private static final Set<String> ignoreClassNameSet = new LinkedHashSet<String>();

	static
	{ 
		/*
		 * 忽略调基本类型和字符串/日期类型 作为单一的参数
		 * 
		 */
		ignoreClassNameSet.add(Boolean.class.getName());
		ignoreClassNameSet.add("boolean");
		ignoreClassNameSet.add(Byte.class.getName());
		ignoreClassNameSet.add("byte");
		ignoreClassNameSet.add(Short.class.getName());
		ignoreClassNameSet.add("short");
		//ignoreClassNameSet.add(Character.class.getName());
		//ignoreClassNameSet.add("char");
		ignoreClassNameSet.add(Integer.class.getName());
		ignoreClassNameSet.add("int");
		ignoreClassNameSet.add(Long.class.getName());
		ignoreClassNameSet.add("long");
		ignoreClassNameSet.add(Float.class.getName());
		ignoreClassNameSet.add("float");
		ignoreClassNameSet.add(Double.class.getName());
		ignoreClassNameSet.add("double");
		ignoreClassNameSet.add(Date.class.getName());
		ignoreClassNameSet.add(String.class.getName());
		ignoreClassNameSet.add(HttpServletRequest.class.getName());
		ignoreClassNameSet.add(HttpServletResponse.class.getName());
		ignoreClassNameSet.add(WebDataBinder.class.getName());
	}
	
	/**
	 * @description 判断是否支持自定义的解析参数
	 * @param parameter
	 * @return
	 * @author qianye.zheng
	 */
	@Override
	public boolean supportsParameter(MethodParameter parameter)
	{
		//log.info("supportsParameter =====> parameterName = " + parameter.getParameterName());
		//log.info("supportsParameter =====> parameterTypeName = " + parameter.getParameterType().getName());
		return !ignoreClassNameSet.contains(parameter.getParameterType().getName());
		//return ignoreClassNameSet.contains(parameter);
	}

	/**
	 * @description 
	 * @param methodParameter
	 * @param mavContainer
	 * @param request
	 * @param binderFactory
	 * @return
	 * @throws Exception
	 * @author qianye.zheng
	 */
	@Override
	public Object resolveArgument(MethodParameter methodParameter,
			ModelAndViewContainer mavContainer, NativeWebRequest request,
			WebDataBinderFactory binderFactory) throws Exception
	{
		log.info("resolveArgument =====> parameterName = " + methodParameter.getParameterName());
		log.info("resolveArgument =====> parameterTypeName = " + methodParameter.getParameterType().getName());
		final Class<?> clazz = methodParameter.getParameterType();
		String parameterName = methodParameter.getParameterName();
		if (StringUtil.isEmpty(parameterName))
		{ // 参数名为空,则取其简单类名
			parameterName = clazz.getSimpleName();
			// 将第一个字母转成小写
			parameterName = parameterName.substring(0, 1).toLowerCase() + parameterName.substring(1);
		}
		final Iterator<String> it = request.getParameterNames();
		final Map<String, String> paramsMap = new LinkedHashMap<String, String>();
		String key = null;
		while (it.hasNext())
		{ // 从request中逐个取出参数,放入Map中
			key = it.next();
			paramsMap.put(key, request.getParameter(key));
		}
		final Object obj = clazz.newInstance();
		if (!paramsMap.isEmpty())
		{
			// 包装类
			final BeanWrapper beanWrapper = new BeanWrapperImpl(obj);
			// 设置 自动增长嵌套路径
			beanWrapper.setAutoGrowNestedPaths(true);
			// 注册自定义 (日期) 编辑器 解析复合类型中的Date类型
			beanWrapper.registerCustomEditor(Date.class, new PropertyEditorSupport() {
				
				/**
				 * @description 
				 * @param text
				 * @throws IllegalArgumentException
				 * @author qianye.zheng
				 */
				@Override
				public void setAsText(String text)
						throws IllegalArgumentException
				{
					// 根据约定的标准格式,转成日期对象
					setValue(DateTimeUtil.parseStandardDate(text));
					//log.info("setAsText =====> 根据约定的标准格式,转成日期对象");
					//super.setAsText(text);
				}
				/**
				 * @description 
				 * @return
				 * @author qianye.zheng
				 */
				@Override
				public String getAsText()
				{
					return super.getAsText();
				}
			});
			Object value = null;
			for (String paraName : paramsMap.keySet())
			{
				key = paraName;
				value = paramsMap.get(paraName);
				if (null != value)
				{
					// 设置参数bean的属性值
					beanWrapper.setPropertyValue(key, value);
				}
			}
			// 清空参数映射集合
			paramsMap.clear();
			// 设置属性,有效范围 是 SCOPE_REQUEST
			request.setAttribute(parameterName, obj, RequestAttributes.SCOPE_REQUEST);
		}
		
		// 在忽略列表中, 返回无解析对象, 让框架自动解析
		return obj;
	}

	/**
	 * @description 
	 * @param methodParameter
	 * @param request
	 * @return
	 * @throws Exception
	 * @author qianye.zheng
	 */
	//@Override
	public Object resolveArgument__(MethodParameter methodParameter,
			NativeWebRequest request) throws Exception
	{
		final Class<?> clazz = methodParameter.getParameterType();
		log.info("resolveArgument =====> " + clazz.getName());
		if (!ignoreClassNameSet.contains(clazz.getName()))
		{ // 不在忽略列表中
			String parameterName = methodParameter.getParameterName();
			if (StringUtil.isEmpty(parameterName))
			{ // 参数名为空,则取其简单类名
				parameterName = clazz.getSimpleName();
				// 将第一个字母转成小写
				parameterName = parameterName.substring(0, 1).toLowerCase() + parameterName.substring(1);
			}
			final Iterator<String> it = request.getParameterNames();
			final Map<String, String> paramsMap = new LinkedHashMap<String, String>();
			String key = null;
			while (it.hasNext())
			{ // 从request中逐个取出参数,放入Map中
				key = it.next();
				paramsMap.put(key, request.getParameter(key));
			}
			if (!paramsMap.isEmpty())
			{
				final Object obj = clazz.newInstance();
				// 包装类
				final BeanWrapper beanWrapper = new BeanWrapperImpl(obj);
				// 设置 自动增长嵌套路径
				beanWrapper.setAutoGrowNestedPaths(true);
				// 注册自定义 (日期) 编辑器
				beanWrapper.registerCustomEditor(Date.class, new PropertyEditorSupport() {
					
					/**
					 * @description 
					 * @param text
					 * @throws IllegalArgumentException
					 * @author qianye.zheng
					 */
					@Override
					public void setAsText(String text)
							throws IllegalArgumentException
					{
						// 根据约定的标准格式,转成日期对象
						setValue(DateTimeUtil.parseStandardDate(text));
						//super.setAsText(text);
					}
					/**
					 * @description 
					 * @return
					 * @author qianye.zheng
					 */
					@Override
					public String getAsText()
					{
						return super.getAsText();
					}
				});
				Object value = null;
				for (String paraName : paramsMap.keySet())
				{
					// abc.t1, 这样的路径, 取出 t1即可,去掉前缀,支持 二级路径
					key = paraName.substring(parameterName.length() + 1);
					value = paramsMap.get(paraName);
					if (StringUtil.isNotEmpty( (String) value))
					{
						// 设置参数bean的属性值
						beanWrapper.setPropertyValue(key, value);
					}
				}
				// 清空参数映射集合
				paramsMap.clear();
				// 设置属性,有效范围 是 SCOPE_REQUEST
				request.setAttribute(parameterName, obj, RequestAttributes.SCOPE_REQUEST);
				
				return obj;
			}
		}
		
		// 在忽略列表中, 返回无解析对象, 让框架自动解析
		return null;
		//return UNRESOLVED;
	}
	
}
