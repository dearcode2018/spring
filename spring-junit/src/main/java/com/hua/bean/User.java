/**
 * 描述: 
 * User.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.bean;

import java.sql.Timestamp;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.hua.constant.sys.UserType;

/**
 * 描述: 
 * 
 * @author qye.zheng
 * User
 */
public final class User extends BaseBean{

	private static final long serialVersionUID = 1L;

	/* 登录-用户名 (唯一) */
	private String username;
	
	/* 昵称 (用于显示) */
	private String nickname;
	
	/* 登录-密码 */
	private String password;
	
	/* 用户类型 */
	private UserType type;
	
	/* 用户状态 - 是否有效 默认 : 有效 */
	/*
	 注意，命名布尔类型的时候，属性命名不应该
	 调用is前缀，这是留个get使用的，反射需要根据
	 javabean规则去调用其方法
	 */
	private boolean valid = true;
	
	/* 上一次登录-时间 */
	private Timestamp lastLoginTime;
	
	/* 上一次登录-IP地址 */
	private String lastLoginIp;
	
	/** 无参构造方法 */
	public User() {}
	
	/**
	 * 构造方法
	 * 描述: 
	 * @author  qye.zheng
	 * @param username
	 * @param password
	 */
	public User(String username, String password)
	{
		super();
		this.username = username;
		this.password = password;
	}

	/**
	 * 构造方法
	 * 描述: 
	 * @author  qye.zheng
	 * @param username
	 * @param password
	 * @param isValid
	 */
	public User(String username, String password, boolean valid)
	{
		super();
		this.username = username;
		this.password = password;
		this.valid = valid;
	}

	/**
	 * 构造方法
	 * 描述: 
	 * @author  qye.zheng
	 * @param username
	 * @param isValid
	 */
	public User(String username, boolean valid)
	{
		super();
		this.username = username;
		this.valid = valid;
	}

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
	public Timestamp getLastLoginTime()
	{
		return lastLoginTime;
	}

	/**
	 * @param lastLoginTime the lastLoginTime to set
	 */
	public void setLastLoginTime(Timestamp lastLoginTime)
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
	 * 描述: 
	 * @author  qye.zheng
	 * @return
	 */
	@Override
	public String toString()
	{
		final String result = new ReflectionToStringBuilder(this).toString();
		
		return result;
	}
	
}
