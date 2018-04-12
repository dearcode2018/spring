/**
 * 描述: 
 * UserSearchBean.java
 * @author	qye.zheng
 *  version 1.0
 */
package com.hua.bean;

import java.sql.Timestamp;

import com.hua.constant.sys.UserType;

/**
 * 描述: 
 * @author  qye.zheng
 * UserSearchBean
 */
public final class UserSearchBean
{

	/* 登录-用户名 (唯一) */
	private String username;
	
	/* 昵称 (用于显示) */
	private String nickname;
	
	/* 登录-密码 */
	private String password;
	
	/* 用户类型 */
	private UserType type;
	
	/* 用户状态 - 是否有效 默认 : 有效 */
	private boolean isValid;
	
	/* 开始 - 上一次登录-时间 */
	private Timestamp startLastLoginTime;
	
	/* 结束 - 上一次登录-时间 */
	private Timestamp endLastLoginTime;
	
	/* 上一次登录-IP地址 */
	private String lastLoginIp;
	
	/**
	 * 构造方法
	 * 描述: 
	 * @author qye.zheng
	 */
	public UserSearchBean()
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
	 * @return the nickname
	 */
	public final String getNickname()
	{
		return nickname;
	}

	/**
	 * @param nickname the nickname to set
	 */
	public final void setNickname(String nickname)
	{
		this.nickname = nickname;
	}

	/**
	 * @return the password
	 */
	public final String getPassword()
	{
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public final void setPassword(String password)
	{
		this.password = password;
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
	 * @return the isValid
	 */
	public final boolean isValid()
	{
		return isValid;
	}

	/**
	 * @param isValid the isValid to set
	 */
	public final void setValid(boolean isValid)
	{
		this.isValid = isValid;
	}

	/**
	 * @return the startLastLoginTime
	 */
	public final Timestamp getStartLastLoginTime()
	{
		return startLastLoginTime;
	}

	/**
	 * @param startLastLoginTime the startLastLoginTime to set
	 */
	public final void setStartLastLoginTime(Timestamp startLastLoginTime)
	{
		this.startLastLoginTime = startLastLoginTime;
	}

	/**
	 * @return the endLastLoginTime
	 */
	public final Timestamp getEndLastLoginTime()
	{
		return endLastLoginTime;
	}

	/**
	 * @param endLastLoginTime the endLastLoginTime to set
	 */
	public final void setEndLastLoginTime(Timestamp endLastLoginTime)
	{
		this.endLastLoginTime = endLastLoginTime;
	}

	/**
	 * @return the lastLoginIp
	 */
	public final String getLastLoginIp()
	{
		return lastLoginIp;
	}

	/**
	 * @param lastLoginIp the lastLoginIp to set
	 */
	public final void setLastLoginIp(String lastLoginIp)
	{
		this.lastLoginIp = lastLoginIp;
	}

}
