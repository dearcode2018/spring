/**
  * @filename Resource.java
  * @description  
  * @version 1.0
  * @author qye.zheng
 */
package com.hua.entity.sys;

import com.hua.entity.BaseEntity;

 /**
 * @type Resource
 * @description  
 * @author qye.zheng
 */
public final class Resource extends BaseEntity
{
	/* 权限唯一编码 */
	private String code;
	
	/* 权限类型 */
	private String type;
	
	/* 资源对应的url */	
	private String url;

	/* 优先级 */
	private int priority;
	
	/*  */
	private String remark;

	/**
	 * @return the code
	 */
	public final String getCode()
	{
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public final void setCode(String code)
	{
		this.code = code;
	}

	/**
	 * @return the type
	 */
	public final String getType()
	{
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public final void setType(String type)
	{
		this.type = type;
	}

	/**
	 * @return the url
	 */
	public final String getUrl()
	{
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public final void setUrl(String url)
	{
		this.url = url;
	}

	/**
	 * @return the priority
	 */
	public final int getPriority()
	{
		return priority;
	}

	/**
	 * @param priority the priority to set
	 */
	public final void setPriority(int priority)
	{
		this.priority = priority;
	}

	/**
	 * @return the remark
	 */
	public final String getRemark()
	{
		return remark;
	}

	/**
	 * @param remark the remark to set
	 */
	public final void setRemark(String remark)
	{
		this.remark = remark;
	}
	
	
}
