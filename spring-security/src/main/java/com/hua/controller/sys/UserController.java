/**
  * @filename UserController.java
  * @description  
  * @version 1.0
  * @author qye.zheng
 */
package com.hua.controller.sys;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hua.bean.ResultBean;
import com.hua.constant.UriConstant;
import com.hua.controller.BaseController;
import com.hua.entity.sys.User;
import com.hua.service.sys.UserService;

 /**
 * @type UserController
 * @description  
 * @author qye.zheng
 */
@Controller
@RequestMapping(UriConstant.API + "sys")
public final class UserController extends BaseController
{
	
	@Resource
	private UserService userService;
	
	/**
	 * 
	 * @description 
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @author qye.zheng
	 */
	@RequestMapping("login")
	@ResponseBody
	public final ResultBean login(final HttpServletRequest request, 
			final HttpServletResponse response, final User user)
	{
		log.info("login =====> enter ...");
		
		return userService.login(user);
	}
	
	/**
	 * 
	 * @description 
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @author qye.zheng
	 */
	@RequestMapping("")
	@ResponseBody
	public final ResultBean temp(final HttpServletRequest request, 
			final HttpServletResponse response, final User user)
	{
		return null;
	}
	
}
