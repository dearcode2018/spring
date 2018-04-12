/**
 * 描述: 
 * PersonOneDaoImpl.java
 * @author qye.zheng
 * 
 *  version 1.0
 */
package com.hua.dao.one;

import org.springframework.stereotype.Repository;

import com.hua.dao.impl.CoreDaoImpl;
import com.hua.orm.entity.o2o.Person;

/**
 * 描述: 
 * @author qye.zheng
 * 
 * PersonOneDaoImpl
 */
@Repository
public class PersonOneDaoImpl extends CoreDaoImpl<Person> implements
		PersonOneDao
{


}
