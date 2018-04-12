/**
 * 描述: 
 * QualifierUserClient.java
 * @author	qye.zheng
 *  version 1.0
 */
package com.hua.bean.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * 描述: 
 * @author  qye.zheng
 * QualifierUserClient
 */
@Component
public final class QualifierUserClient
{

	@Autowired(required = true)
	@Qualifier(value = "sundayBean")
	//@Qualifier(value = "sundayBean1")
	private SundayBean sundayBean;
	
	private MyLog myLog;
	
	/**
	 * 构造方法
	 * 描述: 
	 * @author qye.zheng
	 */
	public QualifierUserClient()
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
