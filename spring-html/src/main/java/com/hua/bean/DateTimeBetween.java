/**
  * @filename DateTimeBetween.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.bean;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hua.serializer.DateDeserializer;
import com.hua.serializer.DateTimeDeserializer;
import com.hua.serializer.DateTimeSerializer;
import com.thoughtworks.xstream.annotations.XStreamAlias;

 /**
 * @type DateTimeBetween
 * @description 
 * @author qianye.zheng
 */
//@XStreamAlias("dtBetween")
public class DateTimeBetween
{
	@JsonSerialize(using = DateTimeSerializer.class)
	// 特地 用日期类型反序列化
	@JsonDeserialize(using = DateDeserializer.class)
	private Date startDateTime;
	
	@JsonSerialize(using = DateTimeSerializer.class)
	@JsonDeserialize(using = DateTimeDeserializer.class)
	private Date endDateTime;

	/**
	 * @return the startDateTime
	 */
	public final Date getStartDateTime()
	{
		return startDateTime;
	}

	/**
	 * @param startDateTime the startDateTime to set
	 */
	public final void setStartDateTime(Date startDateTime)
	{
		this.startDateTime = startDateTime;
	}

	/**
	 * @return the endDateTime
	 */
	public final Date getEndDateTime()
	{
		return endDateTime;
	}

	/**
	 * @param endDateTime the endDateTime to set
	 */
	public final void setEndDateTime(Date endDateTime)
	{
		this.endDateTime = endDateTime;
	}
	
}
