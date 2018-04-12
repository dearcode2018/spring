/**
  * @filename JsonObjectMapper.java
  * @description  
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.mapper;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;

 /**
 * @type JsonObjectMapper
 * @description Json对象映射器
 * @author qianye.zheng
 */
public class JsonObjectMapper extends ObjectMapper
{

	private static final long serialVersionUID = 1L;
	
	/**
	 * @description 构造方法
	 * @author qianye.zheng
	 */
	public JsonObjectMapper()
	{
		super();
		// 空值(null) 处理为字符串
		this.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object> () {
			/**
			 * @description 
			 * @param value
			 * @param gen
			 * @param serializers
			 * @throws IOException
			 * @throws JsonProcessingException
			 * @author qianye.zheng
			 */
			@Override
			public void serialize(Object value, JsonGenerator gen,
					SerializerProvider serializers) throws IOException,
					JsonProcessingException
			{
				//System.out.println("空值处理: " + value);
				//
				gen.writeString("");
			}
		});
	}
	

}
