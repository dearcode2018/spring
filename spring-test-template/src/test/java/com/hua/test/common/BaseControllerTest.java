/**
 * 描述: 
 * BaseControllerTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.common;

// 静态导入
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMultipartHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.hua.util.StringUtil;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * BaseControllerTest
 */
/*
 * 
 * @SpringJUnit4ClassRunner 运行器负责拉起 spring 环境
 * @ContextConfiguration 指定 spring配置文件，若不指定，则使用默认配置.
 */
@WebAppConfiguration(value = "src/main/webapp")
//@ContextConfiguration(locations = {"classpath:conf/xml/applicationContext.xml"})
/*
 * dispatcher-servlet.xml 放在目标项目的src/main/webapp/WEB-INF目录下
 * 无法直接放到当前项目的classpath目录下，因此需要在dispatcher-servlet.xml
 * 发生变化时，将此文件拷贝到conf/xml 目录下，所有的spring配置文件包括mvc部分，
 * 都在此处标示出来，才能正常启动mvc环境
 */
@ContextConfiguration(locations = {"classpath:applicationContext.xml",
		"classpath:spring-mvc.xml"
})
@TransactionConfiguration(defaultRollback = false)
public class BaseControllerTest extends BaseSpringTest {

	/**
	 * 引当前项目用其他项目之后，然后可以使用
	 * SpringJunitTest模板测试的其他项目
	 * 
	 * 可以使用所引用目标项目的所有资源
	 * 若引用的项目的配置与本地的冲突或无法生效，需要
	 * 将目标项目的配置复制到当前项目同一路径下
	 * 
	 */
	
	@Resource
    protected WebApplicationContext webApplicationContext; 
	
	/**
	 * 
	 * @description POST 请求
	 * @param url 服务相对url
	 * @return
	 * @author qianye.zheng
	 */
	protected MockHttpServletRequestBuilder post(final String url)
	{
		final MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post(url);
		// 构建公共参数
		buildCommonParam(requestBuilder);
		
		return requestBuilder;
	}
	
	/**
	 * 
	 * @description GET 请求
	 * @param url 服务相对url
	 * @return
	 * @author qianye.zheng
	 */
	protected MockHttpServletRequestBuilder get(final String url)
	{
		final MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(url);
		// 构建公共参数
		buildCommonParam(requestBuilder);
		
		return requestBuilder;
	}
	
	/**
	 * 
	 * @description 文件上传请求
	 * @param url 服务相对url
	 * @return
	 * @author qianye.zheng
	 */
	protected MockMultipartHttpServletRequestBuilder fileUpload(final String url)
	{
		final MockMultipartHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.fileUpload(url);
		// 构建公共参数
		buildCommonParam(requestBuilder);
		
		return requestBuilder;
	}
	
	/**
	 * 
	 * @description 执行(模拟)请求
	 * @param requestBuilder
	 * @return 返回模拟http请求对象
	 * @author qianye.zheng
	 */
	protected MockHttpServletResponse perform(final RequestBuilder requestBuilder)
	{
		// 模拟 mvc 对象，设置 WebApplicationContext，然后构建 模拟mvc对象
		final MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build(); 
		// 响应对象
		MockHttpServletResponse response = null;
		try
		{
			// mvc 结果
			MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
			// 异常对象
			final Exception exception = mvcResult.getResolvedException();
			if (null != exception && StringUtil.isNotEmpty(exception.getMessage()))
			{
				log.warn("异常信息: " + exception.getMessage());
			}
			response = mvcResult.getResponse();
		} catch (final Exception e)
		{
			log.error("perform =====> ", e);
		}
		
		return response;
	}
	
	/**
	 * 
	 * @description 构建公共参数
	 * @param requestBuilder
	 * @author qianye.zheng
	 */
	private void buildCommonParam(final MockHttpServletRequestBuilder requestBuilder)
	{
		// token 令牌
		token = "5fe7ead8-cf15-46eb-933a-8fe325b610da";
		token = "5a638b7e-d22e-4820-b2fc-9b8eb748eb0d";
		requestBuilder.param("tk", token);
		// 客户端类型0：android 1：ios
		requestBuilder.param("ct", "1");
		// 客户端版本, 要验证签名值时 需要填写正确的版本数
		requestBuilder.param("v", "5");
		// 时间戳
		requestBuilder.param("t", String.valueOf(new Date().getTime()));
		// 设备号
		//requestBuilder.param("m", "");
		// 10位随机数
		//requestBuilder.param("r", "");
		// 签名值
		//requestBuilder.param("s", "");
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void test() {
		try {
			
			
		} catch (Exception e) {
			log.error("test =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testTemp() {
		try {
			
			
		} catch (Exception e) {
			log.error("testTemp=====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testCommon() {
		try {
			
			
		} catch (Exception e) {
			log.error("testCommon =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSimple() {
		try {
			
			
		} catch (Exception e) {
			log.error("testSimple =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testBase() {
		try {
			
			
		} catch (Exception e) {
			log.error("testBase =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 解决ide静态导入消除问题 
	 * @author qye.zheng
	 * 
	 */
	@Ignore("解决ide静态导入消除问题 ")
	private void noUse() {
		String expected = null;
		String actual = null;
		Object[] expecteds = null;
		Object[] actuals = null;
		String message = null;
		
		assertEquals(expected, actual);
		assertEquals(message, expected, actual);
		assertNotEquals(expected, actual);
		assertNotEquals(message, expected, actual);
		
		assertArrayEquals(expecteds, actuals);
		assertArrayEquals(message, expecteds, actuals);
		
		assertFalse(true);
		assertTrue(true);
		assertFalse(message, true);
		assertTrue(message, true);
		
		assertSame(expecteds, actuals);
		assertNotSame(expecteds, actuals);
		assertSame(message, expecteds, actuals);
		assertNotSame(message, expecteds, actuals);
		
		assertNull(actuals);
		assertNotNull(actuals);
		assertNull(message, actuals);
		assertNotNull(message, actuals);
		
		assertThat(null, null);
		assertThat(null, null, null);
		
		fail();
		fail("Not yet implemented");
		
	}

}
