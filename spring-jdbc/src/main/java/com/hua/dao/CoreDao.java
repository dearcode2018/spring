/**
 * 描述: 
 * CoreDao.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 描述: 
 * 
 * @author qye.zheng
 * CoreDao
 */
public interface CoreDao<T> {

	/**
	 * 
	 * @description 
	 * @return
	 * @author qye.zheng
	 */
	public JdbcTemplate getJdbcTemplate();
	
	/**
	 * 
	 * 描述: 新增实体 - 无动态参数
	 * @author qye.zheng
	 * @param sql
	 * @return
	 */
	public int insert(final String sql);
	
	/**
	 * 
	 * 描述: 新增实体
	 * @author qye.zheng
	 * @param sql
	 * @param params
	 * @return
	 */
	public int insert(final String sql, final Object[] params);
	
	/**
	 * 
	 * 描述: 新增实体
	 * @author qye.zheng
	 * @param sql
	 * @param params
	 * @return
	 */
	public int insert(final String sql, final List<Object> params);
	
	/**
	 * 
	 * 描述: 新增或更新 - 无动态参数
	 * @author qye.zheng
	 * @param sql
	 * @param params
	 * @return
	 */
	public int insertOrUpdate(final String sql);
	
	/**
	 * 
	 * 描述: 新增或更新
	 * @author qye.zheng
	 * @param sql
	 * @param params
	 * @return
	 */
	public int insertOrUpdate(final String sql, final Object[] params);
	
	/**
	 * 
	 * 描述: 新增或更新
	 * @author qye.zheng
	 * @param sql
	 * @param params
	 * @return
	 */
	public int insertOrUpdate(final String sql, final List<Object> params);
	
	/**
	 * 
	 * 描述: 删除 - 无动态参数
	 * @author qye.zheng
	 * @param sql
	 * @param id
	 * @return
	 */
	public int delete(final String sql);
	
	/**
	 * 
	 * 描述: 单一删除
	 * @author qye.zheng
	 * @param sql
	 * @param id
	 * @return
	 */
	public int delete(final String sql, final Object id);
	
	/**
	 * 
	 * 描述: 批量删除
	 * @author qye.zheng
	 * @param sql
	 * @param ids
	 * @return
	 */
	public int delete(final String sql, final Object[] ids);
	
	/**
	 * 
	 * 描述: 批量删除
	 * @author qye.zheng
	 * @param sql
	 * @param ids
	 * @return
	 */
	public int delete(final String sql, final List<Object> ids);
	
	/**
	 * 
	 * 描述: 更新实体 - 无动态参数
	 * @author qye.zheng
	 * @param sql
	 * @param params
	 * @return
	 */
	public int update(final String sql);
	
	/**
	 * 
	 * 描述: 更新实体
	 * @author qye.zheng
	 * @param sql
	 * @param params
	 * @return
	 */
	public int update(final String sql, final Object[] params);
	
	/**
	 * 
	 * 描述: 更新实体
	 * @author qye.zheng
	 * @param sql
	 * @param params
	 * @return
	 */
	public int update(final String sql, final List<Object> params);
	
	/**
	 * 
	 * 描述: 批量dml操作，insert/delete/update
	 * @author  qye.zheng
	 * @param sql
	 * @param params
	 * @return 返回每个场景下影响的行数
	 */
	public int[] batch(final String sql, final Object[][] params);
	
	/**
	 * 
	 * 描述: 获取单个对象 - 无动态参数
	 * @author qye.zheng
	 * @param sql
	 * @param id
	 * @return
	 */
	public T get(final String sql);
	
	/**
	 * 
	 * 描述: 获取单个对象
	 * @author qye.zheng
	 * @param sql
	 * @param id
	 * @return
	 */
	public T get(final String sql, final Object id);
	
	/**
	 * 
	 * 描述: 搜索多行记录 - 无动态参数
	 * @author qye.zheng
	 * @param sql
	 * @param params
	 * @return
	 */
	public List<T> search(final String sql);
	
	/**
	 * 
	 * 描述: 搜索多行记录
	 * @author qye.zheng
	 * @param sql
	 * @param params
	 * @return
	 */
	public List<T> search(final String sql, final Object[] params);
	
	/**
	 * 
	 * 描述: 搜索多行记录
	 * @author qye.zheng
	 * @param sql
	 * @param params
	 * @return
	 */
	public List<T> search(final String sql, final List<Object> params);
	
	/**
	 * 
	 * 描述: 统计记录数 - 无动态参数
	 * @author qye.zheng
	 * @param sql
	 * @param params
	 * @return
	 */
	public Long count(final String sql);
	
	/**
	 * 
	 * 描述: 统计记录数
	 * @author qye.zheng
	 * @param sql
	 * @param params
	 * @return
	 */
	public Long count(final String sql, final Object[] params);
	
	/**
	 * 
	 * 描述: 统计记录数
	 * @author qye.zheng
	 * @param sql
	 * @param params
	 * @return
	 */
	public Long count(final String sql, final List<Object> params);
}
