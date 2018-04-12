/**
  * @filename Scene3ServiceB.java
  * @description  
  * @version 1.0
  * @author qye.zheng
 */
package com.hua.tx.eg;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

 /**
 * @type Scene3ServiceB
 * @description  场景3-B
 * @author qye.zheng
 */
public class Scene3ServiceB
{
	/**
	 * 
	 * @description 
	 * Transactional(propagation = Propagation.REQUIRED)
	 * 传播默认是 Propagation.REQUIRED
	 * Propagation.REQUIRES_NEW 创建一个新事物，挂起当前正在
	 * 运行的事务，等这个新事物执行完毕，再启动上一个方法的事务.
	 * @author qye.zheng
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void doSomething()
	{
		// 抛异常
		throw new RuntimeException("B throw exception");
	}
}
