/**
 * 描述: 
 * MyLog.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.bean.anno;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

import com.hua.bean.BaseBean;
import com.hua.constant.sys.UserType;
import com.hua.util.DateTimeUtil;

/**
 * 描述: 用户日志
 * 
 * @author qye.zheng
 * MyLog
 */
@Component
public final class MyLog extends BaseBean {

	 /* long */
	private static final long serialVersionUID = 1L;
	
	/* 登录-用户名 */
	private String username = "system";
	
	/* 用户类型 */
	private UserType type;
	
	/* 本次登录-时间 */
	private Timestamp loginTime = DateTimeUtil.getTimestamp();
	
	/* 本次登录-IP地址 */
	private String loginIp;
	
	/** 无参构造方法 */
	public MyLog() {}

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
	 * @return the loginTime
	 */
	public Timestamp getLoginTime()
	{
		return loginTime;
	}

	/**
	 * @param loginTime the loginTime to set
	 */
	public void setLoginTime(Timestamp loginTime)
	{
		this.loginTime = loginTime;
	}

	/**
	 * @return the loginIp
	 */
	public String getLoginIp() {
		return loginIp;
	}

	/**
	 * @param loginIp the loginIp to set
	 */
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
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
	
}
