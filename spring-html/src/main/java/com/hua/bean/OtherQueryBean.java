/**
  * @filename OtherQueryBean.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;

 /**
 * @type OtherQueryBean
 * @description 
 * @author qianye.zheng
 */
@XStreamAlias("queryBean")
public class OtherQueryBean
{
	
	private Boolean flag;
	
	private String address;
	
	private Integer salary;

	/**
	 * @return the flag
	 */
	public final Boolean getFlag()
	{
		return flag;
	}

	/**
	 * @param flag the flag to set
	 */
	public final void setFlag(Boolean flag)
	{
		this.flag = flag;
	}

	/**
	 * @return the address
	 */
	public final String getAddress()
	{
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public final void setAddress(String address)
	{
		this.address = address;
	}

	/**
	 * @return the salary
	 */
	public final Integer getSalary()
	{
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public final void setSalary(Integer salary)
	{
		this.salary = salary;
	}

}
