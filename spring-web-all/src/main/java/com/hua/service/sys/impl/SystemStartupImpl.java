/**
  * @filename SystemStartupImpl.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.service.sys.impl;

import javax.servlet.ServletContext;

import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;

import com.hua.service.impl.CoreServiceImpl;
import com.hua.service.sys.SystemStartup;

 /**
 * @type SystemStartupImpl
 * @description 
 * @author qianye.zheng
 */
//@Service
public class SystemStartupImpl extends CoreServiceImpl implements SystemStartup
{

	/**
	 * @description 
	 * @param bean
	 * @param beanName
	 * @return
	 * @throws BeansException
	 * @author qianye.zheng
	 */
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException
	{
		System.out
				.println("SystemStartupImpl.postProcessBeforeInitialization()");
		return bean;
	}

	/**
	 * @description 
	 * @param bean
	 * @param beanName
	 * @return
	 * @throws BeansException
	 * @author qianye.zheng
	 */
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException
	{
		return bean;
	}

/*	*//**
	 * @description 
	 * @throws Exception
	 * @author qianye.zheng
	 *//*
	@Override
	public void afterPropertiesSet() throws Exception
	{
		System.out.println("SystemStartupImpl.afterPropertiesSet()");
		log.info("afterPropertiesSet =====> 系统启动...");
	}

	*//**
	 * @description 
	 * @param servletContext
	 * @author qianye.zheng
	 *//*
	@Override
	public void setServletContext(ServletContext servletContext)
	{
		System.out.println("SystemStartupImpl.setServletContext()");
	}*/

}
