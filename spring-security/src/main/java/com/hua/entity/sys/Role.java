/**
  * @filename Role.java
  * @description  
  * @version 1.0
  * @author qye.zheng
 */
package com.hua.entity.sys;

import com.hua.entity.BaseEntity;

 /**
 * @type Role
 * @description  
 * @author qye.zheng
 */
public final class Role extends BaseEntity
{
	/* 角色名称 */
	private String name;
	
	/* 帐号是否有权限 1-有, 0无 */
	private String enabled;

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
	 * @return the enabled
	 */
	public final String getEnabled()
	{
		return enabled;
	}

	/**
	 * @param enabled the enabled to set
	 */
	public final void setEnabled(String enabled)
	{
		this.enabled = enabled;
	}
	
}
