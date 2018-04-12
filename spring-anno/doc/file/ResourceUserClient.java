/**
 * 描述: 
 * ResourceUserClient.java
 * @author	qye.zheng
 *  version 1.0
 */
package com.hua.bean;

import javax.annotation.Resource;

/**
 * 描述: 
 * @author  qye.zheng
 * ResourceUserClient
 */
public final class ResourceUserClient
{
	//@Resource
	//@Resource(name = "user2")
	//@Resource(type = User.class)
	@Resource(name = "user1", type = User.class)
	private User user;
	
	private UserLog userLog;
	
	/**
	 * 构造方法
	 * 描述: 
	 * @author qye.zheng
	 */
	public ResourceUserClient()
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
