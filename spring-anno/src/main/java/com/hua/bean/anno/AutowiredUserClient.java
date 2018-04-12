/**
 * 描述: 
 * AutowiredUserClient.java
 * @author	qye.zheng
 *  version 1.0
 */
package com.hua.bean.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 描述: 
 * @author  qye.zheng
 * AutowiredUserClient
 */
@Component
public class AutowiredUserClient
{
	/**
	 注意: 对一个类的属性实施注入，要求该类
	 必须以对象形式存在spring的ioc容器中，
	 只有存在与spring ioc容器中的对象作为一个
	 spring的一个bean，才能对其属性施加各种
	 形式的注入.
	 
	 */

	/**
	 * 不存在则会抛异常，存在多个会抛异常
	 */
	@Autowired(required = true)
	private SundayBean sundayBean;
	
	/**
	 * 不存在不会抛异常，存在多个会抛异常
	 */
	@Autowired(required = false)
	private MyLog myLog;
	
	/**
	 * 构造方法
	 * 描述: 
	 * @author qye.zheng
	 */
	public AutowiredUserClient()
	{
	}

	/**
	 * @return the sundayBean
	 */
	public final SundayBean getSundayBean() {
		return sundayBean;
	}



	/**
	 * @param sundayBean the sundayBean to set
	 */
	public final void setSundayBean(SundayBean sundayBean) {
		this.sundayBean = sundayBean;
	}

	/**
	 * @return the myLog
	 */
	public final MyLog getMyLog() {
		return myLog;
	}

	/**
	 * @param myLog the myLog to set
	 */
	public final void setMyLog(MyLog myLog) {
		this.myLog = myLog;
	}

}
