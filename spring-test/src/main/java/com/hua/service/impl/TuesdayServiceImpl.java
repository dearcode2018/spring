/**
  * @filename TuesdayServiceImpl.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.service.impl;

import com.hua.bean.Tuesday;
import com.hua.service.TuesdayService;

 /**
 * @type TuesdayServiceImpl
 * @description 
 * @author qianye.zheng
 */
public class TuesdayServiceImpl extends CoreServiceImpl implements
		TuesdayService
{
	private Tuesday tuesday;
	
	/**
	 * 
	 * @description 
	 * @author qianye.zheng
	 */
	@Override
	public void print()
	{
		System.out.println(tuesday.getId() + ": " + tuesday.getUsername());
	}

	/**
	 * @return the tuesday
	 */
	public final Tuesday getTuesday()
	{
		return tuesday;
	}

	/**
	 * @param tuesday the tuesday to set
	 */
	public final void setTuesday(Tuesday tuesday)
	{
		this.tuesday = tuesday;
	}
	
}
