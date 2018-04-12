/**
  * @filename MondayServiceImpl.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hua.bean.Monday;
import com.hua.service.MondayService;

 /**
 * @type MondayServiceImpl
 * @description 
 * @author qianye.zheng
 */
@Service
public class MondayServiceImpl extends CoreServiceImpl implements MondayService
{

	@Resource
	private Monday monday;
	
	/**
	 * 
	 * @description 
	 * @author qianye.zheng
	 */
	@Override
	public void print()
	{
		System.out.println(monday.getId() + ": " + monday.getUsername());
	}

	/**
	 * @return the monday
	 */
	public final Monday getMonday()
	{
		return monday;
	}

	/**
	 * @param monday the monday to set
	 */
	public final void setMonday(Monday monday)
	{
		this.monday = monday;
	}

}
