/**
 * 描述: 
 * CustomDateSerializer.java
 * @author qye.zheng
 * 
 *  version 1.0
 */
package com.hua.util;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.hua.constant.FormatConstant;

/**
 * 描述: 
 * @author qye.zheng
 * 
 * CustomDateSerializer
 */
public class CustomDateSerializer extends JsonSerializer<Date>
{
	 /**
	 * 描述: 
	 * @author qye.zheng
	 * 
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @throws IOException
	 * @throws JsonProcessingException
	 */
    @Override  
    public void serialize(Date value, JsonGenerator jsonGen, SerializerProvider provider) throws IOException, JsonProcessingException 
    {  
        final DateFormat format = new SimpleDateFormat(FormatConstant.DATE_TIME_FORMAT_yyyy_MM_dd_HH_mm_ss);  
        final String formattedDate = format.format(value);  
        jsonGen.writeString(formattedDate);
    } 
}
