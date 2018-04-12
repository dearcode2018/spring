/**
  * @filename PersonOneServiceImpl.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.service.one;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hua.dao.one.PersonOneDao;
import com.hua.service.impl.CoreServiceImpl;
import com.hua.service.two.PersonTwoService;
import com.sun.media.jfxmedia.logging.Logger;

 /**
 * @type PersonOneServiceImpl
 * @description 
 * @author qianye.zheng
 */
@Service
public class PersonOneServiceImpl extends CoreServiceImpl implements PersonOneService
{

	
	@Resource
	private PersonOneDao personOneDao;
	
	@Resource
	private PersonTwoService personTwoService;
	
	/**
	 * 
	 * @description 
	 * @author qianye.zheng
	 */
	@Override
	public void insert()
	{
		System.out.println("3.PersonOneService.insert()");
		// 调用其他service方法，执行完成之后，再执行当前service中事务方法
		personTwoService.insert();
		// 其他service方法执行完毕，然后再执行当前service中的方法
		log.info("其他service方法执行完毕，然后再执行当前service中的方法");
		String sql = "INSERT INTO person_01 (name, photoUrl, gender, nation, birthday, address, cardId) VALUES ('徐明1', null, 'Male', '汉族', '1973-01-16', '广东省广州市天河区平云路11号', null);";
		personOneDao.insert(sql);
		
	}
}
