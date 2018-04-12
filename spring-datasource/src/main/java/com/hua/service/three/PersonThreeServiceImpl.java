/**
  * @filename PersonThreeServiceImpl.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.service.three;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hua.dao.three.PersonThreeDao;
import com.hua.service.impl.CoreServiceImpl;

 /**
 * @type PersonThreeServiceImpl
 * @description 
 * @author qianye.zheng
 */
@Service
public class PersonThreeServiceImpl extends CoreServiceImpl implements PersonThreeService
{
	
	@Resource
	private PersonThreeDao personThreeDao;
	
	/**
	 * 
	 * @description 
	 * @author qianye.zheng
	 */
	@Override
	public void insert()
	{
		System.out.println("3.PersonThreeService.insert()");
		String sql = "INSERT INTO person_01 (name, photoUrl, gender, nation, birthday, address, cardId) VALUES ('徐明afadsf', null, 'Male', '汉族', '1973-01-16', '广东省广州市天河区平云路11号', null);";
		personThreeDao.insert(sql);
	}
	
}
