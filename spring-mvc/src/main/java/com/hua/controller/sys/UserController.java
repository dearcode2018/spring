/**
  * @filename UserController.java
  * @description  
  * @version 1.0
  * @author qye.zheng
 */
package com.hua.controller.sys;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hua.bean.Pager;
import com.hua.bean.ResultBean;
import com.hua.constant.UriConstant;
import com.hua.controller.BaseController;
import com.hua.entity.User;
import com.hua.entity.UserLog;
import com.hua.service.sys.UserService;
import com.hua.util.CookieUtil;

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
	
	@RequestMapping("login")
	@ResponseBody
	public final ResultBean login(final HttpServletRequest request, 
			final HttpServletResponse response, final User user)
	{
		log.info("login =====> enter ...");
		Cookie[] cookies = request.getCookies();
		if (null != cookies)
		{
			for (Cookie e : cookies)
			{
				log.info("key = " + e.getName() + ", value = " + e.getValue());
			}
		}
		CookieUtil.add(response, "www.hua.com", "AUTH-HEADER", "KWEO2309DKMCOODKWE23O0");
		CookieUtil.add(response, ".com", "AUTH-HEADER", "KWEO2309DKMCOODKWE23O1");
		CookieUtil.add(response, ".hua.com", "AUTH-HEADER", "KWEO2309DKMCOODKWE23O2");
		CookieUtil.add(response, "www.rj-info.com", "AUTH-HEADER", "WELO349JKSDJLLWE0K");
		
		
		return userService.login(user);
	}

	@RequestMapping("")
	public final ResultBean temp(final HttpServletRequest request, 
			final HttpServletResponse response, final User user)
	{
		return null;
	}
	
	@RequestMapping("moreParams")
	@ResponseBody
	public final ResultBean moreParams(final HttpServletRequest request, 
			final HttpServletResponse response, final User user, final Pager<User> pager, final UserLog userLog)
	{
		log.info("moreParams =====> enter ...");
		// 接收参数1
		log.info("moreParams =====> " + user.getUsername());
		
		// 接收参数2
		log.info("moreParams =====> " + pager.getPageSize());
		
		// 接收参数3
		log.info("moreParams =====> " + userLog.getUsername());
		log.info("moreParams =====> " + userLog.getLoginIp());
		
		
		return new ResultBean();
	}
	
}
