/**
  * @filename DatabaseContextHolder.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.datasource;

 /**
 * @type DatabaseContextHolder
 * @description 
 * @author qianye.zheng
 */
public class DatabaseContextHolder
{
	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();
	
	/**
	 * 
	 * @description 
	 * @param customerType
	 * @author qianye.zheng
	 */
	public static void setCustomerType(final String customerType)
	{
		contextHolder.set(customerType);
	}
	
	/**
	 * 
	 * @description 
	 * @return
	 * @author qianye.zheng
	 */
	public static String getCustomerType()
	{
		return contextHolder.get();
	}
	
	/**
	 * 
	 * @description 
	 * @return
	 * @author qianye.zheng
	 */
	public static void clearCustomerType()
	{
		contextHolder.remove();
	}
}
