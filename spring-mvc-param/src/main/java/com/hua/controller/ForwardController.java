/**
  * @filename ForwardController.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hua.bean.Person;
import com.hua.bean.ResultBean;
import com.hua.constant.Constant;
import com.hua.constant.UriConstant;
import com.hua.util.DateTimeUtil;
import com.hua.util.JacksonUtil;
import com.hua.util.StringUtil;

/**
 * @type ForwardController
 * @description 转发
 * @author qianye.zheng
 */
@Controller
@RequestMapping(UriConstant.FORWARD)
public class ForwardController extends BaseController
{

	
	
	/**
	 * 
	 * @description GET转发
	 * @param request
	 * @param response
	 * @author qianye.zheng
	 */
	@RequestMapping(value = "/get", method = { RequestMethod.GET })
	public void get(final HttpServletRequest request, final HttpServletResponse response)
	{
		// 从头部和url提取参数
		String header1 = request.getHeader("X-AUTH");
		String param1 = request.getParameter("name");
		String param2 = request.getParameter("age");
		String param3 = request.getParameter("sex");
		String queryString = request.getQueryString();
		System.out.println("header1 = " + header1);
		System.out.println("param1 = " + param1 + ", param2 = " + param2 + ", param3 = " + param3);
		try
		{
			if (StringUtil.isNotEmpty(queryString))
			{
				// url解码
				queryString = URLDecoder.decode(queryString, Constant.CHART_SET_UTF_8);
				System.out.println("queryString = " + queryString);
			}
		} catch (UnsupportedEncodingException e1)
		{
			e1.printStackTrace();
		}
		
		// 响应
		ResultBean result = new ResultBean();
		result.setMessage("收到[" + param1 + "]的请求");
		result.setMessageCode("205");
		result.setSuccess(true);
		Person person = new Person();
		person.setId("2001");
		person.setUsername("王东22");
		// 时间戳
		// "lastLoginTime":1455591443154
		person.setLastLoginTime(DateTimeUtil.getTimestamp());
		// "utilDate":1455591443154
		person.setUtilDate(DateTimeUtil.getDateTime());
		// "sqlDate":"2016-02-16"
		person.setSqlDate(DateTimeUtil.getDate());
		result.setData(person);
		try
		{
			response.setCharacterEncoding(Constant.CHART_SET_UTF_8);
			JacksonUtil.writeValue(response.getOutputStream(), result);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}

	/**
	 * 
	 * @description POST转发
	 * @param request
	 * @param response
	 * @author qianye.zheng
	 */
	@RequestMapping(value = "/post", method = { RequestMethod.POST })
	@SuppressWarnings({"unchecked"})
	public void post(final HttpServletRequest request, final HttpServletResponse response)
	{
		try
		{
			Map<?, ?> params = JacksonUtil.readValue(request.getInputStream(), Map.class);
			System.out.println(JacksonUtil.writeAsString(params));
			Map<String, String> params2 = (Map<String, String>) params;
			Set<Map.Entry<String, String>> entrySet = params2.entrySet();
			// 逐个取出来
			for (Map.Entry<String, String> e : entrySet)
			{
				System.out.println(e.getKey() + " = " + e.getValue());
			}
			
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
		// 响应
		ResultBean result = new ResultBean();
		result.setMessage("收到[" + "post" + "]的请求");
		result.setMessageCode("205");
		result.setSuccess(true);
		Person person = new Person();
		person.setId("2001");
		person.setUsername("王东22");
		// 时间戳
		// "lastLoginTime":1455591443154
		person.setLastLoginTime(DateTimeUtil.getTimestamp());
		// "utilDate":1455591443154
		person.setUtilDate(DateTimeUtil.getDateTime());
		// "sqlDate":"2016-02-16"
		person.setSqlDate(DateTimeUtil.getDate());
		result.setData(person);
		try
		{
			response.setCharacterEncoding(Constant.CHART_SET_UTF_8);
			JacksonUtil.writeValue(response.getOutputStream(), result);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
		
	}
	
}
