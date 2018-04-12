/**
  * @filename Scene3ServiceA.java
  * @description  
  * @version 1.0
  * @author qye.zheng
 */
package com.hua.tx.eg;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

 /**
 * @type Scene3ServiceA
 * @description  场景3-A
 * @author qye.zheng
 */
public class Scene3ServiceA
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
		new Scene3ServiceB().doSomething();
	}
}
