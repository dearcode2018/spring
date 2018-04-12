/**
 * 描述: 
 * PostConstructUserClient.java
 * @author	qye.zheng
 *  version 1.0
 */
package com.hua.bean.anno;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * 描述: 
 * @author  qye.zheng
 * PostConstructUserClient
 */
@Component
public final class PostConstructUserClient extends SuperPostConstructUserClient
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
	public PostConstructUserClient()
	{
		System.out.println("PostConstructUserClient.PostConstructUserClient()");
	}
	
	/**
	 * 
	 * @description 
	 * @author qye.zheng
	 */
	// 在某构造方法之后调用
	@PostConstruct
	public void setSundayBean()
	{
		System.out.println("PostConstructUserClient.setSundayBean()");
		super.setSundayBean(sundayBean);
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
