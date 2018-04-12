/**
 * 描述: 
 * AutowiredAnnotationTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.spring;

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

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hua.bean.anno.AutowiredUserClient;
import com.hua.bean.anno.SundayBean;
import com.hua.test.BaseTest;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * AutowiredAnnotationTest
 */
//for Junit 4.x
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:conf/xml/applicationContext.xml"})
@ContextConfiguration(locations = {"classpath:conf/xml/spring-annotation.xml"})
public final class AutowiredAnnotationTest extends BaseTest {
	
	/**
	 @Autowired注解(不推荐使用，建议使用@Resource)
	 org.springframework.beans.factory.annotation.Autowired
	 required 默认是 true
	 @Autowired(required = true)
	 
	 @Autowired可以对成员变量、方法和构造函数进行标注，来完成自动装配的工作。
	 
	 @Autowired是根据类型进行自动装配的.
	 存在多个同一类型的bean时会抛出BeanCreationException异常.
	 
	 required = true 不存在则会抛异常，存在多个会抛异常
	 required = false 不存在不会抛异常，存在多个会抛异常
	 
	 @Autowired 方式的装配，根据类型来进行装配，比较适合单例下的装配.
	 
	 */
	
	@Resource
	private SundayBean sundayBean;
	
	@Resource
	private AutowiredUserClient autowiredUserClient;
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testAutowired() {
		try {
			
			log.info("testAutowired =====> " + sundayBean);
			
			log.info("testAutowired =====> " + autowiredUserClient.getSundayBean());
			
		} catch (Exception e) {
			log.error("testAutowired =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testAutowiredRequired() {
		try {
			
			log.info("testAutowired =====> " + autowiredUserClient.getSundayBean().getNickname());
			
		} catch (Exception e) {
			log.error("testAutowiredRequired =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testAutowiredNotRequired() {
		try {
			
			log.info("testAutowired =====> " + autowiredUserClient.getMyLog().getLoginIp());
			
		} catch (Exception e) {
			log.error("testAutowiredNotRequired =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 同一个类型1个bean
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testAutowiredOne() {
		try {
			
			log.info("testAutowired =====> " + autowiredUserClient.getSundayBean().getNickname());
			
		} catch (Exception e) {
			log.error("testAutowiredOne =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 同一个类型多个bean
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testAutowiredMultiple() {
		try {
			/*
			 Autowired 根据类型来实施装配，发现多个
			 则会抛异常
			 */
			
			log.info("testAutowired =====> " + autowiredUserClient.getSundayBean().getNickname());
			
		} catch (Exception e) {
			log.error("testAutowiredMultiple =====> ", e);
		}
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
