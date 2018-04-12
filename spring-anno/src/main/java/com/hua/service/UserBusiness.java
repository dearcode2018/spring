/**
 * 描述: 
 * UserBusiness.java
 * @author	qye.zheng
 *  version 1.0
 */
package com.hua.service;

import com.hua.bean.ResultBean;
import com.hua.bean.User;
import com.hua.bean.UserSearchBean;

/**
 * 描述: 用户业务
 * @author  qye.zheng
 * UserBusiness
 */
public interface UserBusiness extends CoreService
{
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * @param sundayBean
	 * @return
	 */
	public ResultBean add(final User user);

	/**
	 * 
	 * @description 
	 * @param msg
	 * @return
	 * @author qye.zheng
	 */
	public ResultBean send(final String msg);
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * @param oid
	 * @return
	 */
	public ResultBean delete(final String id);
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * @param sundayBean
	 * @return
	 */
	public ResultBean update(final User user);
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * @param oid
	 * @return
	 */
	public ResultBean get(final String id);
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * @param searchBean
	 * @return
	 */
	public ResultBean search(final UserSearchBean searchBean);
}
