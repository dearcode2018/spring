/**
  * @filename MondayImpl.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.service.impl;

import org.springframework.stereotype.Service;

import com.hua.service.Monday;

/**
 * @type MondayImpl
 * @description 
 * @author qianye.zheng
 */
@Service
public class MondayImpl extends CoreServiceImpl implements Monday
{

	/**
	 * @description 
	 * @author qianye.zheng
	 */
	@Override
	public void go()
	{
		System.out.println("MondayImpl.go()");
	}

	/**
	 * 
	 * @description 
	 * @author qianye.zheng
	 */
	public void local()
	{
		System.out.println("MondayImpl.local()");
	}
	
}
