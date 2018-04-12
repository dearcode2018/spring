/**
  * @filename SimplePersonSearchBean.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAliasType;

 /**
 * @type SimplePersonSearchBean
 * @description 
 * @author qianye.zheng
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@SuppressWarnings({"serial"})
// 用 XStream 来解析 xml请求参数 或 生成 xml数据
/*
 * 使用 @XStreamAlias 或 @XStreamAliasType 标注,且在spring-mvc
 * 配置文件中 xstreamMarshaller 使用 annotatedClasses属性将该类型
 * 配置上去, 两个同时做才有效, 但是输出xml格式的时候是无须在 spring配置
 * 中配置, 只有 请求参数是xml格式才需要在xml配置文件中额外配置.
 * 因为spring mvc在解析xml参数时, 不是直接获取和检查具体某个方法的参数类型及其
 * xml实体标注的注解, 而是依赖在配置文件中显式声明annotatedClasses, 在unmarshaller时
 * 需要特别注意一定要同时用注解标注其别名和在配置文件中进行配置.
 */
//@XStreamAlias(value = "simplePersonSearchBean")
@XStreamAliasType(value = "simplePersonSearchBean")
public class SimplePersonSearchBean extends BaseBean
{
	 /* long */
	//private static final long serialVersionUID = -5368102181711261710L;
	
	//@XStreamAlias(value = "name")
	private String name;
	
	//@XStreamAlias(value = "password")
	private String password;

	/**
	 * @description 构造方法
	 * @author qianye.zheng
	 */
	public SimplePersonSearchBean()
	{
	}
	
	/**
	 * @description 构造方法
	 * @param name
	 * @param password
	 * @author qianye.zheng
	 */
	public SimplePersonSearchBean(String name, String password)
	{
		super();
		this.name = name;
		this.password = password;
	}



	/**
	 * @return the name
	 */
	public final String getName()
	{
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public final void setName(String name)
	{
		this.name = name;
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
	
}
