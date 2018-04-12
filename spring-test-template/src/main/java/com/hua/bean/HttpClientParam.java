/**
 * HttpClientParam.java
 * @author  qye.zheng
 * 	version 1.0
 */
package com.hua.bean;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.hua.constant.Constant;
import com.hua.util.ArrayUtil;
import com.hua.util.EmptyUtil;
import com.hua.util.ReadProperties;
import com.hua.util.StringUtil;

/**
 * HttpClientParam
 * 描述: HTTP 客户端参数
 * @author  qye.zheng
 */
public final class HttpClientParam
{

	private static final String HTTP_PREFIX = "http://";
	
	private String requestUrl;
	
	/* 服务主机 或 IP 地址 */
	private String host;
	
	/* 端口号 */
	private String port;
	
	/* 请求路径 */
	private String path;
	
	/* 请求方法 get / post / delete / put / delete  */
	private String method;
	
	/* cookie 名称集合 */
	private String[] cookieNames ;
	
	/* cookie 值集合 */
	private String[] cookieValues ;
	
	/* 内容类型 */
	private String contentType;
	
	/* 参数名称集合 */
	private String[] paramNames;
	
	/* 参数值集合 */
	private String[] paramValues;
	
	/* 是否是文件上传 */
	private boolean isUpload;
	
	/* 文件上传(本地存放)相对路径 */
	private String uploadRelativePath;
	
	/* 是否是文件下载 */
	private boolean isDownload;
	
	/* 文件下载(本地存放)相对路径 */
	private String downloadRelativePath;
	
	private static final String CONFIG_PATH = "/conf/properties/httpclient.properties";
	
	private static final ReadProperties props = new ReadProperties(CONFIG_PATH);
	
	// 单例
	private static HttpClientParam instance;
	
	static
	{
		instance = new HttpClientParam();
		
		//
		instance.setHost(props.getProperty("http.client.request.host"));
		instance.setPort(props.getProperty("http.client.request.port"));
		instance.setPath(props.getProperty("http.client.request.path"));
		
		instance.setMethod(props.getProperty("http.client.request.method"));
		
		// 内容类型
		instance.setContentType(props.getProperty("http.client.request.content.type"));
		
		// cookie names
		final String cookieName = props.getProperty("http.client.cookie.names");
		// 拦截空设置
		if (!StringUtil.isEmpty(cookieName))
		{
			final String[] cookieNames = cookieName.split(Constant.COMMA);
			ArrayUtil.trim(cookieNames);
			instance.setCookieNames(cookieNames);
		}
		
		// cookie values
		final String cookieValue = props.getProperty("http.client.cookie.values");
		// 拦截空设置
		if (!StringUtil.isEmpty(cookieValue))
		{
			final String[] cookieValues = cookieValue.split(Constant.COMMA);
			ArrayUtil.trim(cookieValues);
			instance.setCookieValues(cookieValues);
		}
		
		// param names
		final String paramName = props.getProperty("http.client.request.param.names");
		// 拦截空设置
		if (!StringUtil.isEmpty(paramName))
		{
			final String[] paramNames = paramName.split(Constant.COMMA);
			ArrayUtil.trim(paramNames);
			instance.setParamNames(paramNames);
		}
		
		// param values
		final String paramValue = props.getProperty("http.client.request.param.values");
		// 拦截空设置
		if (!StringUtil.isEmpty(paramValue))
		{
			final String[] paramValues = paramValue.split(Constant.COMMA);
			ArrayUtil.trim(paramValues);
			instance.setParamValues(paramValues);
		}
		
		// 拼接请求url
		instance.setRequestUrl(assembleUrl());
		
		// 是否是文件上传
		instance.setUpload(Boolean.parseBoolean(props.getProperty("http.client.file.upload.flag")));
		instance.setUploadRelativePath(props.getProperty("http.client.file.upload.relative.path"));
		
		// 是否是文件下载
		instance.setDownload(Boolean.parseBoolean(props.getProperty("http.client.file.download.flag")));
		instance.setDownloadRelativePath(props.getProperty("http.client.file.download.relative.path"));
	}
	
	/**
	 * 构造方法
	 * 描述: 
	 * @author  qye.zheng
	 */
	private HttpClientParam()
	{
	}

	/**
	 * @param host the host to set
	 */
	private final void setHost(String host)
	{
		this.host = host;
	}

	/**
	 * @param port the port to set
	 */
	private final void setPort(String port)
	{
		this.port = port;
	}

	/**
	 * @param path the path to set
	 */
	private final void setPath(String path)
	{
		this.path = path;
	}

	/**
	 * @param method the method to set
	 */
	private final void setMethod(String method)
	{
		this.method = method;
	}

