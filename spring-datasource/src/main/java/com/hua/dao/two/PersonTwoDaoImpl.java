/**
 * 描述: 
 * PersonTwoDaoImpl.java
 * @author qye.zheng
 * 
 *  version 1.0
 */
package com.hua.dao.two;

import org.springframework.stereotype.Repository;

import com.hua.dao.impl.CoreDaoImpl;
import com.hua.orm.entity.o2o.Person;

/**
 * 描述: 
 * @author qye.zheng
 * 
 * PersonTwoDaoImpl
 */
@Repository
public class PersonTwoDaoImpl extends CoreDaoImpl<Person> implements
		PersonTwoDao
{

}
