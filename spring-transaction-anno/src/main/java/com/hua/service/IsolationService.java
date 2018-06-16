/**
  * @filename IsolationService.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hua.dao.m2o.CustomDao;
import com.hua.orm.entity.m2o.Custom;

 /**
 * @type IsolationService
 * @description 
 * @author qianye.zheng
 */
@Service
public class IsolationService
{
	
	@Resource
	private CustomDao customDao;
	
	
	
	/**
	 * @Transactional 注解是 被其他入口方法(main方法/
	 * JUnit测试类方法/控制层方法等..)
	 * 调用的时候，根据传播行为去做具体动作.
	 * 在方法的调用之间，相对发生行为，需要怎么样的事务，要根据自身方法
	 * 事务注解的声明.
	 * 
	 *
	 * 一个方法的事务传播属性的声明，直接影响的其上一级方法.
	 *
	 * 每个 @Transactional 方法，Spring IOC中都会生成一个代理对象，
	 * 覆盖这个方法，因此如果这个方法是final类型，则在此方法中无法
	 * 从IOC中获取资源.
	 *
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void defaultIsolation(final Custom entity)
	{
		// 当前方法有事务，因此下面的dao操作将会提交
		for (int i = 0; i < 50; i++)
		{
			entity.setName("当前方法有事务，mandatory()将以事务方式正常执行.");
			Object[] params = new Object[4];
			params[0] = entity.getName();
			params[1] = entity.getAddress();
			params[2] = entity.getBalance();
			params[3] = entity.getStatus().getValue();
			String sql = "insert into custom (name, address, balance, status) " +
					"values (?, ?, ?, ?)";
			customDao.insert(sql, params);
		}
		
		System.out.println("执行结束，准备提交任务");
	}
	
	/**
	 * @Transactional 注解是 被其他入口方法(main方法/
	 * JUnit测试类方法/控制层方法等..)
	 * 调用的时候，根据传播行为去做具体动作.
	 * 在方法的调用之间，相对发生行为，需要怎么样的事务，要根据自身方法
	 * 事务注解的声明.
	 * 
	 *
	 * 一个方法的事务传播属性的声明，直接影响的其上一级方法.
	 *
	 * 每个 @Transactional 方法，Spring IOC中都会生成一个代理对象，
	 * 覆盖这个方法，因此如果这个方法是final类型，则在此方法中无法
	 * 从IOC中获取资源.
	 *
	 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_UNCOMMITTED)
	public void readUncommitted()
	{
		String sql = "select count(*) from custom where id > 43";
		 
		 System.out.println(customDao.count(sql));
		 
		 System.out.println(customDao.count(sql));
		 
		 
		 System.out.println(customDao.count(sql));
		 
	}
	
}
