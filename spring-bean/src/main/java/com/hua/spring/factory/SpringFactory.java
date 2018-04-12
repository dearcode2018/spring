/**
 * SpringFactory.java
 * @author  qye.zheng
 * 	version 1.0
 */
package com.hua.spring.factory;

import com.hua.bean.LoginBean;

/**
 * SpringFactory
 * 描述: 自定义 spring 工厂
 * @author  qye.zheng
 */
public final class SpringFactory
{

	/**
	 spring 工厂，拥有提供多个对象的方法
	 提供对象的方法可以使静态的也可以使实例的，
	 这就决定了使用工厂的时候，是直接使用，开始
	 构造工厂对象之后，然后再调用相应的方法来获取实例.
	  
	 */
	
	/**
	 * 构造方法
	 * 描述: 
	 * @author  qye.zheng
	 */
	public SpringFactory()
	{
	}

	/**
	 * 
	 * 描述: 获取LoginBean的静态工厂方法
	 * @author  qye.zheng
	 */
	public static final LoginBean getLoginBeanStatic()
	{
		System.out.println("SpringFactory.getLoginBeanStatic()");
		
		return new LoginBean();
	}

	/**
	 * 
	 * 描述: 获取LoginBean的实例工厂方法
	 * @author  qye.zheng
	 */
	public final LoginBean getLoginBean()
	{
		System.out.println("SpringFactory.getLoginBean()");
		
		return new LoginBean();
	}

}
