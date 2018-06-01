/**
 * 描述: 
 * CoreDaoImpl.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.hua.dao.CoreDao;
//spring-hibernate，已不推荐使用
//import org.springframework.orm.hibernate.support.HibernateDaoSupport;

/**
 * 描述: 
 * 
 * @author qye.zheng
 * CoreDaoImpl
 */
/*
 * 方案2: 继承 JdbcDaoSupport，注入数据源即可(DataSource)
 */
public class CoreDaoImpl<E> extends HibernateDaoSupport implements CoreDao<E> {

	/* 使用 DaoSupport 的 logger */
	protected final Log log = logger;
	
	
	/**
	 * hibernateTemplate.setCheckWriteOperations(false);
	 * 
	 * 默认是设置了 检查写操作，这样情况下 若缺乏事务或者相关配置，
	 * 则会抛异常:  Write operations are not allowed in read-only mode (FlushMode.MANUAL): 
	 * Turn your Session into FlushMode.COMMIT/AUTO or remove 'readOnly' marker from transaction definition.
	 * 
	 * 将hibernateTemplate.setCheckWriteOperations(false) 设置为false之后就可以避开写操作的检查，
	 * TODO 目前暂时无法知道 HibernateTemplate 为什么要这个判断，是缺乏事务配置?
	 */
	
	/**
	 * @description 
	 * @param sql
	 * @return
	 * @author qye.zheng
	 */
	@Override
	public int insert(E e)
	{
		// FlushMode.MANUAL
		getHibernateTemplate().setCheckWriteOperations(false);
		getHibernateTemplate().save(e);
		
		return 1;
	}

	/**
	 * @description 
	 * @param sql
	 * @return
	 * @author qye.zheng
	 */
	@Override
	public int insertOrUpdate(final E e)
	{
		getHibernateTemplate().saveOrUpdate(e);
		
		return 1;
	}

	/**
	 * @description 
	 * @param sql
	 * @return
	 * @author qye.zheng
	 */
	@Override
	public int delete(String sql)
	{
		return 0;
		//return getHibernateTemplate().delete(sql);
	}

	/**
	 * @description 
	 * @param sql
	 * @param id
	 * @return
	 * @author qye.zheng
	 */
	@Override
	public int delete(String sql, Object id)
	{
		return 0;
	}

	/**
	 * @description 
	 * @param sql
	 * @param ids
	 * @return
	 * @author qye.zheng
	 */
	@Override
	public int delete(String sql, Object[] ids)
	{
		return 0;
	}

	/**
	 * @description 
	 * @param sql
	 * @param ids
	 * @return
	 * @author qye.zheng
	 */
	@Override
	public int delete(String sql, List<Object> ids)
	{
		return 0;
	}

	/**
	 * @description 
	 * @param sql
	 * @return
	 * @author qye.zheng
	 */
	@Override
	public int update(String sql)
	{
		return 0;
	}

	/**
	 * @description 
	 * @param sql
	 * @param params
	 * @return
	 * @author qye.zheng
	 */
	@Override
	public int update(String sql, Object[] params)
	{
		return 0;
	}

	/**
	 * @description 
	 * @param sql
	 * @param params
	 * @return
	 * @author qye.zheng
	 */
	@Override
	public int update(String sql, List<Object> params)
	{
		return 0;
	}

	/**
	 * @description 
	 * @param sql
	 * @param params
	 * @return
	 * @author qye.zheng
	 */
	@Override
	public int[] batch(String sql, Object[][] params)
	{
		return null;
	}

	/**
	 * @description 
	 * @param sql
	 * @return
	 * @author qye.zheng
	 */
	@Override
	public E get(String sql)
	{
		return null;
	}

	/**
	 * @description 
	 * @param sql
	 * @param id
	 * @return
	 * @author qye.zheng
	 */
	@Override
	public E get(String sql, Object id)
	{
		return null;
	}

	/**
	 * @description 
	 * @param sql
	 * @return
	 * @author qye.zheng
	 */
	@Override
	public List<E> search(String sql)
	{
		//return getJdbcTemplate().queryForList(sql);
		return null;
	}

	/**
	 * @description 
	 * @param sql
	 * @param params
	 * @return
	 * @author qye.zheng
	 */
	@Override
	public List<E> search(String sql, Object[] params)
	{
		return null;
	}

	/**
	 * @description 
	 * @param sql
	 * @param params
	 * @return
	 * @author qye.zheng
	 */
	@Override
	public List<E> search(String sql, List<Object> params)
	{
		return null;
	}

	/**
	 * @description 
	 * @param sql
	 * @return
	 * @author qye.zheng
	 */
	@Override
	public Long count(String sql)
	{
		return 0L;
	}

	/**
	 * @description 
	 * @param sql
	 * @param params
	 * @return
	 * @author qye.zheng
	 */
	@Override
	public Long count(String sql, Object[] params)
	{
		return 0L;
	}

	/**
	 * @description 
	 * @param sql
	 * @param params
	 * @return
	 * @author qye.zheng
	 */
	@Override
	public Long count(String sql, List<Object> params)
	{
		return 0L;
	}
	
}
