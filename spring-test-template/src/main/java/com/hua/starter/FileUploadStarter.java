/**
 * 描述: 
 * FileUploadStarter.java
 * @author	qye.zheng
 * 
 *  version 1.0
 */
package com.hua.starter;

import org.junit.Test;

import com.hua.driver.HttpDebugDriver;

/**
 * 描述: 文件上传 - 启动器
 * @author  qye.zheng
 * 
 * FileUploadStarter
 */
public final class FileUploadStarter
{


	

	// 启动器模板
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void start()
	{
		/** ===== begin 驱动参数设置  ===== */
		// 设置例子
		
		
		/** ===== end of 驱动参数设置 ===== */

		// 启动驱动
		HttpDebugDriver.upload();
		
	}

}
