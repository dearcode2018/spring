/**
  * @filename SystemStartup.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.service.sys;

import org.springframework.beans.factory.config.BeanPostProcessor;

 /**
 * @type SystemStartup
 * @description 
 * @author qianye.zheng
 */
//public interface SystemStartup extends CoreService, InitializingBean, ServletContextAware
public interface SystemStartup extends BeanPostProcessor
{

}
