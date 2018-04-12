/**
 * 描述: 
 * PersonThreeDaoImpl.java
 * @author qye.zheng
 * 
 *  version 1.0
 */
package com.hua.dao.three;

import org.springframework.stereotype.Repository;

import com.hua.dao.impl.CoreDaoImpl;
import com.hua.orm.entity.o2o.Person;

/**
 * 描述: 
 * @author qye.zheng
 * 
 * PersonThreeDaoImpl
 */
@Repository
public class PersonThreeDaoImpl extends CoreDaoImpl<Person> implements
		PersonThreeDao
{

}
