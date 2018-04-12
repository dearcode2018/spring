/**
  * @filename SpringConfigBean.java
  * @description 
  * @version 1.0
  * @author qye.zheng
 */
package com.hua.bean;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

 /**
 * @type SpringConfigBean
 * @description 
 * @author qye.zheng
 */
public class SpringConfigBean {

	private String name;
	
	private Integer age;
	
	private String address;
	
	/**
	 * 尝试 解析 properties 文件中 逗号分隔符隔开的多个值
	 */
	/* 数组 */
	private String[] nicknames;

	/**
	 * @return the name
	 */
	public final String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public final void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public final Integer getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public final void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * @return the address
	 */
	public final String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public final void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the nicknames
	 */
	public final String[] getNicknames() {
		return nicknames;
	}

	/**
	 * @param nicknames the nicknames to set
	 */
	public final void setNicknames(String[] nicknames) {
		this.nicknames = nicknames;
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
