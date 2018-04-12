/**
 * 描述: 
 * ComponentEntity.java
 * @author	qye.zheng
 *  version 1.0
 */
package com.hua.bean.anno;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

import com.hua.constant.sys.UserType;
import com.hua.util.DateTimeUtil;

/**
 * 描述: 
 * @author  qye.zheng
 * ComponentEntity
 */
@Component(value = "componentEntity")
public class ComponentEntity
{
	/* 登录-用户名 */
	private String username = "system";
	
	/* 用户类型 */
	private UserType type;
	
	/* 本次登录-时间 */
	private Timestamp loginTime = DateTimeUtil.getTimestamp();
	
	/* 本次登录-IP地址 */
	private String loginIp;
	
	/**
	 * 构造方法
	 * 描述: 
	 * @author qye.zheng
	 */
	public ComponentEntity()
	{
	}

	/**
	 * @return the username
	 */
	public final String getUsername()
	{
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public final void setUsername(String username)
	{
		this.username = username;
	}

	/**
	 * @return the type
	 */
	public final UserType getType()
	{
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public final void setType(UserType type)
	{
		this.type = type;
	}

	/**
	 * @return the loginTime
	 */
	public final Timestamp getLoginTime()
	{
		return loginTime;
	}

	/**
	 * @param loginTime the loginTime to set
	 */
	public final void setLoginTime(Timestamp loginTime)
	{
		this.loginTime = loginTime;
	}

	/**
	 * @return the loginIp
	 */
	public final String getLoginIp()
	{
		return loginIp;
	}

	/**
	 * @param loginIp the loginIp to set
	 */
	public final void setLoginIp(String loginIp)
	{
		this.loginIp = loginIp;
	}
	
}
