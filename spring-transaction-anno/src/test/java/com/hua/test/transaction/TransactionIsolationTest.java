/**
 * 描述: 
 * TransactionIsolationTest.java
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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hua.constant.ext.CustomStatus;
import com.hua.dao.m2o.CustomDao;
import com.hua.orm.entity.m2o.Custom;
import com.hua.service.IsolationService;
import com.hua.test.BaseTest;

//import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * 描述: 事务传播
 * 
 * @author qye.zheng
 * TransactionIsolationTest
 */
/*
 * 
 * @SpringJUnit4ClassRunner 运行器负责拉起 spring 环境
 * @ContextConfiguration 指定 spring配置文件，若不指定，则使用默认配置.
 */
// for Junit 4.x
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:conf/xml/applicationContext.xml"})
@ContextConfiguration(locations = {
		"classpath:conf/xml/spring-annotation.xml",
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
public class TransactionIsolationTest extends BaseTest {

	@Resource
	private IsolationService isolationService;
	
	@Resource
	private CustomDao customDao;
	
	/**
	 * 事务注解
	 * 1) 启用事务注解 spring-tx-anno.xml
	 * 2) 在方法上声明 @Transactional 
	 * 
	 * 注意: @Transactional  超过多个事务管理器的时候，
	需要在@Transactional注解中声明使用哪个一个
	 * 
	 * 
	 */
	
	/*
	 * @Transactional 在JUnit测试环境中默认是回滚的
	 * 	需要在测试类或方法上加上@Commit注解，该注解是可以继承的.
	 * 不加@Commit注解就默认是回滚的.
	 *  Committed transaction for test: [DefaultTestContext@3e78b6a5 testClass = TransactionAnnotationTest
	 */
	
	/**
	 * 引当前项目用其他项目之后，然后可以使用
	 * TransactionJunitTest模板测试的其他项目
	 * 
	 * 可以使用所引用目标项目的所有资源
	 * 若引用的项目的配置与本地的冲突或无法生效，需要
	 * 将目标项目的配置复制到当前项目同一路径下
	 * 
	 */
	
	/*
	 * 在单元测试方法上加上以下注解: 
	 @Transactional
	 @Commit
	 @Test
	 
	 1) 只有@Test注解，在执行dao的时候，默认用的是spring-dao默认的事务策略，
	 即默认是提交的.
	 
	 2) 添加了 @Test @Transactional 注解
	 单元测试有了事务声明，当然，前提是开启了spring事务注解的功能.
	 此时，spring事务默认是回滚的，即事务不会生效.
	 
	 3) @Transactional @Commit @Test 添加了这3个注解
	 此时无论执行过程之后是否有异常或try-catch，事务都会提交.
	 
	 
	 若不采用Junit单元测试的方式直接控制事务，可以通过在单元测试中调用
	 service方法，在service方法中声明事务注解.
	 
	 */
	
	/**
	 * 事务传播 (Transactional Propagation) Propagation
	 * 1) 事务的传播发生多个方法之间的调用，包括同对象和不同对象的方法
	 * 2) 当前方法的事务传播方式不会影响另外一个方法的传播方式
	 * 3) 
	 * 
	 * 
	 * 
	 */

	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testDefaultIsolation() {
		try {
			/*
			 * Propagation.REQUIRED
			 * @Transactional 注解的默认传播方式
			 * 若当前存在事务，则使用该事务执行，否则创建一个事务.
			 * 
			 */
			Custom entity = null;
			
			entity = new Custom();
			entity.setName("Propagation.REQUIRED");
			entity.setAddress("广州市天河东路112号");
			entity.setBalance(10.34);
			entity.setStatus(CustomStatus.NORMAL);
			
			/*
			 * 测试的时候，无事务和有事务交替注释进行，以便观察结果
			 */
			
			// 无事务
			//propagationService.callRequiredMethodWithoutTransaction(entity);

			// 有事务
			isolationService.defaultIsolation(entity);
			
		} catch (Exception e) {
			log.error("testDefaultIsolation =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testReadUncommitted() {
		try {
			// 有事务
			isolationService.readUncommitted();
			
		} catch (Exception e) {
			log.error("testReadUncommitted =====> ", e);
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
			Custom entity = null;
			
			entity = new Custom();
			entity.setName("赵备小朋友01");
			entity.setAddress("广州市天河东路112号");
			entity.setBalance(10.34);
			entity.setStatus(CustomStatus.NORMAL);
			
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
