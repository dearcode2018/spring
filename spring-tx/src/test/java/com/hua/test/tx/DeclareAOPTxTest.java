/**
 * 描述: 
 * DeclareAOPTxTest.java
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

import com.hua.constant.ext.Gender;
import com.hua.dao.o2o.PersonDao;
import com.hua.orm.entity.o2o.Person;
import com.hua.test.BaseTest;
import com.hua.util.DateTimeUtil;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * DeclareAOPTxTest
 */
//for Junit 4.x
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:conf/xml/applicationContext.xml"})
@ContextConfiguration(locations = {
		"classpath:conf/xml/tx-declare-aop.xml",
		"classpath:conf/xml/spring-bean.xml", 
		"classpath:conf/xml/spring-config.xml", 
		"classpath:conf/xml/spring-db.xml",
		"classpath:conf/xml/spring-dao.xml"})
public final class DeclareAOPTxTest extends BaseTest {

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
	public void testDeclareTx() {
		try {
			
			
		} catch (Exception e) {
			log.error("testDeclareTx =====> ", e);
		}
	}

	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testHasTx() {
		try {
			sql = "select count(*) from person";
			
			log.info("testHasTx =====> count = " + personDao.count(sql));
			
			/*
			 * 新增操作 需要事务，此时会出现什么问题
			 * 而在tx-declare-bean.xml 有给insert声明事务
			 */
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
			log.info("testHasTx =====> count = " + personDao.count(sql));
			
		} catch (Exception e) {
			log.error("testHasTx =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testNoTx() {
		try {
			sql = "select count(*) from person";
			
			log.info("testNoTx =====> count = " + personDao.count(sql));
			
			/*
			 * 更新操作 需要事务，此时会出现什么问题
			 * 而在tx-declare-bean.xml没有给update声明事务
			 */
			Person p = new Person();
			p.setId("23");
			p.setName("李伟");
			p.setNation("汉");
			p.setBirthday(DateTimeUtil.getDate());
			p.setAddress("湖北省襄阳市汉阳区东山路152号");
			p.setGender(Gender.MALE);
			p.setPhotoUrl("http://www.come.here/m/tp.gif");
			
			Object[] params = new Object[7];
			params[0] = p.getName();
			params[1] = p.getNation();
			params[2] = p.getBirthday();
			params[3] = p.getAddress();
			params[4] = p.getGender().getValue();
			params[5] = p.getPhotoUrl();
			params[6] = p.getId();
			sql = "update person set name = ?, nation = ?,birthday = ?,"
					+ "address = ?,gender = ?,photoUrl = ? where id = ?";
			
			personDao.update(sql, params);
			
			sql = "select count(*) from person";
			log.info("testNoTx =====> count = " + personDao.count(sql));
			
		} catch (Exception e) {
			log.error("testNoTx =====> ", e);
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
