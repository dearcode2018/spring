/**
 * 描述: 
 * CoreDaoImpl.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.hua.dao.CoreDao;
import com.hua.log.BaseLog;

/**
 * 描述: 
 * 
 * @author qye.zheng
 * CoreDaoImpl
 */
public class CoreDaoImpl<T> extends BaseLog implements CoreDao<T> {
	
	private JdbcTemplate jdbcTemplate;

	/**
	 * @return the jdbcTemplate
	 */
	@Override
	public final JdbcTemplate getJdbcTemplate()
	{
		return jdbcTemplate;
	}

	/**
	 * @param jdbcTemplate the jdbcTemplate to set
	 */
	public final void setJdbcTemplate(JdbcTemplate jdbcTemplate)
	{
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * @description 
	 * @param sql
	 * @return
	 * @author qye.zheng
	 */
	@Override
	public int insert(String sql)
	{
		return jdbcTemplate.update(sql);
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
		return jdbcTemplate.update(sql, params);
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
		return jdbcTemplate.update(sql, params);
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
		return jdbcTemplate.update(sql);
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
		return jdbcTemplate.update(sql, params);
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
		return jdbcTemplate.update(sql, params);
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
		return jdbcTemplate.update(sql);
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
		return jdbcTemplate.update(sql, id);
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
		return jdbcTemplate.update(sql, ids);
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
		return jdbcTemplate.update(sql, ids);
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
		return jdbcTemplate.update(sql);
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
		return jdbcTemplate.update(sql, params);
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
		return jdbcTemplate.update(sql, params);
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
		//return jdbcTemplate.queryForList(sql);
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
		return jdbcTemplate.queryForObject(sql, Long.class);
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
		return jdbcTemplate.queryForObject(sql, Long.class, params);
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
		return jdbcTemplate.queryForObject(sql, Long.class, params);
	}
	
}
