/**
 * 描述: 
 * DaoTransactionTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.datasource;

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

import com.hua.dao.one.PersonOneDao;
import com.hua.dao.three.PersonThreeDao;
import com.hua.dao.two.PersonTwoDao;
import com.hua.orm.entity.o2o.Person;
import com.hua.test.BaseTest;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * DaoTransactionTest
 */
/*
 * 
 * @SpringJUnit4ClassRunner 运行器负责拉起 spring 环境
 * @ContextConfiguration 指定 spring配置文件，若不指定，则使用默认配置.
 */
// for Junit 4.x
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:conf/xml/applicationContext.xml"})
@ContextConfiguration(locations = {"classpath:conf/xml/spring-config.xml",
		"classpath:conf/xml/spring-db.xml", "classpath:conf/xml/jdbc-dao-support.xml",
		"classpath:conf/xml/spring-tx2.xml"
})
//@TransactionConfiguration(defaultRollback = false)
public class DaoTransactionTest extends BaseTest {

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
	private PersonOneDao personOneDao;
	
	@Resource
	private PersonTwoDao personTwoDao;
	
	@Resource
	private PersonThreeDao personThreeDao;
	
	private Person person;
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testDynamicDatasource1() {
		try {
			String sql = "INSERT INTO person_01 (name, photoUrl, gender, nation, birthday, address, cardId) VALUES ('徐明1', null, 'Male', '汉族', '1973-01-16', '广东省广州市天河区平云路11号', null);";
			personOneDao.insert(sql);

			
		} catch (Exception e) {
			log.error("testDynamicDatasource1 =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testDynamicDatasource2() {
		try {
			String sql = "INSERT INTO person_01 (name, photoUrl, gender, nation, birthday, address, cardId) VALUES ('徐明1', null, 'Male', '汉族', '1973-01-16', '广东省广州市天河区平云路11号', null);";
			personTwoDao.insert(sql);

			
		} catch (Exception e) {
			log.error("testDynamicDatasource2 =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testDynamicDatasource3() {
		try {
			System.out.println("3.PersonOneService.insert()");
			String sql = "INSERT INTO person_01 (name, photoUrl, gender, nation, birthday, address, cardId) VALUES ('徐明1', null, 'Male', '汉族', '1973-01-16', '广东省广州市天河区平云路11号', null);";
			personThreeDao.insert(sql);

			
		} catch (Exception e) {
			log.error("testDynamicDatasource3 =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testDynamicDatasourceUnion() {
		try {
			/**
			 * 三个分别执行，看事务AOP的设置效果
			 * 在dao层分别设置
			 */
			
			System.out.println("3.PersonOneService.insert()");
			String sql = "INSERT INTO person_01 (name, photoUrl, gender, nation, birthday, address, cardId) VALUES ('徐明1', null, 'Male', '汉族', '1973-01-16', '广东省广州市天河区平云路11号', null);";
			personOneDao.insert(sql);

			System.out.println("3.PersonOneService.insert()");
			personTwoDao.insert(sql);

			System.out.println("3.PersonOneService.insert()");
			personThreeDao.insert(sql);

			
		} catch (Exception e) {
			log.error("testDynamicDatasourceUnion =====> ", e);
		}
	}	
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSpringJunit() {
		try {
			
			
		} catch (Exception e) {
			log.error("testSpringJunit =====> ", e);
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
