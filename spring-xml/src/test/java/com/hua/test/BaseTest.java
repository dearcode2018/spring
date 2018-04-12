/**
 * 描述: 
 * BaseTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test;

// 静态导入

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.springframework.beans.factory.BeanFactory;

import com.hua.bean.CompositeType;
import com.hua.bean.LoginBean;
import com.hua.bean.User;
import com.hua.log.BaseLog;
import com.hua.util.SpringUtil;

/**
 * 描述: 测试基类
 * 包含多个测试示例
 * 
 * @author qye.zheng
 * BaseTest
 */
//@RunWith()
public class BaseTest extends BaseLog {
	
	public static BeanFactory beanFactory;
	
	public String beanId;
	
	public User user;
	
	public LoginBean loginBean;
	
	public CompositeType compositeType;
	
	/**
	 * 
	 * 描述: [所有测试]开始之前运行
	 * @author qye.zheng
	 * 
	 */
	@BeforeClass
	public static void beforeClass() {
		System.out.println("beforeClass()");
		// 启动 ioc 容器
		beanFactory = SpringUtil.getBeanFactoryOfXml();
	}
	
	/**
	 * 
	 * 描述: [所有测试]结束之后运行
	 * @author qye.zheng
	 * 
	 */
	@AfterClass
	public static void afterClass() {
		System.out.println("afterClass()");
		// 销毁容器
		if (null != beanFactory)
		{
			SpringUtil.destroy(beanFactory);
		}
	}

}
