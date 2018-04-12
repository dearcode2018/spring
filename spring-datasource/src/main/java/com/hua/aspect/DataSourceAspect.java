/**
  * @filename DataSourceAspect.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

import com.hua.datasource.DatabaseContextHolder;

 /**
 * @type DataSourceAspect
 * @description 数据源AOP(DataSourceAspect)应该在动态数据源路由(DynamicDataSource)之前执行
 * @author qianye.zheng
 */
// 注意，这里应该标注为组件Component而不是Aspect
//@Aspect
//@Component
public class DataSourceAspect
{
	
	/* 区分拦截子类 的包路径前缀 */
	private List<String> subPackages;
	
	/**
	 * 
	 * @description 
	 * @author qianye.zheng
	 */
	public void setDataSource(final JoinPoint jp)
	{
		System.out.println("1.DataSourceAspect.setDataSource()");
		// 判断是哪个包下的，然后决定调用哪个方法
		final String subPackage = jp.getTarget().getClass().getPackage().getName();
		//System.out.println(jp.getTarget().getClass().getPackage().getName());
		final int index = index(subPackage);
		switch (index)
		{
			case 0:
				setDataSource01(jp);
				break;
			case 1:
				setDataSource02(jp);
				break;
			case 2:
				setDataSource03(jp);
				break;	
				
			// 使用默认的数据源
			default:
				break;
		}
	}
	
	/**
	 * 
	 * @description 
	 * @author qianye.zheng
	 */
	public void setDataSource01(final JoinPoint jp)
	{
		System.out.println("1.DataSourceAspect.setDataSource01()");
		DatabaseContextHolder.setCustomerType("dataSource_01");
	}
	
	/**
	 * 
	 * @description 
	 * @author qianye.zheng
	 */
	public void setDataSource02(final JoinPoint jp)
	{
		System.out.println("1.DataSourceAspect.setDataSource02()");
		DatabaseContextHolder.setCustomerType("dataSource_02");
	}
	
	/**
	 * 
	 * @description 
	 * @author qianye.zheng
	 */
	public void setDataSource03(final JoinPoint jp)
	{
		System.out.println("1.DataSourceAspect.setDataSource03()");
		DatabaseContextHolder.setCustomerType("dataSource_03");
	}

	/**
	 * @param subPackages the subPackages to set
	 */
	public final void setSubPackages(List<String> subPackages)
	{
		this.subPackages = subPackages;
	}
	
	/**
	 * 
	 * @description 
	 * @param subPackage
	 * @return
	 * @author qianye.zheng
	 */
	private int index(final String subPackage)
	{
		for (int i = 0; i < subPackages.size(); i++)
		{
			if (subPackage.startsWith(subPackages.get(i)))
			{
				return i;
			}
		}
		
		return -1;
	}
	
}