	/**
	 * @param cookieNames the cookieNames to set
	 */
	private final void setCookieNames(String[] cookieNames)
	{
		this.cookieNames = cookieNames;
	}

	/**
	 * @param cookieValues the cookieValues to set
	 */
	private final void setCookieValues(String[] cookieValues)
	{
		this.cookieValues = cookieValues;
	}

	/**
	 * @param contentType the contentType to set
	 */
	private final void setContentType(String contentType)
	{
		this.contentType = contentType;
	}

	/**
	 * @param paramNames the paramNames to set
	 */
	private final void setParamNames(String[] paramNames)
	{
		this.paramNames = paramNames;
	}

	/**
	 * @param paramValues the paramValues to set
	 */
	private final void setParamValues(String[] paramValues)
	{
		this.paramValues = paramValues;
	}

	/**
	 * @param isUpload the isUpload to set
	 */
	private final void setUpload(boolean isUpload)
	{
		this.isUpload = isUpload;
	}

	/**
	 * @param uploadRelativePath the uploadRelativePath to set
	 */
	private final void setUploadRelativePath(String uploadRelativePath)
	{
		this.uploadRelativePath = uploadRelativePath;
	}

	/**
	 * @param isDownload the isDownload to set
	 */
	private final void setDownload(boolean isDownload)
	{
		this.isDownload = isDownload;
	}

	/**
	 * @param downloadRelativePath the downloadRelativePath to set
	 */
	private final void setDownloadRelativePath(String downloadRelativePath)
	{
		this.downloadRelativePath = downloadRelativePath;
	}

	/**
	 * @return the host
	 */
	public final String getHost()
	{
		return host;
	}

	/**
	 * @return the port
	 */
	public final String getPort()
	{
		return port;
	}

	/**
	 * @return the path
	 */
	public final String getPath()
	{
		return path;
	}

	/**
	 * @return the method
	 */
	public final String getMethod()
	{
		return method;
	}

	/**
	 * @return the cookieNames
	 */
	public final String[] getCookieNames()
	{
		return cookieNames;
	}

	/**
	 * @return the cookieValues
	 */
	public final String[] getCookieValues()
	{
		return cookieValues;
	}

	/**
	 * @return the contentType
	 */
	public final String getContentType()
	{
		return contentType;
	}

	/**
	 * @return the paramNames
	 */
	public final String[] getParamNames()
	{
		return paramNames;
	}

	/**
	 * @return the paramValues
	 */
	public final String[] getParamValues()
	{
		return paramValues;
	}

	/**
	 * @return the isUpload
	 */
	public final boolean isUpload()
	{
		return isUpload;
	}

	/**
	 * @return the uploadRelativePath
	 */
	public final String getUploadRelativePath()
	{
		return uploadRelativePath;
	}

	/**
	 * @return the isDownload
	 */
	public final boolean isDownload()
	{
		return isDownload;
	}

	/**
	 * @return the downloadRelativePath
	 */
	public final String getDownloadRelativePath()
	{
		return downloadRelativePath;
	}

	/**
	 * @return the instance
	 */
	public static final HttpClientParam getInstance()
	{
		return instance;
	}

	/**
	 * @return the requestUrl
	 */
	public final String getRequestUrl()
	{
		return requestUrl;
	}

	/**
	 * @param requestUrl the requestUrl to set
	 */
	private final void setRequestUrl(String requestUrl)
	{
		this.requestUrl = requestUrl;
	}

	/**
	 * 
	 * 描述: 组装请求url
	 * @author  qye.zheng
	 * @param param
	 * @return
	 */
	private static final String assembleUrl()
	{
		final StringBuilder builder = StringUtil.getBuilder();
		try
		{
			builder.append(HTTP_PREFIX);
			builder.append(instance.getHost() + ":" + instance.getPort() + instance.getPath());
			if (!EmptyUtil.isEmpty(instance.getParamNames()))
			{
				// 判断是否已经携带参数 (是否有?)
				if (Constant.NEGATIVE_ONE == builder.lastIndexOf(Constant.QUESTION_MARK))
				{
					// 没有参数
					builder.append(Constant.QUESTION_MARK);
				} else
				{
					// 已有参数
					builder.append(Constant.AND_MARK);
				}
				for (int i = 0; i < instance.getParamNames().length; i++)
				{
					builder.append(URLEncoder.encode(instance.getParamNames()[i], Constant.CHART_SET_ISO_8859_1));
					// 等号
					builder.append(Constant.EQUAL_SIGN);
					builder.append(URLEncoder.encode(instance.getParamValues()[i], Constant.CHART_SET_ISO_8859_1));
					// & 号
					builder.append(Constant.AND_MARK);
				}
				// 将最后一个 & 删除掉
				builder.deleteCharAt(builder.length() - 1);
			}
		} catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		
		return builder.toString();
	}
	
}
