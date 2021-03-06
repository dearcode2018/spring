/**
 * 描述: 
 * HibernateDaoSupportTest.java
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

import com.hua.dao.CoreDao;
import com.hua.dao.m2o.CustomDao;
import com.hua.orm.entity.m2o.Custom;
import com.hua.orm.entity.m2o.Item;
import com.hua.test.BaseTest;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * HibernateDaoSupportTest
 */
//for Junit 4.x
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:conf/xml/spring-config.xml",
		"classpath:conf/xml/spring-db.xml",
		"classpath:conf/xml/spring-bean.xml",
		"classpath:conf/xml/spring-hibernate.xml",
		"classpath:conf/xml/hibernate-dao-support.xml",
		/*"classpath:conf/xml/spring-tx.xml"*/})
public final class HibernateDaoSupportTest extends BaseTest {
	
	@Resource
	private CoreDao<?> coreDao;
	
	@Resource
	private CustomDao customDao;
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testHibernateDao() {
		try {
			
		} catch (Exception e) {
			log.error("testHibernateDao =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testCoreDao() {
		try {
			//beanFactory = SpringJdbcUtil.getBeanFactoryOfXml();
			// 不能使用 JdbcTemplateCoreDao.class 参数的方式，因为在ioc容器中有多个 CoreDao子类对象
			//JdbcTemplateCoreDao<?> jdbcTemplateCoreDao = (JdbcTemplateCoreDao<?>) beanFactory.getBean(JdbcTemplateCoreDao.class);
			/*
			 * 因为IOC容器中声明了多个CoreDao的实现，通过类型将返回多个
			 * 而导致错误
			 */
			//JdbcTemplateCoreDao jdbcTemplateCoreDao = beanFactory.getBean(JdbcTemplateCoreDao.class);
			
			System.out.println(coreDao.getHibernateTemplate());
			sql = "select count(*) from person";
			log.info("testCoreDao =====> count = " + coreDao.count(sql));
		} catch (Exception e) {
			log.error("testCoreDao =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testInsert() {
		try {
			Custom custom = new Custom();
			custom.setName("zhengqianye");
			custom.setAddress("guagnzhoucity");
			custom.setBalance(10.34);
			
			Item item = null;
			
			item = new Item();
			// 设置关联关系
			custom.getItems().add(item);
			item.setCustom(custom);
			item.setName("天河又一城1");
			item.setRemark("消费金额1");
			item.setMonetary(10.34);
			
			item = new Item();
			// 设置关联关系
			custom.getItems().add(item);
			item.setCustom(custom);
			item.setName("天河又一城2");
			item.setRemark("消费金额2");
			item.setMonetary(5.34);
			
			customDao.insert(custom);
			
		} catch (Exception e) {
			log.error("testInsert =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testDelete() {
		try {
			
			
		} catch (Exception e) {
			log.error("testDelete =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testUpdate() {
		try {
			
			
		} catch (Exception e) {
			log.error("testUpdate =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testQuery() {
		try {
			
			
		} catch (Exception e) {
			log.error("testQuery =====> ", e);
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
