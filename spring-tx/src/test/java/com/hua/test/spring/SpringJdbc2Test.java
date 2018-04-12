/**
 * 描述: 
 * SpringJdbcTest.java
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

import com.hua.constant.ext.Gender;
import com.hua.dao.CoreDao;
import com.hua.dao.o2o.PersonDao;
import com.hua.orm.entity.o2o.Person;
import com.hua.test.BaseTest;
import com.hua.util.DateTimeUtil;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * SpringJdbcTest
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:conf/xml/spring-config.xml", 
		"classpath:conf/xml/spring-db.xml",
		"classpath:conf/xml/spring-bean.xml", 
		"classpath:conf/xml/spring-dao.xml",
		"classpath:conf/xml/spring-tx.xml"})
public final class SpringJdbc2Test extends BaseTest {

	/* 注入指定的bean */
	@Resource(name = "personDao")
	private PersonDao personDao;
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSpringJdbcUtil() {
		try {
			log.info("testSpringJdbcUtil =====> " + personDao);
			
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
			
			sql = "select count(*) from person";
			log.info("testReadOnly =====> count = " + personDao.count(sql));
			
		} catch (Exception e) {
			log.error("testSpringJdbcUtil =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSpringJdbc() {
		try {
			//SpringJdbcUtil.getBeanFactoryOfXml();
			
		} catch (Exception e) {
			log.error("testSpringJdbc =====> ", e);
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
			
			CoreDao coreDao = (CoreDao) beanFactory.getBean("coreDao");
			/*
			 * 因为IOC容器中声明了多个CoreDao的实现，通过类型将返回多个
			 * 而导致错误
			 */
			//CoreDao coreDao = beanFactory.getBean(CoreDao.class);
			
			
			System.out.println(coreDao.getJdbcTemplate());
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
	public void testJdbcTemplate() {
		try {
			
			CoreDao coreDao = (CoreDao) beanFactory.getBean("coreDao");
			jdbcTemplate = coreDao.getJdbcTemplate();
			
			
			
		} catch (Exception e) {
			log.error("testJdbcTemplate =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testPersonDao() {
		try {
			//CoreDao coreDao = (CoreDao) beanFactory.getBean("coreDao");
			PersonDao personDao = (PersonDao) beanFactory.getBean("personDao");
			System.out.println(personDao);
			sql = "select count(*) from person";
			
			log.info("testPersonDao =====> count = " + personDao.count(sql));
			
		} catch (Exception e) {
			log.error("testPersonDao =====> ", e);
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
			PersonDao personDao = (PersonDao) beanFactory.getBean("personDao");
			sql = "insert into person (oid, name, nation, birthday, address, gender, photoUrl) " +
					"values (seq_person_oid.nextVal, ?, ?, ?, ?, ?, ?)";
			
			personDao.insert(sql, params);
			
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
