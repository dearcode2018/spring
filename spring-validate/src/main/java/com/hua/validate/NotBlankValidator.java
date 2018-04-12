/**
  * @filename NotBlankValidator.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.validate;

import java.lang.reflect.Field;

import com.hua.annotation.NotBlank;
import com.hua.bean.ValidateResult;
import com.hua.util.StringUtil;

/**
 * @type NotBlankValidator
 * @description 
 * @author qianye.zheng
 */
public class NotBlankValidator
{
	
	/**
	 * 
	 * @description 
	 * @param target 校验的目标对象
	 * @return
	 * @author qianye.zheng
	 */
	public static final ValidateResult validate(final Object target)
	{
		final ValidateResult result = new ValidateResult();
		Field[] fields = target.getClass().getDeclaredFields();
		NotBlank notBlank = null;
		for (Field field : fields)
		{
			// 设置为可以访问
			field.setAccessible(true);
			notBlank = field.getAnnotation(NotBlank.class);
			if (null != notBlank)
			{
				try
				{
					Object value = field.get(target);
					if (null == value)
					{
						result.setError(true);
						result.setMessage(notBlank.value());
						
						return result;
					}
					if (value.getClass() == String.class)
					{ // 字符串
						if (StringUtil.isEmpty((String) value))
						{
							result.setError(true);
							result.setMessage(notBlank.value());
					
						}
					} else if (value instanceof Number)
					{ // 数字
						if (0.0 == ((Number) value).doubleValue())
						{
							result.setError(true);
							result.setMessage(notBlank.value());
						}
					}
					
					return result;
				} catch (IllegalArgumentException e1)
				{
					e1.printStackTrace();
				} catch (IllegalAccessException e1)
				{
					e1.printStackTrace();
				}
			}
		}
		
		return result;
	}
}
