/**
 * 描述: 
 * HttpDebugParam.java
 * @author	qye.zheng
 *  version 1.0
 */
package com.hua.bean;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.hua.constant.Constant;
import com.hua.util.ArrayUtil;
import com.hua.util.ReadProperties;
import com.hua.util.StringUtil;

/**
 * 描述: 公共 - 拷贝参数
 * @author  qye.zheng
 * HttpDebugParam
 */
public class HttpDebugParam
{
	
	/* 协议类型 默认是 http */
	private String protocol = "http";
	
	/* IP地址 */
	private String address;
	
	/* 端口号 */
	private String port = "80";
	
	/* 请求方法 */
	private String requestMethod = "get";
	
	/* 应用上下文 */
	private String contextPath;
	
	/* 接口/服务后缀路径 */
	private String suffixPath;
	
	// 使用2个等号，防止value里面有等号
	/* key=value多个逗号隔开 (例如Content-Type==application/json;charset==UTF-8) */
	private String[] headers;
	
	/* 请求参数, json或xml字符串 */
	private String requestData;
	
	/**
	 * Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*\/*;q=0.8
	 */
	private String[] accepts;
	
	/* 内容类型 */
	private String contentType;
	
	/* 请求参数 */
	private String params;
	
	/* 文件上传_本地路径 */
	private String uploadPath;
	
	/* 请求的url */
	private String requestUrl;
	
	public static final String HEADER_ACCEPT = "Accept";
	
	private static final String CONFIG_PATH = "/conf/properties/http-debug.properties";
	
	private static final ReadProperties props = new ReadProperties(CONFIG_PATH);
	
	/**
	 * 构造方法
	 * 描述: 
	 * @author qye.zheng
	 */
	public HttpDebugParam()
	{
	}

	/**
	 * @return the protocol
	 */
	public final String getProtocol()
	{
		return protocol;
	}

	/**
	 * @param protocol the protocol to set
	 */
	public final void setProtocol(String protocol)
	{
		this.protocol = protocol;
	}

	/**
	 * @return the address
	 */
	public final String getAddress()
	{
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public final void setAddress(String address)
	{
		this.address = address;
	}

	/**
	 * @return the port
	 */
	public final String getPort()
	{
		return port;
	}

	/**
	 * @param port the port to set
	 */
	public final void setPort(String port)
	{
		this.port = port;
	}

	/**
	 * @return the requestMethod
	 */
	public final String getRequestMethod()
	{
		return requestMethod;
	}

	/**
	 * @param requestMethod the requestMethod to set
	 */
	public final void setRequestMethod(String requestMethod)
	{
		this.requestMethod = requestMethod;
	}

	/**
	 * @return the contextPath
	 */
	public final String getContextPath()
	{
		return contextPath;
	}

	/**
	 * @param contextPath the contextPath to set
	 */
	public final void setContextPath(String contextPath)
	{
		this.contextPath = contextPath;
	}

	/**
	 * @return the suffixPath
	 */
	public final String getSuffixPath()
	{
		return suffixPath;
	}

	/**
	 * @param suffixPath the suffixPath to set
	 */
	public final void setSuffixPath(String suffixPath)
	{
		this.suffixPath = suffixPath;
	}

	/**
	 * @return the accepts
	 */
	public final String[] getAccepts()
	{
		return accepts;
	}

	/**
	 * @param accepts the accepts to set
	 */
	public final void setAccepts(String[] accepts)
	{
		this.accepts = accepts;
	}

	/**
	 * @return the contentType
	 */
	public final String getContentType()
	{
		return contentType;
	}

	/**
	 * @param contentType the contentType to set
	 */
	public final void setContentType(String contentType)
	{
		this.contentType = contentType;
	}

	/**
	 * @return the params
	 */
	public final String getParams()
	{
		return params;
	}

	/**
	 * @param params the params to set
	 */
	public final void setParams(String params)
	{
		this.params = params;
	}

	/**
	 * @return the uploadPath
	 */
	public final String getUploadPath()
	{
		return uploadPath;
	}

	/**
	 * @param uploadPath the uploadPath to set
	 */
	public final void setUploadPath(String uploadPath)
	{
		this.uploadPath = uploadPath;
	}

	/**
	 * @return the requestUrl
	 */
	public final String getRequestUrl()
	{
		// http://127.0.0.1:8080/appName/suffixPath?a=1&b=2
		requestUrl = protocol + Constant.COLON + Constant.SLASH +  Constant.SLASH
				+ address + Constant.COLON + port
				+ Constant.SLASH + contextPath
				+ Constant.SLASH + suffixPath;
		
		// 查询参数
		if (!StringUtil.isEmpty(params))
		{
			requestUrl += Constant.QUESTION_MARK + params;
		}
		
		return requestUrl;
	}

	/**
	 * @param requestUrl the requestUrl to set
	 */
	public final void setRequestUrl(String requestUrl)
	{
		this.requestUrl = requestUrl;
	}

	/**
	 * @return the headers
	 */
	public final String[] getHeaders()
	{
		return headers;
	}

	/**
	 * @param headers the headers to set
	 */
	public final void setHeaders(String[] headers)
	{
		this.headers = headers;
	}

	/**
	 * @return the requestData
	 */
	public final String getRequestData()
	{
		return requestData;
	}

	/**
	 * @param requestData the requestData to set
	 */
	public final void setRequestData(String requestData)
	{
		this.requestData = requestData;
	}

	/**
	 * 
	 * @description 获取实例化
	 * @return
	 * @author qye.zheng
	 */
	public static final HttpDebugParam getInstance()
	{
		return HttpDebugParamStaticInnerClass.instance;
	}
	
	/**
	 * 
	 * @type HttpDebugParamStaticInnerClass
	 * @description  单例实现方式 - 静态内部类
	 * @author qye.zheng
	 */
	private static final class HttpDebugParamStaticInnerClass
	{
		private static final HttpDebugParam instance = new HttpDebugParam();
		static
		{
			instance.setProtocol(props.getProperty("http.debug.protocol"));
			instance.setAddress(props.getProperty("http.debug.address"));
			instance.setPort(props.getProperty("http.debug.port"));
			instance.setRequestMethod(props.getProperty("http.debug.request.method"));
			instance.setContextPath(props.getProperty("http.debug.context.path"));
			instance.setSuffixPath(props.getProperty("http.debug.suffix.path"));
			final String headers = props.getProperty("http.debug.headers");
			// 拦截空设置
			if (!StringUtil.isEmpty(headers))
			{
				final String[] headerValues = headers.split(Constant.COMMA);
				ArrayUtil.trim(headerValues);
				instance.setHeaders(headerValues);
			}
			// 
			final String acceptValue = props.getProperty("http.debug.accepts");
			// 拦截空设置
			if (!StringUtil.isEmpty(acceptValue))
			{
				final String[] acceptValues = acceptValue.split(Constant.COMMA);
				ArrayUtil.trim(acceptValues);
				instance.setAccepts(acceptValues);
			}
			instance.setContentType(props.getProperty("http.debug.content.type"));
			instance.setParams(props.getProperty("http.debug.params"));
			instance.setUploadPath(props.getProperty("http.debug.file.upload.path"));
		}
	}
	
	/**
	 * 描述: 
	 * @author qye.zhenge
	 * 
	 * @return
	 */
	@Override
	public String toString()
	{
		return new ReflectionToStringBuilder(this).toString();
	}

}
