/**
 * 描述: 
 * AutowiredUserClient.java
 * @author	qye.zheng
 *  version 1.0
 */
package com.hua.bean;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 描述: 
 * @author  qye.zheng
 * AutowiredUserClient
 */
public final class AutowiredUserClient
{
	/**
	 注意: 对一个类的属性实施注入，要求该类
	 必须以对象形式存在spring的ioc容器中，
	 只有存在与spring ioc容器中的对象作为一个
	 spring的一个bean，才能对其属性施加各种
	 形式的注入.
	 
	 */

	/**
	 * 不存在则会抛异常，存在多个会抛异常
	 */
	@Autowired(required = true)
	private User user;
	
	/**
	 * 不存在不会抛异常，存在多个会抛异常
	 */
	@Autowired(required = false)
	private UserLog userLog;
	
	/**
	 * 构造方法
	 * 描述: 
	 * @author qye.zheng
	 */
	public AutowiredUserClient()
	{
	}

	/**
	 * @return the user
	 */
	public User getUser()
	{
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user)
	{
		this.user = user;
	}

	/**
	 * @return the userLog
	 */
	public UserLog getUserLog()
	{
		return userLog;
	}

	/**
	 * @param userLog the userLog to set
	 */
	public void setUserLog(UserLog userLog)
	{
		this.userLog = userLog;
	}

}
