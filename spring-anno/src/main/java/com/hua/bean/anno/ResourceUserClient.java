/**
 * 描述: 
 * ResourceUserClient.java
 * @author	qye.zheng
 *  version 1.0
 */
package com.hua.bean.anno;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

/**
 * 描述: 
 * @author  qye.zheng
 * ResourceUserClient
 */
@Component("resourceUserClient")
//@Component("resourceUserClient1")
//@Component
public final class ResourceUserClient
{
	
	//@Resource
	//@Resource(name = "sundayBean2")
	//@Resource(type = SundayBean.class)
	@Resource(name = "sundayBean", type = SundayBean.class)
	private SundayBean sundayBean;
	
	private MyLog myLog;
	
	/**
	 * 构造方法
	 * 描述: 
	 * @author qye.zheng
	 */
	public ResourceUserClient()
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
