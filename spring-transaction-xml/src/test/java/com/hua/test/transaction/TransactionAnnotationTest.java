/**
 * 描述: 
 * TransactionAnnotationTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.transaction;

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
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.hua.constant.ext.CustomStatus;
import com.hua.constant.ext.Gender;
import com.hua.dao.CoreDao;
import com.hua.dao.m2o.CustomDao;
import com.hua.dao.o2o.PersonDao;
import com.hua.orm.entity.m2o.Custom;
import com.hua.orm.entity.o2o.Person;
import com.hua.test.BaseTest;
import com.hua.util.DateTimeUtil;
//import org.springframework.test.context.transaction.TransactionConfiguration;


/**
 * 描述: 事务注解
 * 
 * @author qye.zheng
 * TransactionAnnotationTest
 */
//for Junit 4.x
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:conf/xml/spring-config.xml",
		"classpath:conf/xml/spring-bean.xml",	
		"classpath:conf/xml/spring-db.xml",
		"classpath:conf/xml/jdbc-dao-support.xml",
		"classpath:conf/xml/spring-tx-anno.xml"		
})
/*
 * @TransactionConfiguration 在高版本中已经移除了
 * 
 *  
 *  */
// 使用事务注解 不能声明为final类型
public class TransactionAnnotationTest extends BaseTest {
	
	@Resource
	private CoreDao<?> coreDao;
	
	@Resource
	private CustomDao customDao;
	
	@Resource
	private PersonDao personDao;
	
	//@Resource
	private DataSourceTransactionManager transactionManager1;
	
	//@Resource
	private DataSourceTransactionManager transactionManager2;
	
	/**
	 * 事务注解
	 * 1) 启用事务注解 spring-tx-anno.xml
	 * 2) 在方法上声明 @Transactional 
	 * 
	 * 
	 * 
	 */
	
	/**
	 * 事务传播行为
	 * 1) 
	 */
	
	
	/*
	 * @Transactional 在JUnit测试环境中默认是回滚的
	 * 	需要在测试类或方法上加上@Commit注解，该注解是可以继承的.
	 * 不加@Commit注解就默认是回滚的.
	 *  Committed transaction for test: [DefaultTestContext@3e78b6a5 testClass = TransactionAnnotationTest
	 */
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	@Transactional
	//@Transactional(transactionManager = "transactionManager1")
	//@Transactional(transactionManager = "transactionManager2")
	@Commit
	public void testTransaction() {
		Custom custom = new Custom();
		custom.setName("赵备小朋友11");
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
		
		//System.out.println(transactionManager1.toString());
		
		custom = new Custom();
		custom.setName("赵备小朋友22");
		custom.setAddress("广州市天河东路112号");
		custom.setBalance(10.34);
		custom.setStatus(CustomStatus.NORMAL);
		
		params = new Object[4];
		params[0] = custom.getName();
		params[1] = custom.getAddress();
		params[2] = custom.getBalance();
		params[3] = custom.getStatus().getValue();
		sql = "insert into custom (name, address, balance, status) " +
				"values (?, ?, ?, ?)";
		//customDao.insert(sql, params);
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	//	@Transactional
	@Transactional(rollbackFor = Exception.class)
	@Commit
	//@Rollback
	public void testTransactionRollback() {
		
		/*
		 * 前面一个成功，后面一个失败，整体失败.
		 * 
		 * 
		 * 
		 */
		
		/*
		 * @Transactional 中没有声明哪个异常回滚，则默认不回滚
		 * Committed transaction for test: [DefaultTestContext@5be1d0a4 testClass = TransactionAnnotationTest, 
		 * testInstance = com.hua.test.transaction.TransactionAnnotationTest@415b0b49, testMethod = 
		 * testTransactionRollback@TransactionAnnotationTest, testException = 
		 * java.lang.NullPointerException, mergedContextConfiguration = 
		 * [MergedContextConfiguration@6d5620ce testClass = TransactionAnnotationTest,
		 *  locations = '{classpath:conf/xml/spring-config.xml, 
		 *  classpath:conf/xml/spring-bean.xml, classpath:conf/xml/spring-db.xml, 
		 *  classpath:conf/xml/jdbc-dao-support.xml, classpath:conf/xml/spring-tx-anno.xml}', 
		 *  classes = '{}', contextInitializerClasses = '[]', activeProfiles = '{}', 
		 *  propertySourceLocations = '{}', propertySourceProperties = '{}', 
		 *  contextCustomizers = set[[empty]], contextLoader = 
		 *  'org.springframework.test.context.support.DelegatingSmartContextLoader', 
		 * parent = [null]], attributes = map[[empty]]]
		 */
		Custom custom = new Custom();
		custom.setName("赵备小朋友11");
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
		
		
		// 制造一个异常
		String str = null;
		System.out.println(str.length());
		
		custom = new Custom();
		custom.setName("赵备小朋友22");
		custom.setAddress("广州市天河东路112号");
		custom.setBalance(10.34);
		custom.setStatus(CustomStatus.NORMAL);
		
		params = new Object[4];
		params[0] = custom.getName();
		params[1] = custom.getAddress();
		params[2] = custom.getBalance();
		params[3] = custom.getStatus().getValue();
		sql = "insert into custom (name, address, balance, status) " +
				"values (?, ?, ?, ?)";
		customDao.insert(sql, params);
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
