/**
  * @filename UserBusinessImpl2.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.service.impl;

import org.springframework.stereotype.Service;

import com.hua.bean.ResultBean;
import com.hua.bean.User;
import com.hua.bean.UserSearchBean;
import com.hua.service.UserBusiness;

 /**
 * @type UserBusinessImpl2
 * @description 
 * @author qianye.zheng
 */
public class UserBusinessImpl2 extends CoreServiceImpl implements UserBusiness
{

	/**
	 * @description 
	 * @param user
	 * @return
	 * @author qianye.zheng
	 */
	@Override
	public ResultBean add(User user)
	{
		System.out.println("UserBusinessImpl2.add()");
		return null;
	}

	/**
	 * @description 
	 * @param msg
	 * @return
	 * @author qianye.zheng
	 */
	@Override
	public ResultBean send(String msg)
	{
		return null;
	}

	/**
	 * @description 
	 * @param id
	 * @return
	 * @author qianye.zheng
	 */
	@Override
	public ResultBean delete(String id)
	{
		return null;
	}

	/**
	 * @description 
	 * @param user
	 * @return
	 * @author qianye.zheng
	 */
	@Override
	public ResultBean update(User user)
	{
		return null;
	}

	/**
	 * @description 
	 * @param id
	 * @return
	 * @author qianye.zheng
	 */
	@Override
	public ResultBean get(String id)
	{
		return null;
	}

	/**
	 * @description 
	 * @param searchBean
	 * @return
	 * @author qianye.zheng
	 */
	@Override
	public ResultBean search(UserSearchBean searchBean)
	{
		return null;
	}

}
