/**
 * 描述: 
 * User.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.bean;

import java.util.Date;

import com.hua.constant.sys.UserType;

/**
 * 描述: 
 * 
 * @author qye.zheng
 * User
 */
@SuppressWarnings({"serial"})
public final class User extends BaseBean {

	/* 登录-用户名 (唯一) */
	private String username;
	
	/* 昵称 (用于显示) */
	private String nickname;
	
	/* 登录-密码 */
	private String password;
	
	/* 用户类型 */
	private UserType type;
	
	/* 用户状态 - 是否有效 默认 : 有效 */
	private boolean valid = true;
	
	/* 上一次登录-时间 */
	private Date lastLoginTime;
	
	/* 上一次登录-IP地址 */
	private String lastLoginIp;
	
	/* @Deprecated 标注的字段 */
	@Deprecated
	private String deprecatedField;
	
	/** 无参构造方法 */
	public User() {}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the type
	 */
	public UserType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(UserType type) {
		this.type = type;
	}

	/**
	 * @return the lastLoginTime
	 */
	public Date getLastLoginTime()
	{
		return lastLoginTime;
	}

	/**
	 * @param lastLoginTime the lastLoginTime to set
	 */
	public void setLastLoginTime(Date lastLoginTime)
	{
		this.lastLoginTime = lastLoginTime;
	}

	/**
	 * @return the lastLoginIp
	 */
	public String getLastLoginIp() {
		return lastLoginIp;
	}

	/**
	 * @param lastLoginIp the lastLoginIp to set
	 */
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	/**
	 * @return the nickname
	 */
	public String getNickname()
	{
		return nickname;
	}

	/**
	 * @param nickname the nickname to set
	 */
	public void setNickname(String nickname)
	{
		this.nickname = nickname;
	}

	/**
	 * @return the valid
	 */
	public boolean isValid()
	{
		return valid;
	}

	/**
	 * @param valid the valid to set
	 */
	public void setValid(boolean valid)
	{
		this.valid = valid;
	}

	/**
	 * @return the deprecatedField
	 */
	public final String getDeprecatedField()
	{
		return deprecatedField;
	}

	/**
	 * @param deprecatedField the deprecatedField to set
	 */
	public final void setDeprecatedField(String deprecatedField)
	{
		this.deprecatedField = deprecatedField;
	}
	
}
