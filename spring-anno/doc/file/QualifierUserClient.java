/**
 * 描述: 
 * QualifierUserClient.java
 * @author	qye.zheng
 *  version 1.0
 */
package com.hua.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 描述: 
 * @author  qye.zheng
 * QualifierUserClient
 */
public final class QualifierUserClient
{

	@Autowired(required = true)
	@Qualifier(value = "user1")
	//@Qualifier(value = "user2")
	private User user;
	
	private UserLog userLog;
	
	/**
	 * 构造方法
	 * 描述: 
	 * @author qye.zheng
	 */
	public QualifierUserClient()
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
