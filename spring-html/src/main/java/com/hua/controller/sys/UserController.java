/**
  * @filename UserController.java
  * @description  
  * @version 1.0
  * @author qye.zheng
 */
package com.hua.controller.sys;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hua.bean.LoginVo;
import com.hua.bean.Pager;
import com.hua.bean.ResultBean;
import com.hua.constant.SpringMVCConstant;
import com.hua.constant.UriConstant;
import com.hua.controller.BaseController;
import com.hua.entity.User;
import com.hua.entity.UserLog;
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
	 * @author qianye.zheng
	 */
	@RequestMapping("/login")
	@ResponseBody
	public final ResultBean login(final HttpServletRequest request, 
			final HttpServletResponse response, final User user)
	{
		log.info("login =====> enter ...");
		
		
		final ResultBean resultBean = new ResultBean();
		//final User sUser = userDao.getByUsername(user.getUsername());
		final User sUser = getUser();
		if (null == sUser)
		{
			log.info("login =====> 用户不存在，请重新输入!");
			resultBean.setMessage("用户不存在，请重新输入!");
			resultBean.setMessageCode("10002");
		} else
		{
			if (!sUser.getPassword().equals(user.getPassword()))
			{
				log.info("login =====> 用户名 或 密码不正确，请重新输入!");
				// 密码不正确
				resultBean.setMessage("用户名 或 密码不正确，请重新输入!");
				resultBean.setMessageCode("10001");
			} else 
			{ // 登录成功
				final LoginVo loginVo = new LoginVo();
				loginVo.setUsername(sUser.getUsername());
				loginVo.setNickname(sUser.getNickname());
				log.info("login =====> 登录成功!");
				resultBean.setMessage("登录成功!");
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
				 */
				// 服务端进行缓存，设置缓存30分钟，可以通过缓存插件实现，此处仅是进行模拟
			
				// 设置客户端的Cookie，把页面从 登录页面 重定向 到 主页
				Cookie cookie = null;
				cookie = new Cookie(SpringMVCConstant.COOKIE_AUTH_KEY, SpringMVCConstant.COOKIE_AUTH_VALUE);
				// 负数-不存储 0-删除，单位: 秒
				cookie.setMaxAge(5 * 60);
				response.addCookie(cookie);
				
				resultBean.setMessageCode("200");
				// 返回用户信息
				resultBean.setData(loginVo);
				// 重定向到主页面
				try
				{
					response.sendRedirect(request.getContextPath() + "/views/main/main.html");
				} catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
		
		return resultBean;		
		//return userService.login(user);
	}
	
	/**
	 * 
	 * @description 
	 * @param request
	 * @param response
	 * @return
	 * @author qianye.zheng
	 */
	@RequestMapping("/get")
	@ResponseBody
	public final ResultBean get(final HttpServletRequest request, 
			final HttpServletResponse response)
	{
		/**
		 * 从 客户端传递的Cookie中获取用户关联信息，然后从缓存中获取用户信息
		 */
		final ResultBean resultBean = new ResultBean();
		
		Cookie[] cookies = request.getCookies();
		// 查找指定的cookie
		for (Cookie cookie : cookies)
		{
			if (SpringMVCConstant.COOKIE_AUTH_KEY.equals(cookie.getName()))
			{
				// 取出cookie，然后在缓存中查找用户信息，这里模拟直接返回
				final User sUser = getUser();
				final LoginVo loginVo = new LoginVo();
				loginVo.setUsername(sUser.getUsername());
				loginVo.setNickname(sUser.getNickname());
				resultBean.setData(loginVo);
			}
		}
		
		return resultBean;		
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
	
	/**
	 * 
	 * @description 模拟从数据库中获取值
	 * @return
	 * @author qye.zheng
	 */
	private final User getUser()
	{
		User user = new User();
		user.setUsername("admin");
		user.setPassword("123456");
		return user;
	}
	
}
