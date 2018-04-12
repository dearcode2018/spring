/**
  * @filename ValidateResult.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.bean;

 /**
 * @type ValidateResult
 * @description 
 * @author qianye.zheng
 */
public class ValidateResult
{
	
	/* 是否有错误 */
	private boolean error = false;
	
	/* 验证不通过返回的提示消息 */
	private String message;

	/**
	* @return the error
	*/
	public final boolean isError()
	{
		return error;
	}

	/**
	* @param error the error to set
	*/
	public final void setError(boolean error)
	{
		this.error = error;
	}

	/**
	* @return the message
	*/
	public final String getMessage()
	{
		return message;
	}

	/**
	* @param message the message to set
	*/
	public final void setMessage(String message)
	{
		this.message = message;
	}
	
}
