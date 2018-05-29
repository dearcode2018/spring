/**
  * @filename CustomService.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hua.dao.m2o.CustomDao;
import com.hua.orm.entity.m2o.Custom;

 /**
 * @type CustomService
 * @description 
 * @author qianye.zheng
 */
@Service
public class CustomService
{
	
	@Resource
	private CustomDao customDao;
	
	@Resource
	private CustomService2 customService2;
	
	/**
	 * 
	 * @description 
	 * @param entity
	 * @author qianye.zheng
	 */
	@Transactional(transactionManager = "transactionManager")
	public void insert1(final Custom entity)
	{
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
	@Transactional(transactionManager = "transactionManager")
	/*
	 * rollbackFor 表示发生指定异常回滚，但发生其他异常也回滚
	 * noRollbackFor 表示发生指定异常不回滚，但发生其他异常回滚
	 */
	//@Transactional(transactionManager = "transactionManager",  rollbackFor = IllegalAccessException.class)
	//@Transactional(transactionManager = "transactionManager", noRollbackFor = NullPointerException.class)
	public void insert2(final Custom entity)
	{
		Object[] params = new Object[4];
		params[0] = entity.getName();
		params[1] = entity.getAddress();
		params[2] = entity.getBalance();
		params[3] = entity.getStatus().getValue();
		
		String sql = "insert into custom (name, address, balance, status) " +
				"values (?, ?, ?, ?)";
		
		customDao.insert(sql, params);
		
		/*
		 * 发生异常，则当前事务回滚
		 */
		// 制造一个异常
		String str = null;
		System.out.println(str.length());
		
		// 调用当前service对象的方法
		this.insert1(entity);
	}
	
	/**
	 * 
	 * @description 
	 * @param entity
	 * @author qianye.zheng
	 */
	@Transactional(transactionManager = "transactionManager")
	public void insert3(final Custom entity)
	{
		Object[] params = new Object[4];
		params[0] = entity.getName();
		params[1] = entity.getAddress();
		params[2] = entity.getBalance();
		params[3] = entity.getStatus().getValue();
		
		String sql = "insert into custom (name, address, balance, status) " +
				"values (?, ?, ?, ?)";
		
		customDao.insert(sql, params);
		
		// 调用另外一个service对象的方法
		customService2.insert1(entity);
		
	}
	
	/**
	 * 
	 * @description 
	 * @param entity
	 * @author qianye.zheng
	 */
	@Transactional(transactionManager = "transactionManager")
	public void insert4(final Custom entity)
	{
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
	@Transactional(transactionManager = "transactionManager")
	public void insert5(final Custom entity)
	{
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
	@Transactional(transactionManager = "transactionManager")
	public void insert6(final Custom entity)
	{
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
