/**
 * 描述: 
 * UserBusinessImpl.java
 * @author	qye.zheng
 *  version 1.0
 */
package com.hua.service.impl;

import com.hua.bean.ResultBean;
import com.hua.bean.User;
import com.hua.bean.UserSearchBean;
import com.hua.service.UserBusiness;

/**
 * 描述: 用户业务
 * @author  qye.zheng
 * UserBusinessImpl
 */
public class UserBusinessImpl extends CoreServiceImpl implements UserBusiness
{

	/**
	 * 描述: 
	 * @author qye.zheng
	 * @param user
	 * @return
	 */
	@Override
	public final ResultBean add(final User user)
	{
		System.out.println("UserBusinessImpl.add()");
		// 制造异常出现
		user.getId();
		final ResultBean resultBean = new ResultBean();
		
		return resultBean;
	}
	
	/**
	 * 描述: 
	 * @author qye.zheng
	 * @param user
	 * @return
	 */
	@Override
	public final ResultBean send(final String msg)
	{
		//System.out.println("UserBusinessImpl.add()");
		// 制造异常出现
		//user.getId();
		final ResultBean resultBean = new ResultBean();
		
		return resultBean;
	}

	/**
	 * 描述: 
	 * @author qye.zheng
	 * @param oid
	 * @return
	 */
	@Override
	public final ResultBean delete(final String id)
	{
		System.out.println("UserBusinessImpl.delete()");
		
		final ResultBean resultBean = new ResultBean();
		
		return resultBean;
	}

	/**
	 * 描述: 
	 * @author qye.zheng
	 * @param user
	 * @return
	 */
	@Override
	public final ResultBean update(final User user)
	{
		System.out.println("UserBusinessImpl.update()");
		
		final ResultBean resultBean = new ResultBean();
		
		return resultBean;
	}

	/**
	 * 描述: 
	 * @author qye.zheng
	 * @param oid
	 * @return
	 */
	@Override
	public final ResultBean get(final String id)
	{
		System.out.println("UserBusinessImpl.get()");
		
		final ResultBean resultBean = new ResultBean();
		
		return resultBean;
	}

	/**
	 * 描述: 
	 * @author qye.zheng
	 * @param searchBean
	 * @return
	 */
	@Override
	public final ResultBean search(final UserSearchBean searchBean)
	{
		System.out.println("UserBusinessImpl.search()");
		
		final ResultBean resultBean = new ResultBean();
		
		return resultBean;
	}

}
