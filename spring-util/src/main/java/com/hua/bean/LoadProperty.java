/**
  * @filename LoadProperty.java
  * @description  
  * @version 1.0
  * @author qye.zheng
 */
package com.hua.bean;

import org.springframework.beans.factory.annotation.Value;

 /**
 * @type LoadProperty
 * @description  
 * @author qye.zheng
 */
@SuppressWarnings({"serial"})
public final class LoadProperty extends BaseBean{
	
	/**
	 * 可以使用 spring Value注解来
	 * 直接注入
	 */
	
	//@Value("${spring.bean}")
	private String beanValue;
	
	//@Value("${spring.bean}")
	private String contextValue;
	
	//@Value("#{utilLoadProperties['spring.util']}")
	private String utilValue;

	/**
	 * @return the beanValue
	 */
	public final String getBeanValue() {
		return beanValue;
	}

	/**
	 * @param beanValue the beanValue to set
	 */
	public final void setBeanValue(String beanValue) {
		this.beanValue = beanValue;
	}

	/**
	 * @return the contextValue
	 */
	public final String getContextValue() {
		return contextValue;
	}

	/**
	 * @param contextValue the contextValue to set
	 */
	public final void setContextValue(String contextValue) {
		this.contextValue = contextValue;
	}

	/**
	 * @return the utilValue
	 */
	public final String getUtilValue() {
		return utilValue;
	}

	/**
	 * @param utilValue the utilValue to set
	 */
	public final void setUtilValue(String utilValue) {
		this.utilValue = utilValue;
	}
	
}
