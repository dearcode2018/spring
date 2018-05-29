/**
  * @filename TransactionPropagationService2.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hua.dao.m2o.CustomDao;
import com.hua.orm.entity.m2o.Custom;

 /**
 * @type TransactionPropagationService2
 * @description 
 * @author qianye.zheng
 */
@Service
public class TransactionPropagationService2
{
	
	@Resource
	private CustomDao customDao;
	
	/**
	 * 
	 * @description 强制
	 * @param entity
	 * @author qianye.zheng
	 */
	@Transactional(propagation = Propagation.MANDATORY)
	public void mandatory(final Custom entity)
	{
		/*
		 * Propagation.MANDATORY
		 * 调用方必须有事务，无事务则抛异常.
		 * 
		 * 注意: 调用方无事务，在触发被调用方的时候发生异常.
		 * 
		 * 
		 * 事务不是在被调用方中创建.
		 */
		
		Object[] params = new Object[4];
		params[0] = entity.getName();
		params[1] = entity.getAddress();
		params[2] = entity.getBalance();
		params[3] = entity.getStatus().getValue();
		
		String sql = "insert into custom (name, address, balance, status) " +
				"values (?, ?, ?, ?)";
		
		customDao.insert(sql, params);
	}
	
	/**
	 * 
	 * @description 嵌套
	 * @param entity
	 * @author qianye.zheng
	 */
	@Transactional(propagation = Propagation.NESTED)
	public void nested(final Custom entity)
	{
		/*
		 * Propagation.NESTED
		 * 被调用方嵌套在调用方的事务中执行.
		 * 行为类似于 PROPAGATION_REQUIRED
		 * 
		 * 
		 */
		
		Object[] params = new Object[4];
		params[0] = entity.getName();
		params[1] = entity.getAddress();
		params[2] = entity.getBalance();
		params[3] = entity.getStatus().getValue();
		
		String sql = "insert into custom (name, address, balance, status) " +
				"values (?, ?, ?, ?)";
		
		customDao.insert(sql, params);
	}
	
	/**
	 * 
	 * @description 从不
	 * @param entity
	 * @author qianye.zheng
	 */
	@Transactional(propagation = Propagation.NEVER)
	public void never(final Custom entity)
	{
		/*
		 * Propagation.NEVER
		 * 不支持事务，若调用方有事务则抛异常.
		 *  
		 * 
		 * 
		 */
		
		
		Object[] params = new Object[4];
		params[0] = entity.getName();
		params[1] = entity.getAddress();
		params[2] = entity.getBalance();
		params[3] = entity.getStatus().getValue();
		
		String sql = "insert into custom (name, address, balance, status) " +
				"values (?, ?, ?, ?)";
		
		customDao.insert(sql, params);
	}
	
	/**
	 * 
	 * @description 
	 * @param entity
	 * @author qianye.zheng
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	// @Transactional
	public void required(final Custom entity)
	{
		/*
		 * Propagation.REQUIRED
		 * @Transactional 注解的默认传播方式
		 * 若当前存在事务，则使用该事务执行，否则创建一个事务.
		 * 
		 * 	注意: 若调用方有事务，则被调用方使用该事务; 否则被调用方
		 * 将创建一个事务.
		 * 
		 */
		
		Object[] params = new Object[4];
		params[0] = entity.getName();
		params[1] = entity.getAddress();
		params[2] = entity.getBalance();
		params[3] = entity.getStatus().getValue();
		
		String sql = "insert into custom (name, address, balance, status) " +
				"values (?, ?, ?, ?)";
		
		customDao.insert(sql, params);
		
	}
	
	/**
	 * 
	 * @description 需要新的
	 * @param entity
	 * @author qianye.zheng
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void requiresNew(final Custom entity)
	{
		/*
		 * Propagation.REQUIRES_NEW
		 * 1) 若调用方有事务，则挂起当前事务并创建一个事务，
		 * 新事务执行结束后，唤醒之前挂起的事务，继续执行.
		 * 
		 * 2) 若调用方没有事务，则创建一个事务.
		 * 
		 * 注意: 无论调用方是否有事务，被调用方都会创建一个自己的事务.
		 * 
		 */
		
		Object[] params = new Object[4];
		params[0] = entity.getName();
		params[1] = entity.getAddress();
		params[2] = entity.getBalance();
		params[3] = entity.getStatus().getValue();
		
		String sql = "insert into custom (name, address, balance, status) " +
				"values (?, ?, ?, ?)";
		
		customDao.insert(sql, params);
	}
	
	/**
	 * 
	 * @description 不支持
	 * @param entity
	 * @author qianye.zheng
	 */
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public void notSupported(final Custom entity)
	{
		/*
		 * Propagation.NOT_SUPPORTED
		 * 被调用方以非事务形式执行，若调用方有事务则挂起其事务.
		 */
		
		Object[] params = new Object[4];
		params[0] = entity.getName();
		params[1] = entity.getAddress();
		params[2] = entity.getBalance();
		params[3] = entity.getStatus().getValue();
		
		String sql = "insert into custom (name, address, balance, status) " +
				"values (?, ?, ?, ?)";
		
		customDao.insert(sql, params);
	}
	
	/**
	 * 
	 * @description 支持
	 * @param entity
	 * @author qianye.zheng
	 */
	@Transactional(propagation = Propagation.SUPPORTS)
	public void supports(final Custom entity)
	{
		/*
		 * Propagation.SUPPORTS
		 * 有事务则以事务方式执行，无事务则以无事务方式执行.
		 * 
		 * 注意: 调用方有事务，则以事务方式执行; 否则以无事务方法执行.
		 */
		
		Object[] params = new Object[4];
		params[0] = entity.getName();
		params[1] = entity.getAddress();
		params[2] = entity.getBalance();
		params[3] = entity.getStatus().getValue();
		
		String sql = "insert into custom (name, address, balance, status) " +
				"values (?, ?, ?, ?)";
		
		customDao.insert(sql, params);
	}
	

}
