/**
 * 描述: 
 * BaseTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test;

// 静态导入
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hua.constant.O2OConstant;
import com.hua.log.BaseLog;
import com.hua.util.ReadProperties;

/**
 * 描述: 测试基类
 * 包含多个测试示例
 * 
 * @author qye.zheng
 * BaseTest
 */
//@RunWith()
public class BaseTest extends BaseLog {
	
	/** log slf4j */
	protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	public String baseUrl = "http://localhost:8080/o2o";
	
	public String url;
	
	public String prefix;
	
	/* 鉴权令牌 */
	public static String token;
	
	/* 验证码 */
	public String verifyCode = O2OConstant.VERIFY_CODE;
	
	/* 登录手机号 */
	public String loginPhone = "13918687549";
	
	public static String key = "token";
	
	public static String path = "/conf/properties/o2o-member-test.properties";
	
	/** wo: o8nL1junMv7BLR1031lm5eQsPdM4 （停用）
	 * 
	 * wo: oQqvKtwabvb3YfO1ovUjxqOhzEMs
	 */
	public static final String myWxOpenId = "oQqvKtwabvb3YfO1ovUjxqOhzEMs";
	
	/* 流水号 */
	public String code = "174";
	
	//public Integer mebId = 135945640;
	public Integer mebId = 135962924;
	
	public Integer brandId = 1;
	
	/**
	 * 
	 * 描述: [所有测试]开始之前运行
	 * @author qye.zheng
	 * 
	 */
	@BeforeClass
	public static void beforeClass() {
		System.out.println("beforeClass()");
		// 读取配置
		ReadProperties readProperties = new ReadProperties(path);
		token = readProperties.getProperty(key);
		System.out.println("=================================");
		System.out.println("token = " + token);
		System.out.println("=================================");
	}
	
	/**
	 * 
	 * 描述: [所有测试]结束之后运行
	 * @author qye.zheng
	 * 
	 */
	@AfterClass
	public static void afterClass() {
//		ProtocolParam.TOKEN_HEADER
		System.out.println("afterClass()");
	}
	
	/**
	 * 
	 * 描述: [每个测试-方法]开始之前运行
	 * @author qye.zheng
	 * 
	 */
	@Before
	public void beforeMethod() {
		//int x = 0;
		//int a = x > 0 ? 1:x==0 ? 1 : 1 ;
		System.out.println("beforeMethod()");
	}
	
	/**
	 * 
	 * 描述: [每个测试-方法]结束之后运行
	 * @author qye.zheng
	 * 
	 */
	@After
	public void afterMethod() {
		System.out.println("afterMethod()");
	}

}
