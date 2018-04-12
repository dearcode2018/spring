/**
 * 描述: 
 * Person.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.bean;

import java.sql.Timestamp;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hua.serializer.DateSerializer;
import com.hua.serializer.DateTimeSerializer;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * 描述: 
 * 
 * @author qye.zheng
 * Person
 */
// 若不设置该值, 在ResultBean 的 data中 显示  <data class="com.hua.bean.Person">
//@XStreamAlias("person")
@JsonIgnoreProperties(ignoreUnknown = true)
//@XStreamAliasType("person_")
public class Person extends BaseBean {

	 /* long */
	private static final long serialVersionUID = 1L;
	
	/* 登录-用户名 (唯一) */
	private String username;
	
	/*
	 * @XStreamAsAttribute 标注该字段序列化为一个属性
	 */
	/* 昵称 (用于显示) */
	//@XStreamAsAttribute
	private String nickname;
	
	/* 登录-密码 */
	private String password;
	
	/* 用户类型 枚举类型无法解析成功, 原因未知 */
	//private UserType type;
	
	/* 用户状态 - 是否有效 默认 : 有效 */
	private boolean valid = true;
	
	/* 上一次登录-时间 */
	@JsonSerialize(using = DateTimeSerializer.class)
	//@JsonDeserialize(using = DateTimeDeserializer.class)
	private Timestamp lastLoginTime;
	
	/* 上一次登录-IP地址 */
	private String lastLoginIp;
	
	@JsonSerialize(using = DateTimeSerializer.class)
	//@JsonDeserialize(using = DateTimeDeserializer.class)
	private Date utilDate;
	
	@JsonSerialize(using = DateSerializer.class)
	//@JsonDeserialize(using = DateDeserializer.class)
	private java.sql.Date sqlDate;
	
	/** 无参构造方法 */
	public Person() {}

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
	 * @return the utilDate
	 */
	public final Date getUtilDate()
	{
		return utilDate;
	}

	/**
	 * @param utilDate the utilDate to set
	 */
	public final void setUtilDate(Date utilDate)
	{
		this.utilDate = utilDate;
	}

	/**
	 * @return the sqlDate
	 */
	public final java.sql.Date getSqlDate()
	{
		return sqlDate;
	}

	/**
	 * @param sqlDate the sqlDate to set
	 */
	public final void setSqlDate(java.sql.Date sqlDate)
	{
		this.sqlDate = sqlDate;
	}

}
