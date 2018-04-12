/**
 * 描述: 
 * PreDestroyUserClient.java
 * @author	qye.zheng
 *  version 1.0
 */
package com.hua.bean.anno;

import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * 描述: 
 * @author  qye.zheng
 * PreDestroyUserClient
 */
@Component
public final class PreDestroyUserClient
{

	@Autowired(required = true)
	@Qualifier(value = "sundayBean")
	private SundayBean sundayBean;
	
	private MyLog myLog;
	
	/**
	 * 构造方法
	 * 描述: 
	 * @author qye.zheng
	 */
	public PreDestroyUserClient()
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

	/**
	 * 
	 * 描述: 类销毁之前调用
	 * @author qye.zheng
	 */
	@PreDestroy
	public static void destroy()
	{
		System.out.println("PreDestroyUserClient.destroy()");
	}

}
