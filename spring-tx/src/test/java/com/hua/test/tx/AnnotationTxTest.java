/**
 * 描述: 
 * AnnotationTxTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.tx;

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
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hua.constant.ext.Gender;
import com.hua.dao.o2o.PersonDao;
import com.hua.orm.entity.o2o.Person;
import com.hua.test.BaseTest;
import com.hua.tx.eg.Scene2ServiceA;
import com.hua.tx.eg.Scene3ServiceA;
import com.hua.util.DateTimeUtil;


/**
 * 描述: 注解式事务
 * 
 * @author qye.zheng
 * AnnotationTxTest
 */
//@TransactionConfiguration(transactionManager="txManager",defaultRollback=false)
//for Junit 4.x
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:conf/xml/applicationContext.xml"})
@ContextConfiguration(locations = {
		"classpath:conf/xml/tx-annotation.xml",
		"classpath:conf/xml/spring-bean.xml", 
		"classpath:conf/xml/spring-config.xml", 
		"classpath:conf/xml/spring-db.xml",
		"classpath:conf/xml/spring-dao.xml",
		"classpath:conf/xml/spring-jdbc.xml",
		"classpath:conf/xml/spring-tx.xml"
})
public final class AnnotationTxTest extends BaseTest {

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
	public void testAnnotationTx() {
		try {
			/**
			 * Transactional(noRollback = { RuntimeException.class })
			 * Transactional(rollbackForClassName = { "java.lang.RuntimeException" })
			 * Transactional(rollbackFor = { Exception.class })
			 * Transactional(rollbackForClassName = { "java.lang.Exception" })
			 * Transactional(timeout=秒数)
			 * Transactional(isolation = Isolation.REPEATABLE_READ)
			 * Transactional(readOnly = false)
			 * Transactional(propagation = Propagation.REQUIRED)
			 * Transactional()
			 * 
			 * 传播默认值是 REQUIRE
			 * Transactional(propagation = Propagation.REQUIRED)
			 * 
			 * 
			 */
			
			
			/**
			 * 查询方法不开启事务 (Spring tx 默认是开启事务)
			 * Transactional(propagation=Propagation.NOT_SUPPORTED, readOnly = true)
			 */
			
			
		} catch (Exception e) {
			log.error("testAnnotationTx =====> ", e);
		}
	}

	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Transactional(propagation = Propagation.NOT_SUPPORTED, 
			readOnly = true)
	@Test
	public void testReadOnly() {
		try {
			PersonDao personDao = (PersonDao) beanFactory.getBean("personDao");
			sql = "select count(*) from person";
			
			log.info("testReadOnly =====> count = " + personDao.count(sql));
			
			// 新增操作 需要事务，此时会出现什么问题
			
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
			sql = "insert into person (oid, name, nation, birthday, address, gender, photoUrl) " +
					"values (seq_person_oid.nextVal, ?, ?, ?, ?, ?, ?)";
			personDao.insert(sql, params);
			
			sql = "select count(*) from person";
			log.info("testReadOnly =====> count = " + personDao.count(sql));
		} catch (Exception e) {
			log.error("testReadOnly =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@Transactional(propagation = Propagation.REQUIRED)
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
	@Transactional(propagation = Propagation.REQUIRED, 
			rollbackFor = Exception.class)
	@Test
	public void testExceptionRollback() {
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
			log.error("testExceptionRollback =====> ", e);
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
			//SpringJdbcUtil.getBeanFactoryOfXml();
			// new Scene1ServiceA().callB();
			
			new Scene2ServiceA().callB();
			
			new Scene3ServiceA().callB();
			
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
