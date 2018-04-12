/**
 * 描述: 
 * JspController.java
 * @author qye.zheng
 * 
 *  version 1.0
 */
package com.hua.controller.jsp;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
/*
 * 注意，不能使用该类作为  ModelAndView ，否则将无法正确返回jsp页面
 * import org.springframework.web.portlet.ModelAndView;
 * 而应该使用
 * org.springframework.web.servlet.ModelAndView
 */
import org.springframework.web.servlet.ModelAndView;

import com.hua.controller.BaseController;
import com.hua.entity.User;
import com.hua.util.DateTimeUtil;

/**
 * 描述: 
 * @author qye.zheng
 * 
 * JspController
 */
// 控制器
@Controller
@RequestMapping(value={"/JspController"})
//@RequestMapping(value={"/"})
public final class JspController extends BaseController
{
	
	/**
	 * 
	 * @description 
	 * @param request
	 * @param response
	 * @return
	 * @author qianye.zheng
	 */
	@RequestMapping(value={"/v0"}, method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView getJspV0() {
		System.out.println("JspController.getJspV0()");
		User user = new User();
		user.setId("20150628");
		user.setUsername("张三");
		user.setNickname("少年张三丰");
		user.setPassword("123456");
		user.setValid(false);
		user.setLastLoginTime(DateTimeUtil.getTimestamp());
		user.setLastLoginIp("192.168.5.66");
		final Map<String, Object> model = new HashMap<String, Object>();
		model.put("id", user.getId());
		model.put("username", user.getUsername());
		model.put("nickname", user.getNickname());
		model.put("password", user.getPassword());
		model.put("type", user.getType());
		model.put("valid", user.isValid());
		model.put("lastLoginTime", user.getLastLoginTime());
		model.put("lastLoginIp", user.getLastLoginIp());
		// 视图名称，通过InternalResourceViewResolver 来接解析具体的jsp资源
		String viewName = null;
		viewName = "spring-jsp";
		//viewName = "v1/spring-jsp-v1";
		//viewName = "v2/spring-jsp-v2";
		// 模型和视图对象
		final ModelAndView modelAndView = new ModelAndView(viewName, model);
		
		return modelAndView;
	}
	
	/**
	 * 
	 * @description 
	 * @param request
	 * @param response
	 * @return
	 * @author qianye.zheng
	 */
	@RequestMapping(value={"/v1"})
	@ResponseBody
	public ModelAndView getJspV1(final HttpServletRequest request, 
			final HttpServletResponse response) {
		User user = new User();
		user.setId("20150628");
		user.setUsername("张三");
		user.setNickname("少年张三丰");
		user.setPassword("123456");
		user.setValid(false);
		user.setLastLoginTime(DateTimeUtil.getTimestamp());
		user.setLastLoginIp("192.168.5.66");
		final Map<String, Object> model = new HashMap<String, Object>();
		model.put("id", user.getId());
		model.put("username", user.getUsername());
		model.put("nickname", user.getNickname());
		model.put("password", user.getPassword());
		model.put("type", user.getType());
		model.put("valid", user.isValid());
		model.put("lastLoginTime", user.getLastLoginTime());
		model.put("lastLoginIp", user.getLastLoginIp());
		// 视图名称，通过InternalResourceViewResolver 来接解析具体的jsp资源
		String viewName = null;
		//viewName = "spring-jsp";
		viewName = "v1/spring-jsp-v1";
		//viewName = "v2/spring-jsp-v2";
		// 模型和视图对象
		final ModelAndView modelAndView = new ModelAndView(viewName, model);
		
		return modelAndView;
	}
	
	/**
	 * 
	 * @description 
	 * @param request
	 * @param response
	 * @return
	 * @author qianye.zheng
	 */
	@RequestMapping(value={"/v2"})
	@ResponseBody
	public ModelAndView getJspV2(final HttpServletRequest request, 
			final HttpServletResponse response) {
		User user = new User();
		user.setId("20150628");
		user.setUsername("张三");
		user.setNickname("少年张三丰");
		user.setPassword("123456");
		user.setValid(false);
		user.setLastLoginTime(DateTimeUtil.getTimestamp());
		user.setLastLoginIp("192.168.5.66");
		final Map<String, Object> model = new HashMap<String, Object>();
		model.put("id", user.getId());
		model.put("username", user.getUsername());
		model.put("nickname", user.getNickname());
		model.put("password", user.getPassword());
		model.put("type", user.getType());
		model.put("valid", user.isValid());
		model.put("lastLoginTime", user.getLastLoginTime());
		model.put("lastLoginIp", user.getLastLoginIp());
		// 视图名称，通过InternalResourceViewResolver 来接解析具体的jsp资源
		String viewName = null;
		//viewName = "spring-jsp";
		//viewName = "v1/spring-jsp-v1";
		viewName = "v2/spring-jsp-v2";
		// 模型和视图对象
		final ModelAndView modelAndView = new ModelAndView(viewName, model);
		
		return modelAndView;
	}
	
	/**
	 * 
	 * @description 注释掉 InternalResourceViewResolver 配置，
	 * 直接返回相对路径
	 * @param request
	 * @param response
	 * @return
	 * @author qianye.zheng
	 */
	@RequestMapping(value={"/v3"})
	@ResponseBody
	public ModelAndView getJspV3(final HttpServletRequest request, 
			final HttpServletResponse response) {
		User user = new User();
		user.setId("20150628");
		user.setUsername("张三");
		user.setNickname("少年张三丰");
		user.setPassword("123456");
		user.setValid(false);
		user.setLastLoginTime(DateTimeUtil.getTimestamp());
		user.setLastLoginIp("192.168.5.66");
		final Map<String, Object> model = new HashMap<String, Object>();
		model.put("id", user.getId());
		model.put("username", user.getUsername());
		model.put("nickname", user.getNickname());
		model.put("password", user.getPassword());
		model.put("type", user.getType());
		model.put("valid", user.isValid());
		model.put("lastLoginTime", user.getLastLoginTime());
		model.put("lastLoginIp", user.getLastLoginIp());
		// 视图名称，通过InternalResourceViewResolver 来接解析具体的jsp资源
		String viewName = null;
		/**
		 * 从根路径开始
		 */
		viewName = "/jsp/v3/spring-jsp-v3.jsp";
		// 模型和视图对象
		final ModelAndView modelAndView = new ModelAndView(viewName, model);
		
		return modelAndView;
	}
	
	/**
	 * 
	 * @description 注释掉 InternalResourceViewResolver 配置，
	 * 直接返回相对路径，jsp资源放在 WEB-INF目录下
	 * @param request
	 * @param response
	 * @return
	 * @author qianye.zheng
	 */
	@RequestMapping(value={"/v4"})
	@ResponseBody
	public ModelAndView getJspV4(final HttpServletRequest request, 
			final HttpServletResponse response) {
		User user = new User();
		user.setId("20150628");
		user.setUsername("张三");
		user.setNickname("少年张三丰");
		user.setPassword("123456");
		user.setValid(false);
		user.setLastLoginTime(DateTimeUtil.getTimestamp());
		user.setLastLoginIp("192.168.5.66");
		final Map<String, Object> model = new HashMap<String, Object>();
		model.put("id", user.getId());
		model.put("username", user.getUsername());
		model.put("nickname", user.getNickname());
		model.put("password", user.getPassword());
		model.put("type", user.getType());
		model.put("valid", user.isValid());
		model.put("lastLoginTime", user.getLastLoginTime());
		model.put("lastLoginIp", user.getLastLoginIp());
		// 视图名称，通过InternalResourceViewResolver 来接解析具体的jsp资源
		String viewName = null;
		/**
		 * 从根路径开始
		 */
		viewName = "/WEB-INF/jsp/spring-jsp.jsp";
		// 模型和视图对象
		final ModelAndView modelAndView = new ModelAndView(viewName, model);
		
		return modelAndView;
	}	
	
}
