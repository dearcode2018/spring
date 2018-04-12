/**
 * LoginBean.java
 * @author  qye.zheng
 * 	version 1.0
 */
package com.hua.bean;

import java.sql.Time;

/**
 * LoginBean
 * 描述: 
 * @author  qye.zheng
 */
public final class LoginBean
{
	/* 登录-用户名 */
	private String username;
	
	/* 登录-密码 */
	private String password;
	
	/* 本次登录-时间 */
	private Time loginTime;
	
	/* 本次登录-IP地址 */
	private String loginIp;

	/**
	 * 构造方法
	 * 描述: 
	 * @author  qye.zheng
	 */
	public LoginBean()
	{
	}
	
	/**
	 * 
	 * 描述:  给Bean配置中，指定的初始化方法
	 * 由于配置中不能接受参数，因此该方法无参
	 * 可以有返回值
	 * 静态/实例方法都可以，如果是单例，则可声明为静态方法
	 * @author  qye.zheng
	 * @return
	 */
	public boolean init()
	{
		System.out.println("LoginBean.init()");
		
		return true;
	}

	/**
	 * 
	 * 描述:  给Bean配置中，指定的销毁方法
	 * 由于配置中不能接受参数，因此该方法无参
	 * 可以有返回值
	 * 静态/实例方法都可以，如果是单例，则可声明为静态方法
	 * @author  qye.zheng
	 * @return
	 */
	public boolean destroy()
	{
		System.out.println("LoginBean.destroy()");
		
		return true;
	}
	
	/**
	 * @return the username
	 */
	public String getUsername()
	{
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username)
	{
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword()
	{
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password)
	{
		this.password = password;
	}

	/**
	 * @return the loginTime
	 */
	public Time getLoginTime()
	{
		return loginTime;
	}

	/**
	 * @param loginTime the loginTime to set
	 */
	public void setLoginTime(Time loginTime)
	{
		this.loginTime = loginTime;
	}

	/**
	 * @return the loginIp
	 */
	public String getLoginIp()
	{
		return loginIp;
	}

	/**
	 * @param loginIp the loginIp to set
	 */
	public void setLoginIp(String loginIp)
	{
		this.loginIp = loginIp;
	}

}
