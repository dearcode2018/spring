/**
  * @filename NotBlank.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @type NotBlank
 * @description 非空
 * @author qianye.zheng
 */
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotBlank
{

	/**
	 * 字符串为空判断、对象为空判断，数值为空或0的判断
	 * 
	 * 
	 */
	
	public String value() default "参数不能为空";
	
}
