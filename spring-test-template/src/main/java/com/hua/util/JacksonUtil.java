/**
 * JacksonUtil.java
 * @author  qye.zheng
 * 	version 1.0
 */
package com.hua.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.hua.constant.FormatConstant;

/**
 * JacksonUtil
 * 描述: Jackson - 工具类
 * @author  qye.zheng
 */
public final class JacksonUtil
{
	// 日期时间格式-默认采用
	private static final DateFormat dateTimeFormat = 
			new SimpleDateFormat(FormatConstant.DATE_TIME_FORMAT_yyyy_MM_dd_HH_mm_ss);
	
	// 对象映射器
	private static final ObjectMapper objectMapper = new ObjectMapper();
	
	// 对象读取器
	private static final ObjectReader objectReader = objectMapper.reader();
	
	// 对象写出器
	private static ObjectWriter objectWriter = objectMapper.writer();
	
	static
	{
		// 设置默认的日期处理格式
		setDefaultDateFormat();
	}
	
	/**
	 * 构造方法
	 * 描述: 私有 - 禁止实例化
	 * @author  qye.zheng
	 */
	private JacksonUtil()
	{
	}

	/* read value 返回单个对象 ================================= */
	
	/**
	 * 
	 * 描述: 解析为对象
	 * @author  qye.zheng
	 * @param jsonString
	 * @return
	 */
	public static final <T> T readValue(final String jsonString)
	{
		T t = null;
		try
		{
			t = objectReader.readValue(jsonString);
		} catch (JsonProcessingException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return t;
	}
	
	/**
	 * 
	 * 描述: 解析为对象
	 * @author  qye.zheng
	 * @param data
	 * @return
	 */
	public static final <T> T readValue(final byte[] data)
	{
		T t = null;
		try
		{
			t = objectReader.readValue(data);
		} catch (JsonProcessingException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return t;
	}
	
	/**
	 * 
	 * 描述: 解析为对象
	 * @author  qye.zheng
	 * @param file 文件对象
	 * @return
	 */
	public static final <T> T readValue(final File file)
	{
		T t = null;
		try
		{
			t = objectReader.readValue(file);
		} catch (JsonProcessingException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return t;
	}

	/**
	 * 
	 * 描述: 解析为对象
	 * @author  qye.zheng
	 * @param inputStream
	 * @return
	 */
	public static final <T> T readValue(final InputStream inputStream)
	{
		T t = null;
		try
		{
			t = objectReader.readValue(inputStream);
		} catch (JsonProcessingException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return t;
	}
	
	/**
	 * 
	 * 描述: 解析为对象
	 * @author  qye.zheng
	 * @param reader
	 * @return
	 */
	public static final <T> T readValue(final Reader reader)
	{
		T t = null;
		try
		{
			t = objectReader.readValue(reader);
		} catch (JsonProcessingException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return t;
	}
	
	/**
	 * 
	 * 描述: 解析为对象
	 * @author  qye.zheng
	 * @param url 链接对象
	 * @return
	 */
	public static final <T> T readValue(final URL url)
	{
		T t = null;
		try
		{
			t = objectReader.readValue(url);
		} catch (JsonProcessingException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return t;
	}
	
	/* read values 返回List ================================= */
	
	/**
	 * 
	 * 描述: 解析为对象集合
	 * @author  qye.zheng
	 * @param jsonString
	 * @return
	 */
	public static final <T> List<T> readValues(final String jsonString)
	{
		List<T> list = null;
		try
		{
			final MappingIterator<T> mappingIterator = objectReader.readValues(jsonString);
			
			list = mappingIterator.readAll();
		} catch (JsonProcessingException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return list;
	}
	
	/**
	 * 
	 * 描述: 解析为对象集合
	 * @author  qye.zheng
	 * @param data
	 * @return
	 */
	public static final <T> List<T> readValues(final byte[] data)
	{
		List<T> list = null;
		try
		{
			final MappingIterator<T> mappingIterator = objectReader.readValues(data);
			
			list = mappingIterator.readAll();
		} catch (JsonProcessingException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return list;
	}
	
	/**
	 * 
	 * 描述: 解析为对象集合
	 * @author  qye.zheng
	 * @param file 文件对象
	 * @return
	 */
	public static final <T> List<T> readValues(final File file)
	{
		List<T> list = null;
		try
		{
			final MappingIterator<T> mappingIterator = objectReader.readValues(file);
			
			list = mappingIterator.readAll();
		} catch (JsonProcessingException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return list;
	}

	/**
	 * 
	 * 描述: 解析为对象集合
	 * @author  qye.zheng
	 * @param inputStream
	 * @return
	 */
	public static final <T> List<T> readValues(final InputStream inputStream)
	{
		List<T> list = null;
		try
		{
			final MappingIterator<T> mappingIterator = objectReader.readValues(inputStream);
			
			list = mappingIterator.readAll();
		} catch (JsonProcessingException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return list;
	}
	
	/**
	 * 
	 * 描述: 解析为对象集合
	 * @author  qye.zheng
	 * @param reader
	 * @return
	 */
	public static final <T> List<T> readValues(final Reader reader)
	{
		List<T> list = null;
		try
		{
			final MappingIterator<T> mappingIterator = objectReader.readValues(reader);
			
			list = mappingIterator.readAll();
		} catch (JsonProcessingException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return list;
	}
	
	/**
	 * 
	 * 描述: 解析为对象集合
	 * @author  qye.zheng
	 * @param url 链接对象
	 * @return
	 */
	public static final <T> List<T> readValues(final URL url)
	{
		List<T> list = null;
		try
		{
			final MappingIterator<T> mappingIterator = objectReader.readValues(url);
			
			list = mappingIterator.readAll();
		} catch (JsonProcessingException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return list;
	}
	
	/* write object ================================= */
	
	/**
	 * 
	 * 描述: 输出对象到文件
	 * @author  qye.zheng
	 * @param file 文件对象
	 * @param value
	 * @return
	 */
	public static final boolean writeValue(final File file, final Object value)
	{
		boolean flag = false;
		try
		{
			objectWriter.writeValue(file, value);
			flag = true;
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return flag;
	}
	
	/**
	 * 
	 * 描述: 输出对象到输出流
	 * @author  qye.zheng
	 * @param outputStream
	 * @param value
	 * @return
	 */
	public static final boolean writeValue(final OutputStream outputStream, final Object value)
	{
		boolean flag = false;
		try
		{
			objectWriter.writeValue(outputStream, value);
			flag = true;
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return flag;
	}
	
	/**
	 * 
	 * 描述: 输出对象到 写入器
	 * @author  qye.zheng
	 * @param writer
	 * @param value
	 * @return
	 */
	public static final boolean writeValue(final Writer writer, final Object value)
	{
		boolean flag = false;
		try
		{
			objectWriter.writeValue(writer, value);
			flag = true;
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return flag;
	}
	
	/**
	 * 
	 * 描述: 输出到内存(字节数组)
	 * @author  qye.zheng
	 * @param value
	 * @return
	 */
	public static final byte[] writeValueAsBytes(final Object value)
	{
		byte[] data = null;
		try
		{
			data = objectWriter.writeValueAsBytes(value);
		} catch (JsonProcessingException e)
		{
			e.printStackTrace();
		}
		
		return data;
	}
	
	/**
	 * 
	 * 描述: 输出到内存(字符串)
	 * @author  qye.zheng
	 * @param value
	 * @return
	 */
	public static final String writeValueAsString(final Object value)
	{
		String data = null;
		try
		{
			data = objectWriter.writeValueAsString(value);
		} catch (JsonProcessingException e)
		{
			e.printStackTrace();
		}
		
		return data;
	}
	
	/**
	 * 
	 * 描述: 输出到内存(字符串)
	 * @author  qye.zheng
	 * @param value
	 * @return
	 */
	public static final String writeValueAsStringWithDf(final Object value)
	{
		String data = null;
		try
		{
			objectWriter = objectWriter.with(dateTimeFormat);
			data = objectWriter.writeValueAsString(value);
		} catch (JsonProcessingException e)
		{
			e.printStackTrace();
		}
		
		return data;
	}	
	/* 特定功能  ================================= */
	
	/**
	 * 
	 * 描述: 输出对象到文件
	 * @author  qye.zheng
	 * @param file 文件对象
	 * @param value
	 * @param includeFields 包含指定字段，为空包含所有字段
	 * @param excludeFields 指定要排除的字段
	 * @return
	 */
	public static final boolean writeValue(final File file, final Object value, 
			final List<String> includeFields, final List<String> excludeFields)
	{
		boolean flag = false;
		try
		{
			
			flag = true;
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return flag;
	}
	
	/**
	 * 
	 * 描述: 输出对象到输出流
	 * @author  qye.zheng
	 * @param outputStream
	 * @param value
	 * @param includeFields 包含指定字段，为空包含所有字段
	 * @param excludeFields 指定要排除的字段
	 * @return
	 */
	public static final boolean writeValue(final OutputStream outputStream, final Object value, 
			final List<String> includeFields, final List<String> excludeFields)
	{
		boolean flag = false;
		try
		{
			
			flag = true;
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return flag;
	}
	
	/**
	 * 
	 * 描述: 输出对象到 写入器
	 * @author  qye.zheng
	 * @param writer
	 * @param value
	 * @return
	 */
	public static final boolean writeValue(final Writer writer, final Object value, 
			final List<String> includeFields, final List<String> excludeFields)
	{
		boolean flag = false;
		try
		{
			
			flag = true;
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return flag;
	}
	
	/**
	 * 
	 * 描述: 输出到内存(字节数组)
	 * @author  qye.zheng
	 * @param value
	 * @param includeFields 包含指定字段，为空包含所有字段
	 * @param excludeFields 指定要排除的字段
	 * @return
	 */
	public static final byte[] writeAsBytes(final Object value, 
			final List<String> includeFields, final List<String> excludeFields)
	{
		return null;
	}
	
	/**
	 * 
	 * 描述: 输出到内存(字符串)
	 * @author  qye.zheng
	 * @param value
	 * @param includeFields 包含指定字段，为空包含所有字段
	 * @param excludeFields 指定要排除的字段
	 * @return
	 */
	public static final String writeAsString(final Object value, 
			final List<String> includeFields, final List<String> excludeFields)
	{
		return null;
	}
	
	/**
	 * 
	 * 描述: 根据字段名称返回对象
	 * @author  qye.zheng
	 * @param jsonString
	 * @param fieldName 字段名称
	 * @return
	 */
	public static final <T> T readValue(final String jsonString, final String fieldName)
	{
		final T t = null;
		
		return t;
	}
	
	/**
	 * 
	 * 描述: 根据字段名称返回对象
	 * @author  qye.zheng
	 * @param data 字节数组
	 * @param fieldName 字段名称
	 * @return
	 */
	public static final <T> T readValue(final byte[] data, final String fieldName)
	{
		final T t = null;
		
		return t;
	}
	
	/**
	 * 
	 * 描述: 
	 * @author  qye.zheng
	 * @param file 文件对象
	 * @param fieldName 字段名称
	 * @return
	 */
	public static final <T> T readValue(final File file, final String fieldName)
	{
		final T t = null;
		
		return t;
	}

	/**
	 * 
	 * 描述: 
	 * @author  qye.zheng
	 * @param inputStream 输入流
	 * @param fieldName 字段名称
	 * @return
	 */
	public static final <T> T readValue(final InputStream inputStream, final String fieldName)
	{
		final T t = null;
		
		return t;
	}
	
	/**
	 * 
	 * 描述: 根据字段名称返回对象
	 * @author  qye.zheng
	 * @param reader
	 * @param fieldName 字段名称
	 * @return
	 */
	public static final <T> T readValue(final Reader reader, final String fieldName)
	{
		final T t = null;
		
		return t;
	}
	
	/**
	 * 
	 * 描述: 根据字段名称返回对象
	 * @author  qye.zheng
	 * @param url 链接对象
	 * @param fieldName 字段名称
	 * @return
	 */
	public static final <T> T readValue(final URL url, final String fieldName)
	{
		final T t = null;
		
		return t;
	}
	
	/**
	 * 
	 * 描述: 根据字段名称返回对象列表
	 * @author  qye.zheng
	 * @param jsonString
	 * @param fieldName 字段名称
	 * @return
	 */
	public static final <T> List<T> readValues(final String jsonString, final String fieldName)
	{
		List<T> t = null;
		
		return t;
	}
	
	/**
	 * 
	 * 描述: 根据字段名称返回对象列表
	 * @author  qye.zheng
	 * @param data
	 * @param fieldName 字段名称
	 * @return
	 */
	public static final <T> List<T> readValues(final byte[] data, final String fieldName)
	{
		List<T> t = null;
		
		return t;
	}
	
	/**
	 * 
	 * 描述: 根据字段名称返回对象列表
	 * @author  qye.zheng
	 * @param file 文件对象
	 * @param fieldName 字段名称
	 * @return
	 */
	public static final <T> List<T> readValues(final File file, final String fieldName)
	{
		List<T> t = null;
		
		return t;
	}

	/**
	 * 
	 * 描述: 根据字段名称返回对象列表
	 * @author  qye.zheng
	 * @param inputStream
	 * @param fieldName 字段名称
	 * @return
	 */
	public static final <T> List<T> readValues(final InputStream inputStream, final String fieldName)
	{
		List<T> t = null;
		
		return t;
	}
	
	/**
	 * 
	 * 描述: 根据字段名称返回对象列表
	 * @author  qye.zheng
	 * @param reader
	 * @param fieldName 字段名称
	 * @return
	 */
	public static final <T> List<T> readValues(final Reader reader, final String fieldName)
	{
		List<T> t = null;
		
		return t;
	}
	
	/**
	 * 
	 * 描述: 根据字段名称返回对象列表
	 * @author  qye.zheng
	 * @param url 链接对象
	 * @param fieldName 字段名称
	 * @return
	 */
	public static final <T> List<T> readValues(final URL url, final String fieldName)
	{
		List<T> t = null;
		
		return t;
	}
	
	
	/* 日期处理  ================================= */
	
	/**
	 * 
	 * 描述: 设置日期格式
	 * 该设置会影响全局日期解析
	 * @author  qye.zheng
	 * @param dateFormat
	 */
	public static final void setDateFormat(final DateFormat dateFormat)
	{
		objectMapper.setDateFormat(dateFormat);
	}
	
	/**
	 * 
	 * 描述: 使用默认的日期解析格式
	 * @author  qye.zheng
	 */
	public static final void setDefaultDateFormat()
	{
		objectMapper.setDateFormat(dateTimeFormat);
	}
	
	
}
