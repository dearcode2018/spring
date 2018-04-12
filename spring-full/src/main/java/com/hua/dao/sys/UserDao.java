/**
  * @filename UserDao.java
  * @description  
  * @version 1.0
  * @author qye.zheng
 */
package com.hua.dao.sys;

import com.hua.dao.CoreDao;
import com.hua.entity.User;

 /**
 * @type UserDao
 * @description  
 * @author qye.zheng
 */
public interface UserDao extends CoreDao<User>
{
	/**
	 * 
	 * @description 
	 * @param id
	 * @return
	 * @author qye.zheng
	 */
	public User getById(final String id);
	
	/**
	 * 
	 * @description 
	 * @param username
	 * @return
	 * @author qye.zheng
	 */
	public User getByUsername(final String username);
}
