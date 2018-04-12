/**
 * AutowireBean.java
 * @author  qye.zheng
 * 	version 1.0
 */
package com.hua.bean;


/**
 * AutowireBean
 * 描述: 
 * @author  qye.zheng
 */
public final class AutowireBean
{

	private UserBean userBean;
	
	/**
	 * 构造方法
	 * 描述: 
	 * @author  qye.zheng
	 */
	public AutowireBean()
	{
	}

	/**
	 * @return the userBean
	 */
	public UserBean getUserBean()
	{
		return userBean;
	}

	/**
	 * @param userBean the userBean to set
	 * 对象注入方法
	 */
	public void setUserBean(UserBean userBean)
	{
		this.userBean = userBean;
	}

}
