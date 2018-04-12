/**
  * @filename UserServiceImpl.java
  * @description  
  * @version 1.0
  * @author qye.zheng
 */
package com.hua.service.sys.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hua.bean.ResultBean;
import com.hua.dao.sys.UserDao;
import com.hua.entity.User;
import com.hua.service.impl.CoreServiceImpl;
import com.hua.service.sys.UserService;

 /**
 * @type UserServiceImpl
 * @description  
 * @author qye.zheng
 */
@Service
public final class UserServiceImpl extends CoreServiceImpl implements
		UserService
{

	@Resource
	private UserDao userDao;
	
	/**
	 * @description 
	 * @param user
	 * @return
	 * @author qye.zheng
	 */
	@Override
	public ResultBean login(final User user)
	{
		final ResultBean resultBean = new ResultBean();
		final User sUser = userDao.getByUsername(user.getUsername());
		if (null == sUser)
		{
			log.info("login =====> 用户不存在，请重新输入!");
			resultBean.setMessage("用户不存在，请重新输入!");
		} else
		{
			if (!sUser.getPassword().equals(user.getPassword()))
			{
				log.info("login =====> 用户名 或 密码不正确，请重新输入!");
				// 密码不正确
				resultBean.setMessage("用户名 或 密码不正确，请重新输入!");
			} else 
			{
				log.info("login =====> 登录成功!");
				resultBean.setMessage("登录成功!");
			}
		}
		
		return resultBean;
	}

}
