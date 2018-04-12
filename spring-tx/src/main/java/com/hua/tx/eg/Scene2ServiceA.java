/**
  * @filename Scene2ServiceA.java
  * @description  
  * @version 1.0
  * @author qye.zheng
 */
package com.hua.tx.eg;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

 /**
 * @type Scene2ServiceA
 * @description  场景2-A
 * @author qye.zheng
 */
public class Scene2ServiceA
{
	
	/**
	 * 
	 * @description 
	 * Transactional(propagation = Propagation.REQUIRED)
	 * 传播默认是 Propagation.REQUIRED
	 * @author qye.zheng
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void callB()
	{
		try
		{
			new Scene2ServiceB().doSomething();
		} catch (RuntimeException e)
		{
			e.printStackTrace();
		}
		// 捕获完异常之后，方法结束，事务则 抛出如下异常
		/**
		 * 异常信息
		 * org.springframework.transaction.UnexpectedRollbackException: 
		 * Transaction rolled back because it has been marked as rollback-only
		 */
	}
}
