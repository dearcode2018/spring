/**
 * 描述: 
 * PersonSearchBean.java
 * @author qye.zheng
 * 
 *  version 1.0
 */
package com.hua.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.thoughtworks.xstream.annotations.XStreamAlias;


/**
 * 描述: 
 * @author qye.zheng
 * 
 * PersonSearchBean
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@SuppressWarnings({"serial"})
// 用 XStream 来解析 xml请求参数 或 生成 xml数据
@XStreamAlias("personSearchBean")
public class PersonSearchBean extends BaseBean
{
	private String name;
	
	private String password;
	
	//@XStreamAlias("dtBetween")
	private DateTimeBetween dtBetween;
	
	//@XStreamAlias("queryBean")
	private OtherQueryBean queryBean;

	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
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
	 * @return the dtBetween
	 */
	public final DateTimeBetween getDtBetween()
	{
		return dtBetween;
	}

	/**
	 * @param dtBetween the dtBetween to set
	 */
	public final void setDtBetween(DateTimeBetween dtBetween)
	{
		this.dtBetween = dtBetween;
	}

	/**
	 * @return the queryBean
	 */
	public final OtherQueryBean getQueryBean()
	{
		return queryBean;
	}

	/**
	 * @param queryBean the queryBean to set
	 */
	public final void setQueryBean(OtherQueryBean queryBean)
	{
		this.queryBean = queryBean;
	}
	
}
