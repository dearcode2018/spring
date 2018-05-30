/**
  * @filename PropagationService.java
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
 * @type PropagationService
 * @description 
 * @author qianye.zheng
 */
@Service
public class PropagationService
{
	
	@Resource
	private CustomDao customDao;
	
	
	/*
	 * 由于调用当前对象的其他方法事务的声明没有生效，
	 * 因此改为调用其他对象的方法
	 */
	@Resource
	private OtherService otherService;
	
	
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
	 */
	
	/**
	 * 
	 * @description 以无事务形式调用
	 * @param entity
	 * @author qianye.zheng
	 */
	/*
	 * 没有声明 @Transactional 即上层调用该方法的时候不发生跟事务有关的动作.
	 */
	public void callRequiredMethodWithoutTransaction(final Custom entity)
	{
		/*
		 * 由于callRequiredMethodWithoutTransaction方法
		 * 没有事务，因此 执行required()创建一个自身范围的事务
		 */
		otherService.required(entity);
		
		// 当前方法没有事务，因此下面的dao操作将不会提交
		entity.setName("当前方法没有事务，因此下面的dao操作将不会提交");
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
	 * @description 以有事务方式调用
	 * @param entity
	 * @author qianye.zheng
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void callRequiredMethodWithTransaction(final Custom entity)
	{
		/*
		 * 由于callRequiredMethodWithTransaction有事务
		 * 执行required()直接在该事务内运行.
		 */
		otherService.required(entity);
		
		// 当前方法有事务，因此下面的dao操作将会提交
		entity.setName("当前方法有事务，执行required() 无需创建事务，直接使用该事务.");
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
	 * @description 以无事务形式调用
	 * @param entity
	 * @author qianye.zheng
	 */
	/*
	 * 没有声明 @Transactional 即上层调用该方法的时候不发生跟事务有关的动作.
	 */
	public void callRequiresNewMethodWithoutTransaction(final Custom entity)
	{
		/*
		 * callRequiresNewMethodWithoutTransaction方法
		 * 没有事务，执行requiresNew()将创建一个自身范围的事务
		 */
		otherService.requiresNew(entity);
		
		// 当前方法没有事务，因此下面的dao操作将不会提交
		entity.setName("没有事务，执行requiresNew()将创建一个此方法范围的事务");
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
	 * @description 以有事务方式调用
	 * @param entity
	 * @author qianye.zheng
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void callRequiresNewMethodWithTransaction(final Custom entity)
	{
		
		
		/**
		 * 这3个sql语句，首先在数据表中出现的数据是第二条，
		 * 但是id是分别是 a , a+1, a+2.
		 */
		
		String name = entity.getName();
		// 当前方法有事务，因此下面的dao操作将会提交
		entity.setName("执行requiresNew之前");
		Object[] params = new Object[4];
		params[0] = entity.getName();
		params[1] = entity.getAddress();
		params[2] = entity.getBalance();
		params[3] = entity.getStatus().getValue();
		String sql = "insert into custom (name, address, balance, status) " +
				"values (?, ?, ?, ?)";
		customDao.insert(sql, params);
		
		entity.setName(name);
		
		/*
		 * callRequiresNewMethodWithTransaction有事务A
		 * 执行requiresNew() 挂起事务A，然后创建一个事务B，方法执行完再恢复事务A..
		 */
		otherService.requiresNew(entity);
		
		// 在此可以打断点，查看数据库requiresNew()执行完之后其事务是否已经提交
		// 当前方法有事务，因此下面的dao操作将会提交
		entity.setName("执行requiresNew之后");
		params = new Object[4];
		params[0] = entity.getName();
		params[1] = entity.getAddress();
		params[2] = entity.getBalance();
		params[3] = entity.getStatus().getValue();
		sql = "insert into custom (name, address, balance, status) " +
				"values (?, ?, ?, ?)";
		customDao.insert(sql, params);
		
	}
	
	/**
	 * 
	 * @description 以无事务形式调用 方法
	 * @param entity
	 * @author qianye.zheng
	 */
	/*
	 * 没有声明 @Transactional 即上层调用该方法的时候不发生跟事务有关的动作.
	 */
	public void callNestedMethodWithoutTransaction(final Custom entity)
	{
		/*
		 * callNestedMethodWithoutTransaction方法
		 * 没有事务，nested()将创建一个事务执行.
		 */
		otherService.nested(entity);
		
		// 当前方法没有事务，因此下面的dao操作将不会提交
		entity.setName("当前方法没有事务，因此下面的dao操作将不会提交");
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
	 * @description 以有事务方式调用 方法
	 * @param entity
	 * @author qianye.zheng
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void callNestedMethodWithTransaction(final Custom entity)
	{
		/*
		 * callNestedMethodWithTransaction有事务
		 * nested()将在该事务中执行.
		 */
		otherService.nested(entity);
		
		// 当前方法有事务，因此下面的dao操作将会提交
		entity.setName("当前方法有事务，nested()将在以事务方式执行.");
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
	 * @description 以无事务形式调用
	 * @param entity
	 * @author qianye.zheng
	 */
	/*
	 * 没有声明 @Transactional 即上层调用该方法的时候不发生跟事务有关的动作.
	 */
	public void callSupportsMethodWithoutTransaction(final Custom entity)
	{
		/**
		 * 虽然事务没有提交，但是数据表的主键还是自增的，
		 * 因为在执行sql的时候，主键自增是不知道此次执行的事务
		 * 最后是否提交.
		 * 
		 */
		/*
		 * callSupportsMethodWithoutTransaction方法
		 * 没有事务，supports()将以无事务的方式执行.
		 */
		otherService.supports(entity);
		
		// 当前方法没有事务，因此下面的dao操作将不会提交
		entity.setName("当前方法没有事务，因此下面的dao操作将不会提交");
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
	 * @description 以有事务方式调用
	 * @param entity
	 * @author qianye.zheng
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void callSupportsMethodWithTransaction(final Custom entity)
	{
		/*
		 * callSupportsNewMethodWithTransaction有事务
		 * supports()将在以事务方式执行.
		 */
		otherService.supports(entity);
		
		// 当前方法有事务，因此下面的dao操作将会提交
		entity.setName("当前方法有事务，supports()将在以事务方式执行.");
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
	 * @description 以无事务形式调用 方法
	 * @param entity
	 * @author qianye.zheng
	 */
	/*
	 * 没有声明 @Transactional 即上层调用该方法的时候不发生跟事务有关的动作.
	 */
	public void callNotSupportedMethodWithoutTransaction(final Custom entity)
	{
		/*
		 * callNotSupportedMethodWithoutTransaction方法
		 * 没有事务，notSupported()将以无事务方式执行.
		 */
		otherService.notSupported(entity);
	}
	
	/**
	 * 
	 * @description 以有事务方式调用 方法
	 * @param entity
	 * @author qianye.zheng
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void callNotSupportedMethodWithTransaction(final Custom entity)
	{
		// 当前方法有事务，因此下面的dao操作将会提交
		entity.setName("执行notSupported()之前");
		Object[] params = new Object[4];
		params[0] = entity.getName();
		params[1] = entity.getAddress();
		params[2] = entity.getBalance();
		params[3] = entity.getStatus().getValue();
		String sql = "insert into custom (name, address, balance, status) " +
				"values (?, ?, ?, ?)";
		customDao.insert(sql, params);		
		
		/*
		 * callNotSupportedMethodWithTransaction有事务A
		 * notSupported()将挂起事务A，以无事务方式运行，运行结束再唤醒
		 * 事务A.
		 */
		otherService.notSupported(entity);
		
		// 当前方法有事务，因此下面的dao操作将会提交
		entity.setName("执行notSupported()之后");
		params = new Object[4];
		params[0] = entity.getName();
		params[1] = entity.getAddress();
		params[2] = entity.getBalance();
		params[3] = entity.getStatus().getValue();
		sql = "insert into custom (name, address, balance, status) " +
				"values (?, ?, ?, ?)";
		customDao.insert(sql, params);		
	}
	
	/**
	 * 
	 * @description 以无事务形式调用
	 * @param entity
	 * @author qianye.zheng
	 */
	/*
	 * 没有声明 @Transactional 即上层调用该方法的时候不发生跟事务有关的动作.
	 */
	public void callMandatoryMethodWithoutTransaction(final Custom entity)
	{
		/*
		 * callMandatoryMethodWithoutTransaction方法
		 * 没有事务，执行mandatory()将抛异常.
		 */
		otherService.mandatory(entity);
	}
	
	/**
	 * 
	 * @description 以有事务方式调用
	 * @param entity
	 * @author qianye.zheng
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void callMandatoryMethodWithTransaction(final Custom entity)
	{
		// 需要上级方法提供事务环境
		/*
		 * callMandatoryMethodWithTransaction有事务
		 * mandatory()在该事务范围执行.
		 * 
		 */
		otherService.mandatory(entity);
		
		// 当前方法有事务，因此下面的dao操作将会提交
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
	
	/**
	 * 
	 * @description 以无事务形式调用 方法
	 * @param entity
	 * @author qianye.zheng
	 */
	/*
	 * 没有声明 @Transactional 即上层调用该方法的时候不发生跟事务有关的动作.
	 */
	public void callNeverMethodWithoutTransaction(final Custom entity)
	{
		/*
		 * callNeverMethodWithoutTransaction方法
		 * 没有事务，never()将以无事务方式正常执行.
		 */
		otherService.never(entity);
	}
	
	/**
	 * 
	 * @description 以有事务方式调用 方法
	 * @param entity
	 * @author qianye.zheng
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void callNeverMethodWithTransaction(final Custom entity)
	{
		/*
		 * callNeverMethodWithTransaction有事务
		 * 执行never()将抛异常
		 */
		otherService.never(entity);
	}
	
	/**
	 * 
	 * @description 无事务方式
	 * @param entity
	 * @author qianye.zheng
	 */
	// 声明无需事务也不起作用
	//@Transactional(propagation = Propagation.NOT_SUPPORTED) 
	public void doNoneTransaction(final Custom entity)
	{
		
		/*
		 * 由于mysql 默认是自动提交的，无法测试没有事务的情况，需要修改mysql的配置，
		在mysql主目录下，修改my.ini 设置 autocommit=0
		查看 autocommit 变量值 
		show VARIABLES like '%autocommit%';
		 */
		
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
	
	/* ======================================== */
	/**
	 * 内部事务方法之间的调用:
	 * 方法无论私有还是公有，事务都是以SUPPORTS方式来传播
	 * 即没有事务则以无事务形式执行，有事务则在事务里面执行.
	 * 
	 */
	
	/**
	 * 
	 * @description 
	 * @param entity
	 * @author qianye.zheng
	 */
	public void invokeInternalPublicMethodWithoutTransaction(final Custom entity)
	{
		// 调用当前对象的公有方法
		this.internalPublic(entity);
		
		// 
		// 当前方法没有事务，因此下面的dao操作将不会提交
		entity.setName("当前方法没有事务，因此下面的dao操作将不会提交");
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
	public void invokeInternalPublicMethodWithTransaction(final Custom entity)
	{
		/*
		 * 有事务，调用的公有方法使用当前事务执行
		 */
		// 调用当前对象的公有方法
		this.internalPublic(entity);
		
		// 当前方法有事务，因此下面的dao操作将会提交
		entity.setName("当前方法有事务，internalPublic()将以事务方式正常执行.");
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
	 * @description 内部的公有方法
	 * @param entity
	 * @author qianye.zheng
	 */
	public void internalPublic(final Custom entity)
	{
		
		/*
		 * 由于mysql 默认是自动提交的，无法测试没有事务的情况，需要修改mysql的配置，
		在mysql主目录下，修改my.ini 设置 autocommit=0
		查看 autocommit 变量值 
		show VARIABLES like '%autocommit%';
		 */
		
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
	 * @description 
	 * @param entity
	 * @author qianye.zheng
	 */
	public void invokeInternalPrivateMethodWithoutTransaction(final Custom entity)
	{
		// 调用当前对象的私有方法
		this.internalPrivate(entity);
		
		// 
		// 当前方法没有事务，因此下面的dao操作将不会提交
		entity.setName("当前方法没有事务，因此下面的dao操作将不会提交");
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
	public void invokeInternalPrivateMethodWithTransaction(final Custom entity)
	{
		/*
		 * 有事务，调用的私有方法使用当前事务执行
		 */
		// 调用当前对象的私有方法
		this.internalPrivate(entity);
		
		// 当前方法有事务，因此下面的dao操作将会提交
		entity.setName("当前方法有事务，internalPrivate()将以事务方式正常执行.");
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
	 * @description 内部的私有方法
	 * @param entity
	 * @author qianye.zheng
	 */
	private void internalPrivate(final Custom entity)
	{
		
		/*
		 * 由于mysql 默认是自动提交的，无法测试没有事务的情况，需要修改mysql的配置，
		在mysql主目录下，修改my.ini 设置 autocommit=0
		查看 autocommit 变量值 
		show VARIABLES like '%autocommit%';
		 */
		
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
}
