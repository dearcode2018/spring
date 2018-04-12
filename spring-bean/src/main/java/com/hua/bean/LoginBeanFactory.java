/**
 * LoginBeanFactory.java
 * @author  qye.zheng
 * 	version 1.0
 */
package com.hua.bean;

import com.hua.entity.BaseEntity;

/**
 * LoginBeanFactory
 * 描述: 
 * @author  qye.zheng
 */
public final class LoginBeanFactory extends BaseEntity
{

	private LoginBean loginBean;
	
	/**
	 * 构造方法
	 * 描述: 
	 * @author  qye.zheng
	 */
	public LoginBeanFactory()
	{
	}

	/**
	 * @return the loginBean
	 */
	public LoginBean getLoginBean()
	{
		return loginBean;
	}

	/**
	 * @param loginBean the loginBean to set
	 * 注入对象的setter方法
	 */
	public void setLoginBean(LoginBean loginBean)
	{
		this.loginBean = loginBean;
	}
	
}
