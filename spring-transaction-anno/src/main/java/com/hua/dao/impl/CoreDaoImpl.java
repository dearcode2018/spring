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
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.hua.dao.CoreDao;

/**
 * 描述: 
 * 
 * @author qye.zheng
 * CoreDaoImpl
 */
/*
 * spring-dao 继承 JdbcDaoSupport，注入数据源即可(DataSource)
 * spring-jdbc 是采用直接注入 JdbcTemplate对象的方式
 */
public class CoreDaoImpl<T> extends JdbcDaoSupport implements CoreDao<T> {

	/* 使用 DaoSupport 的 logger */
	protected final Log log = logger;
	
	/**
	 * @description 
	 * @param sql
	 * @return
	 * @author qye.zheng
	 */
	@Override
	public int insert(String sql)
	{
		return getJdbcTemplate().update(sql);
	}

	/**
	 * @description 
	 * @param sql
	 * @param params
	 * @return
	 * @author qye.zheng
	 */
	@Override
	public int insert(String sql, Object[] params)
	{
		return getJdbcTemplate().update(sql, params);
	}

	/**
	 * @description 
	 * @param sql
	 * @param params
	 * @return
	 * @author qye.zheng
	 */
	@Override
	public int insert(String sql, List<Object> params)
	{
		return getJdbcTemplate().update(sql, params);
	}

	/**
	 * @description 
	 * @param sql
	 * @return
	 * @author qye.zheng
	 */
	@Override
	public int insertOrUpdate(String sql)
	{
		return getJdbcTemplate().update(sql);
	}

	/**
	 * @description 
	 * @param sql
	 * @param params
	 * @return
	 * @author qye.zheng
	 */
	@Override
	public int insertOrUpdate(String sql, Object[] params)
	{
		return getJdbcTemplate().update(sql, params);
	}

	/**
	 * @description 
	 * @param sql
	 * @param params
	 * @return
	 * @author qye.zheng
	 */
	@Override
	public int insertOrUpdate(String sql, List<Object> params)
	{
		return getJdbcTemplate().update(sql, params);
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
		return getJdbcTemplate().update(sql);
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
		return getJdbcTemplate().update(sql, id);
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
		return getJdbcTemplate().update(sql, ids);
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
		return getJdbcTemplate().update(sql, ids);
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
		return getJdbcTemplate().update(sql);
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
		return getJdbcTemplate().update(sql, params);
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
		return getJdbcTemplate().update(sql, params);
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
	public T get(String sql)
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
	public T get(String sql, Object id)
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
	public List<T> search(String sql)
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
	public List<T> search(String sql, Object[] params)
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
	public List<T> search(String sql, List<Object> params)
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
		return getJdbcTemplate().queryForObject(sql, Long.class);
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
		return getJdbcTemplate().queryForObject(sql, Long.class, params);
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
		return getJdbcTemplate().queryForObject(sql, Long.class, params);
	}
	
}
