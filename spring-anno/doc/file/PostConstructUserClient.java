/**
 * 描述: 
 * PostConstructUserClient.java
 * @author	qye.zheng
 *  version 1.0
 */
package com.hua.bean;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 描述: 
 * @author  qye.zheng
 * PostConstructUserClient
 */
public final class PostConstructUserClient extends SuperPostConstructUserClient
{
	@Autowired(required = true)
	@Qualifier(value = "user2")
	private User user;
	
	private UserLog userLog;
	
	/**
	 * 构造方法
	 * 描述: 
	 * @author qye.zheng
	 */
	public PostConstructUserClient()
	{
	}
	
	@PostConstruct
	public void setSuperUser()
	{
		super.setUser(user);
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
