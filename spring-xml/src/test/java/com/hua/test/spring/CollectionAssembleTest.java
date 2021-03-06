/**
 * 描述: 
 * CollectionAssembleTest.java
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

import org.junit.Ignore;
import org.junit.Test;

import com.hua.bean.CompositeType;
import com.hua.test.BaseTest;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * CollectionAssembleTest
 */
public final class CollectionAssembleTest extends BaseTest {

	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testArrayAssemble() {
		try {
			beanId = "arrayCompositeType";
			/*
			  根据bean 的 id 获取bean实例化对象，getBean(String name, Class<?>)
			  name 可以使bean id 或 name 检索值
			 */
			compositeType = beanFactory.getBean(beanId, CompositeType.class);
			
			System.out.println(compositeType.toString());
			
		} catch (Exception e) {
			log.error("testArrayAssemble =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testListAssemble() {
		try {
			beanId = "listCompositeType";
			/*
			  根据bean 的 id 获取bean实例化对象，getBean(String name, Class<?>)
			  name 可以使bean id 或 name 检索值
			 */
			compositeType = beanFactory.getBean(beanId, CompositeType.class);
			
			System.out.println(compositeType.toString());
			
		} catch (Exception e) {
			log.error("testListAssemble =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSetAssemble() {
		try {
			beanId = "setCompositeType";
			/*
			  根据bean 的 id 获取bean实例化对象，getBean(String name, Class<?>)
			  name 可以使bean id 或 name 检索值
			 */
			compositeType = beanFactory.getBean(beanId, CompositeType.class);
			
			System.out.println(compositeType.toString());
			
		} catch (Exception e) {
			log.error("testSetAssemble =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testMapAssemble() {
		try {
			beanId = "mapCompositeType";
			/*
			  根据bean 的 id 获取bean实例化对象，getBean(String name, Class<?>)
			  name 可以使bean id 或 name 检索值
			 */
			compositeType = beanFactory.getBean(beanId, CompositeType.class);
			
			System.out.println(compositeType.toString());
			
		} catch (Exception e) {
			log.error("testMapAssemble =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testPropertiesAssemble() {
		try {
			beanId = "propsCompositeType";
			/*
			  根据bean 的 id 获取bean实例化对象，getBean(String name, Class<?>)
			  name 可以使bean id 或 name 检索值
			 */
			compositeType = beanFactory.getBean(beanId, CompositeType.class);
			
			System.out.println(compositeType.toString());
			
		} catch (Exception e) {
			log.error("testPropertiesAssemble =====> ", e);
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
