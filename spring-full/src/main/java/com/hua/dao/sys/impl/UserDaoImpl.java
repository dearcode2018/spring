/**
  * @filename UserDaoImpl.java
  * @description  
  * @version 1.0
  * @author qye.zheng
 */
package com.hua.dao.sys.impl;

import org.springframework.stereotype.Repository;

import com.hua.dao.impl.CoreDaoImpl;
import com.hua.dao.sys.UserDao;
import com.hua.entity.User;

 /**
 * @type UserDaoImpl
 * @description  
 * @author qye.zheng
 */
@Repository
public final class UserDaoImpl 
	extends CoreDaoImpl<User> implements UserDao {

	/**
	 * @description 
	 * @param username
	 * @return
	 * @author qye.zheng
	 */
	@Override
	public User getByUsername(String username) {
		return null;
	}

	/**
	 * @description 
	 * @param id
	 * @return
	 * @author qye.zheng
	 */
	@Override
	public User getById(String id) {
		return null;
	}

}
