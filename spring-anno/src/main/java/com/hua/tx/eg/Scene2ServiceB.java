/**
  * @filename Scene2ServiceB.java
  * @description  
  * @version 1.0
  * @author qye.zheng
 */
package com.hua.tx.eg;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

 /**
 * @type Scene2ServiceB
 * @description  场景2-B
 * @author qye.zheng
 */
public class Scene2ServiceB
{
	/**
	 * 
	 * @description 
	 * Transactional(propagation = Propagation.REQUIRED)
	 * 传播默认是 Propagation.REQUIRED
	 * @author qye.zheng
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void doSomething()
	{
		// 抛异常
		throw new RuntimeException("B throw exception");
	}
}
