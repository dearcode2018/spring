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
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hua.annotation.NotBlank;
import com.hua.bean.Pager;
import com.hua.bean.ResultBean;
import com.hua.bean.ValidateResult;
import com.hua.constant.UriConstant;
import com.hua.controller.BaseController;
import com.hua.entity.User;
import com.hua.entity.UserLog;
import com.hua.service.sys.UserService;
import com.hua.validate.NotBlankValidator;

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
	@RequestMapping("insert")
	@ResponseBody
	public final ResultBean insert(@Valid final User user, final Errors errors)
	{
		final ResultBean resultBean = new ResultBean();
		log.info("insert =====> enter ...");
		final ValidateResult validateResult = NotBlankValidator.validate(user);
		if (validateResult.isError())
		{
			log.warn("insert =====> 字段验证有错误1");
			resultBean.setMessage(validateResult.getMessage());
			
			return resultBean;
		}
		if (errors.hasFieldErrors())
		{
			log.warn("insert =====> 字段验证有错误2");
			resultBean.setMessage("字段验证有错误");
			
			return resultBean;
		}
		
		return userService.login(user);
	}	

	/**
	 * 
	 * @description 
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @author qianye.zheng
	 */
	@RequestMapping("update")
	@ResponseBody
	public final ResultBean update(final HttpServletRequest request, 
			final HttpServletResponse response, final User user)
	{
		log.info("login =====> enter ...");
		
		return userService.login(user);
	}		
	
	@RequestMapping("login")
	@ResponseBody
	public final ResultBean login(final HttpServletRequest request, 
			final HttpServletResponse response, final User user)
	{
		log.info("login =====> enter ...");
		
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
