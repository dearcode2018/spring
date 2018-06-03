/**
  * @filename TransactionTimeOutService.java
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
 * @type TransactionTimeOutService
 * @description 
 * @author qianye.zheng
 */
@Service
public class TransactionTimeOutService
{
	/*
	 * 
	 */
	
	@Resource
	private CustomDao customDao;
	
	@Resource
	private OtherService otherService;
	
	/**
	 * 
	 * @description 以有事务方式调用
	 * @param entity
	 * @author qianye.zheng
	 */
	/*
	 * 事务超时，timeout时间单位: 秒
	 * 不声明超时时间，spring默认使用的是数据库底层的超时时间
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void callRequiredMethodWithTransaction1(final Custom entity)
	{
		/*
		 * 执行 requiresNew() 挂起当前方法的事务
		 */
		otherService.requiresNew(entity);
		
		/*
		 * 
		设置wait_timeout要同时设置interactive_timeout这样才生效.
		数据库重启后，该设置就无效了，需要修改my.ini的配置才永久生效.
		set  interactive_timeout = 20;
		set  wait_timeout = 10;
		show VARIABLES like '%timeout%';
		 * 
		 * 
		 * 通过 show VARIABLES like '%timeout%'; 获知
		 * 当前数据库的connect_timeout=10秒
		 * 
		 * 
		 * 执行 requiresNew() 挂起当前方法的事务
		 * 施加断点，然后等待超时，观察结果:
		 * 
		 */
		System.out.println("施加断点");
		
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
	 * @description 以有事务方式调用
	 * @param entity
	 * @author qianye.zheng
	 */
	/*
	 * 事务超时，timeout时间单位: 秒
	 * 不声明超时时间，spring默认使用的是数据库底层的超时时间
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void callRequiredMethodWithTransaction2(final Custom entity)
	{
		
		/**
		 * 当前方法开启一个事务，然后执行方法A挂起当前事务，方法A执行
		 * 完毕后恢复当前事务，但不执行任何数据库操作.
		 * 最后事务应该也是要提交的，在提交的时候连接已经超时了.
		 */
		/*
		 * 执行 requiresNew() 挂起当前方法的事务
		 */
		otherService.requiresNew(entity);
		
