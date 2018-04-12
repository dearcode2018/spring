/**
 * 描述: 
 * ResourceAnnotationTest.java
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

import com.hua.bean.anno.ResourceUserClient;
import com.hua.test.BaseTest;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * ResourceAnnotationTest
 */
//for Junit 4.x
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:conf/xml/applicationContext.xml"})
@ContextConfiguration(locations = {"classpath:conf/xml/spring-annotation.xml"})
public final class ResourceAnnotationTest extends BaseTest {

	/**
	 
	 javax.annotation.Resource
	 
	 @Resource
	 
	 spring对java官方注解的支持
	 1) 同时指定 name 和 type，则匹配唯一bean，等同于@Autowired 和 @Qualifier 
	 协同使用用，这种方式可以显式避免存在多个实例bean的情况下，明确指定
	 使用哪个一个.
	 2) 指定name，根据name在容器中寻找bean
	 3) 指定type，根据type去寻找，存在多个类型则抛异常
	 4) 都不指定，则先按照byName方式，没有则回退为按照
	 原始类型(byType)去匹配.
	 
	 */
	
	//@Resource(name = "resourceUserClient1")
	//@Resource(name = "resourceUserClient")
	@Resource
	private ResourceUserClient resourceUserClient;
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testResource() {
		try {
			
			log.info("testResource =====> " + resourceUserClient.getSundayBean().getNickname());
			
		} catch (Exception e) {
			log.error("testResource =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 不指定name和type，自动检测
	 * 先名称后类型
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testResourceAutoDetect() {
		try {
			
			log.info("testResourceAutoDetect =====> " + resourceUserClient.getSundayBean().getNickname());
			
		} catch (Exception e) {
			log.error("testResourceAutoDetect =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testResourceByName() {
		try {
			
			log.info("testResourceByName =====> " + resourceUserClient.getSundayBean().getNickname());
			
			
		} catch (Exception e) {
			log.error("testResourceByName =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testResourceByType() {
		try {
			
			log.info("testResourceByType =====> " + resourceUserClient.getSundayBean().getNickname());
	
			
		} catch (Exception e) {
			log.error("testResourceByType =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testResourceByNameByType() {
		try {
			
			log.info("testResourceByNameByType =====> " + resourceUserClient.getSundayBean().getNickname());
	
			
		} catch (Exception e) {
			log.error("testResourceByNameByType =====> ", e);
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
