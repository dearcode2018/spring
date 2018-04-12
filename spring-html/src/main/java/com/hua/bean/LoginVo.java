/**
  * @filename LoginVo.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.bean;


 /**
 * @type LoginVo
 * @description 
 * @author qianye.zheng
 */
public class LoginVo
{
	/* 登录-用户名 (唯一) */
	private String username;
	
	/* 昵称 (用于显示) */
	private String nickname;
	
	/* 用户状态 - 是否有效 默认 : 有效 */
	private boolean valid = true;

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
	 * @return the valid
	 */
	public final boolean isValid()
	{
		return valid;
	}

	/**
	 * @param valid the valid to set
	 */
	public final void setValid(boolean valid)
	{
		this.valid = valid;
	}
	
}
