/**
  * @filename PersonTwoServiceImpl.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.service.two;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hua.dao.two.PersonTwoDao;
import com.hua.service.impl.CoreServiceImpl;

 /**
 * @type PersonTwoServiceImpl
 * @description 
 * @author qianye.zheng
 */
@Service
public class PersonTwoServiceImpl extends CoreServiceImpl implements PersonTwoService
{

	@Resource
	private PersonTwoDao personTwoDao;
	
	/**
	 * 
	 * @description 
	 * @author qianye.zheng
	 */
	//@Transactional
	@Override
	public void insert()
	{
		System.out.println("3.PersonTwoService.insert()");
		String sql = "INSERT INTO person_01 (name, photoUrl, gender, nation, birthday, address, cardId) VALUES ('徐明afadsf', null, 'Male', '汉族', '1973-01-16', '广东省广州市天河区平云路11号', null);";
		personTwoDao.insert(sql);
	}
	
}