		/*
		 * 
		设置wait_timeout要同时设置interactive_timeout这样才生效.
		数据库重启后，该设置就无效了，需要修改my.ini的配置才永久生效.
		set  interactive_timeout = 20;
		set  wait_timeout = 10;
		show VARIABLES like '%timeout%';
		 * 
		 * 
		 * 通过 show VARIABLES like '%timeout%'; 获知
		 * 当前数据库的connect_timeout=10秒
		 * 
		 * 
		 * 执行 requiresNew() 挂起当前方法的事务
		 * 施加断点，然后等待超时，观察结果:
		 * 
		 */
		System.out.println("施加断点");
	}
	
	/**
	 * 
	 * @description 以有事务方式调用
	 * @param entity
	 * @author qianye.zheng
	 */
	/*
	 * 事务超时，timeout时间单位: 秒
	 * 不声明超时时间，spring默认使用的是数据库底层的超时时间
	 * 事务的超时时间是从当前方法开始执行算起
	 */
	@Transactional(propagation = Propagation.REQUIRED, timeout = 10)
	public void callRequiredMethodWithTransaction3(final Custom entity)
	{
		/*
		 * transaction timeout，设置超时时间，每执行一次sql就check一次时间。
		 * 注意，这里是每执行一次sql就check一次时间，代码中，执行插入sql时，
		 * check时间没超时，等再执行http请求时，这个不是sql，
		 * 所以不会check过期时间，程序就hold在那，事务也不超时回滚。
		 */
		/**
		 * 当前方法开启一个事务，然后执行方法A挂起当前事务，方法A执行
		 * 完毕后恢复当前事务，但不执行任何数据库操作.
		 * 最后事务也是要提交的，由于事务空闲时间太长，导致事务的链接
		 * 被回收掉. (只要进行数据库操作，就不算闲置，这个问题就是出现在
		 * 开启了事务，但一直没有进行数据库操作而导致数据库链接长时间
		 * 闲置而被回收，最终在提交事务的时候报通讯链路连接异常)
		 * 
		 * 在提交的时候连接已经超时了.
		 */
		/*
		 * 执行 requiresNew() 挂起当前方法的事务
		 */
		otherService.requiresNew(entity);
		
		/*
		 * 
		设置wait_timeout要同时设置interactive_timeout这样才生效.
		数据库重启后，该设置就无效了，需要修改my.ini的配置才永久生效.
		set  interactive_timeout = 20;
		set  wait_timeout = 10;
		show VARIABLES like '%timeout%';
		 * 
		 * 
		 * 通过 show VARIABLES like '%timeout%'; 获知
		 * 当前数据库的connect_timeout=10秒
		 * 
		 * 
		 * 执行 requiresNew() 挂起当前方法的事务
		 * 施加断点，然后等待超时，观察结果:
		 * 
		 */
		System.out.println("施加断点");
		
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
	 * @description 以有事务方式调用
	 * @param entity
	 * @author qianye.zheng
	 */
	/*
	 * 事务超时，timeout时间单位: 秒
	 * 不声明超时时间，spring默认使用的是数据库底层的超时时间
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void callRequiredMethodWithTransaction4(final Custom entity)
	{
		/*
		 * transaction timeout，设置超时时间，每执行一次sql就check一次时间。
		 * 注意，这里是每执行一次sql就check一次时间，代码中，执行插入sql时，
		 * check时间没超时，等再执行http请求时，这个不是sql，
		 * 所以不会check过期时间，程序就hold在那，事务也不超时回滚。
		 */
		/**
		 * 当前方法开启一个事务，然后执行方法A挂起当前事务，方法A执行
		 * 完毕后恢复当前事务，但不执行任何数据库操作.
		 * 最后事务也是要提交的，由于事务空闲时间太长，导致事务的链接
		 * 被回收掉. (只要进行数据库操作，就不算闲置，这个问题就是出现在
		 * 开启了事务，但一直没有进行数据库操作而导致数据库链接长时间
		 * 闲置而被回收，最终在提交事务的时候报通讯链路连接异常)
		 * 
		 * 在提交的时候连接已经超时了.
		 */
		/*
		 * 执行 requiresNew() 挂起当前方法的事务
		 */
		otherService.requiresNew(entity);
		
		/*
		 * 
		设置wait_timeout要同时设置interactive_timeout这样才生效.
		数据库重启后，该设置就无效了，需要修改my.ini的配置才永久生效.
		set  interactive_timeout = 20;
		set  wait_timeout = 10;
		show VARIABLES like '%timeout%';
		 * 
		 * 
		 * 通过 show VARIABLES like '%timeout%'; 获知
		 * 当前数据库的connect_timeout=10秒
		 * 
		 * 
		 * 执行 requiresNew() 挂起当前方法的事务
		 * 施加断点，然后等待超时，观察结果:
		 * 
		 */
		System.out.println("施加断点");
	}
	
	
	/**
	 * 
	 * @description 以有事务方式调用
	 * @param entity
	 * @author qianye.zheng
	 */
	/*
	 * 事务超时，timeout时间单位: 秒
	 */
	@Transactional(propagation = Propagation.REQUIRED, timeout = 5)
	public void callRequiredMethodWithTransaction10(final Custom entity)
	{
		/*
		 * 执行 requiresNew() 挂起当前方法的事务
		 */
		otherService.requiresNew(entity);
		
		/*
		 * 执行 requiresNew() 挂起当前方法的事务
		 * 施加断点，然后等待超时，观察结果:
		 * 
		 */
		System.out.println("施加断点");
		
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

}
