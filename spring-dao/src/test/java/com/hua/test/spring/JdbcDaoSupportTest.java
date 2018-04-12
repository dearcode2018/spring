/**
 * 描述: 
 * JdbcDaoSupportTest.java
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

import com.hua.constant.ext.CustomStatus;
import com.hua.constant.ext.Gender;
import com.hua.dao.CoreDao;
import com.hua.dao.m2o.CustomDao;
import com.hua.dao.o2o.PersonDao;
import com.hua.orm.entity.m2o.Custom;
import com.hua.orm.entity.o2o.Person;
import com.hua.test.BaseTest;
import com.hua.util.DateTimeUtil;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * JdbcDaoSupportTest
 */
//for Junit 4.x
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:conf/xml/spring-config.xml",
		"classpath:conf/xml/spring-bean.xml",	
		"classpath:conf/xml/spring-db.xml",
		"classpath:conf/xml/jdbc-dao-support.xml"})
public final class JdbcDaoSupportTest extends BaseTest {
	
	@Resource
	private CoreDao<?> coreDao;
	
	@Resource
	private CustomDao customDao;
	
	@Resource
	private PersonDao personDao;
	
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
			//JdbcTemplateCoreDao<?> coreDao = (JdbcTemplateCoreDao<?>) beanFactory.getBean(JdbcTemplateCoreDao.class);
			/*
			 * 因为IOC容器中声明了多个CoreDao的实现，通过类型将返回多个
			 * 而导致错误
			 */
			//JdbcTemplateCoreDao coreDao = beanFactory.getBean(JdbcTemplateCoreDao.class);
			
			
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
			custom.setName("赵备小朋友");
			custom.setAddress("广州市天河东路112号");
			custom.setBalance(10.34);
			custom.setStatus(CustomStatus.NORMAL);
			
			Object[] params = new Object[4];
			params[0] = custom.getName();
			params[1] = custom.getAddress();
			params[2] = custom.getBalance();
			params[3] = custom.getStatus().getValue();
			sql = "insert into custom (name, address, balance, status) " +
					"values (?, ?, ?, ?)";
			
			customDao.insert(sql, params);
			
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
	public void testInsertPerson() {
		try {
			Person p = new Person();
			p.setName("杨烁");
			p.setNation("汉");
			p.setBirthday(DateTimeUtil.getDate());
			p.setAddress("湖北省襄阳市汉阳区东山路152号");
			p.setGender(Gender.MALE);
			p.setPhotoUrl("http://www.come.here/m/tp.gif");
			
			Object[] params = new Object[6];
			params[0] = p.getName();
			params[1] = p.getNation();
			params[2] = p.getBirthday();
			params[3] = p.getAddress();
			params[4] = p.getGender().getValue();
			params[5] = p.getPhotoUrl();
			sql = "insert into person (name, nation, birthday, address, gender, photoUrl) " +
					"values (?, ?, ?, ?, ?, ?)";
			
			personDao.insert(sql, params);
			
		} catch (Exception e) {
			log.error("testInsertPerson =====> ", e);
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
