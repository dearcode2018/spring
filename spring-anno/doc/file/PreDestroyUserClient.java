/**
 * 描述: 
 * PreDestroyUserClient.java
 * @author	qye.zheng
 *  version 1.0
 */
package com.hua.bean;

import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 描述: 
 * @author  qye.zheng
 * PreDestroyUserClient
 */
public final class PreDestroyUserClient
{

	@Autowired(required = true)
	@Qualifier(value = "user1")
	private User user;
	
	private UserLog userLog;
	
	/**
	 * 构造方法
	 * 描述: 
	 * @author qye.zheng
	 */
	public PreDestroyUserClient()
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
	
	
	/**
	 * 
	 * 描述: 类销毁之前调用
	 * @author qye.zheng
	 */
	@PreDestroy
	public static void destroy()
	{
		System.out.println("PreDestroyUserClient.destroy()");
	}

}
