/**
 * 描述: 
 * LoadPropertyStarter.java
 * @author	qye.zheng
 * 
 *  version 1.0
 */
package com.hua.starter;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hua.bean.LoadProperty;
import com.hua.util.ClassPathUtil;

/**
 * 描述: 启动器
 * @author  qye.zheng
 * 
 * LoadPropertyStarter
 */
//@Component
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:conf/xml/spring-*.xml")
public final class LoadPropertyStarter
{

	private static final String FILE_PATH = "/conf/properties/log4j.properties";
	
	@Resource
	private LoadProperty loadProperty;
	
	/* apache commons log */
	protected Log log = LogFactory.getLog(this.getClass().getName());
	
	static {
		// 初始化 log4j 环境
		PropertyConfigurator.configure(ClassPathUtil.getClassSubpath(FILE_PATH));
	}
	

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
		
		System.out.println(loadProperty.getName());
		/** ===== end of 驱动参数设置 ===== */
		//LoadProperty pro = SpringIOCUtil.getBeanFactoryOfXml().getBean(LoadProperty.class);
		//System.out.println(pro.getName());
		// 启动驱动
		//SpringIOCUtil.getBeanFactoryOfXml();
		
		//System.out.println(loadProperty);
		
	}

}
