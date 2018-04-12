/**
 * 描述: 
 * HttpDebugDriver.java
 * @author	qye.zheng
 *  version 1.0
 */
package com.hua.driver;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import com.hua.bean.HttpDebugParam;
import com.hua.constant.Constant;
import com.hua.log.BaseLog;
import com.hua.util.EmptyUtil;
import com.hua.util.StringUtil;


/**
 * 描述: HTTP 调试 - 驱动器
 * @author  qye.zheng
 * HttpDebugDriver
 */
public class HttpDebugDriver extends BaseLog
{
	
	public HttpClient httpClient;
	
	public HttpGet httpGet;
	
	public HttpPost httpPost;
	
	public HttpRequest request;
	
	public HttpResponse response;
	
	public OutputStream output;
	
	public InputStream input;
	
	public URL serverUrl;
	
	public HttpURLConnection httpUrlConn;
	
	public static String testUrl = "http://127.0.0.1:8080/servlet3/TestServlet";
	
	private static final HttpDebugParam param = HttpDebugParam.getInstance();
	
	/**
	 * 构造方法
	 * 描述: 
	 * @author qye.zheng
	 */
	private HttpDebugDriver()
	{
	}
	
	/**
	 * 
	 * 描述: post 请求
	 * @author  qye.zheng
	 * @return
	 */
	public static final boolean post()
	{
		boolean flag = false;
		String result = null;

		HttpClient httpClient = null;

		HttpPost httpPost = null;

		HttpRequest request = null;

		HttpResponse response = null;

		OutputStream output = null;

		InputStream input = null;

		URL serverUrl = null;

		HttpURLConnection httpUrlConn = null;
		try
		{
			/**
			 * org.apache.http.client.HttpClient
			 * 
			 * 通过 HttpClientBuilder 来构建HttpClient 对象
			 * 
			 * DefaultHttpClient 等实现对象已经过时，不推荐使用
			 */
			httpClient = HttpClientBuilder.create().build();
			// http get 实例
			httpPost = new HttpPost(param.getRequestUrl());
			System.out.println(param.getRequestUrl());
			if (!EmptyUtil.isEmpty(param.getAccepts()))
			{
				for (String accept : param.getAccepts())
				{
					httpPost.addHeader(HttpDebugParam.HEADER_ACCEPT, accept);
				}
			}
			// 设置头部
			if (!EmptyUtil.isEmpty(param.getHeaders()))
			{
				String key = null;
				String value = null;
				String[] headers = null;
				for (String header : param.getHeaders())
				{
					headers = header.split(Constant.EQUAL_SIGN + Constant.EQUAL_SIGN);
					key = headers[0];
					value = headers[1];
					httpPost.setHeader(key, value);
				}
			}
			HttpEntity stringEntity = new StringEntity(param.getRequestData());
			httpPost.setEntity(stringEntity);
			response = httpClient.execute(httpPost);
			
			if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode())
			{
				// 成功响应 200 ok
				input = response.getEntity().getContent();
				result = StringUtil.streamToString(input);
				System.out.println("请求成功 ===== 响应数据如下: ");
				System.out.println(result);
			} else
			{
				// 请求失败
				input = response.getEntity().getContent();
				result = StringUtil.streamToString(input);
				System.out.println("请求失败 ===== 响应数据如下: ");
				System.out.println(result);				
			}
			flag = true;
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return flag;
	}	
	
	/**
	 * 
	 * 描述: get 请求
	 * @author  qye.zheng
	 * @return
	 */
	public static final boolean get()
	{
		boolean flag = false;
		
		String result = null;

		HttpClient httpClient = null;

		HttpGet httpGet = null;

		HttpRequest request = null;

		HttpResponse response = null;

		OutputStream output = null;

		InputStream input = null;

		URL serverUrl = null;

		HttpURLConnection httpUrlConn = null;
		try
		{
			/**
			 * org.apache.http.client.HttpClient
			 * 
			 * 通过 HttpClientBuilder 来构建HttpClient 对象
			 * 
			 * DefaultHttpClient 等实现对象已经过时，不推荐使用
			 */
			httpClient = HttpClientBuilder.create().build();
			// http get 实例
			httpGet = new HttpGet(param.getRequestUrl());
			//httpGet.setHeader("Content-Type", param.getContentType());
			//httpGet.setHeader("Accept", "application/xml");
			if (!EmptyUtil.isEmpty(param.getAccepts()))
			{
				for (String accept : param.getAccepts())
				{
					httpGet.addHeader(HttpDebugParam.HEADER_ACCEPT, accept);
				}
			}
			// 设置头部
			if (!EmptyUtil.isEmpty(param.getHeaders()))
			{
				String key = null;
				String value = null;
				String[] headers = null;
				for (String header : param.getHeaders())
				{
					headers = header.split(Constant.EQUAL_SIGN + Constant.EQUAL_SIGN);
					key = headers[0];
					value = headers[1];
					System.out.println(key + "=" + value);
					httpGet.setHeader(key, value);
				}
			}
			response = httpClient.execute(httpGet);
			if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode())
			{
				// 成功响应 200 ok
				input = response.getEntity().getContent();
				result = StringUtil.streamToString(input);
				System.out.println("请求成功 ===== 响应数据如下: ");
				System.out.println(result);
			} else
			{
				// 请求失败
				input = response.getEntity().getContent();
				result = StringUtil.streamToString(input);
				System.out.println("请求失败 ===== 响应数据如下: ");
				System.out.println(result);				
			}
			flag = true;
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		return flag;
	}

	/**
	 * 
	 * 描述: 文件上传
	 * 
	 * @author qye.zheng
	 * @return
	 */
	public static final boolean upload()
	{
		boolean flag = false;
		String result = null;

		HttpClient httpClient = null;

		HttpGet httpGet = null;

		HttpPost httpPost = null;

		HttpRequest request = null;

		HttpResponse response = null;

		OutputStream output = null;

		InputStream input = null;

		URL serverUrl = null;

		HttpURLConnection httpUrlConn = null;
		try
		{
			/**
			 * org.apache.http.client.HttpClient
			 * 
			 * 通过 HttpClientBuilder 来构建HttpClient 对象
			 * 
			 * DefaultHttpClient 等实现对象已经过时，不推荐使用
			 */
			httpClient = HttpClientBuilder.create().build();
			// http get 实例
			httpPost = new HttpPost(param.getRequestUrl());
			if (!EmptyUtil.isEmpty(param.getAccepts()))
			{
				for (String accept : param.getAccepts())
				{
					httpPost.addHeader(HttpDebugParam.HEADER_ACCEPT, accept);
				}
			}
			response = httpClient.execute(httpPost);

			if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode())
			{
				// 成功响应 200 ok
				input = response.getEntity().getContent();
				result = StringUtil.streamToString(input);
				System.out.println("请求成功 ===== 响应数据如下: ");
				System.out.println(result);
			} else
			{
				// 请求失败
				input = response.getEntity().getContent();
				result = StringUtil.streamToString(input);
				System.out.println("请求失败 ===== 响应数据如下: ");
				System.out.println(result);				
			}
			flag = true;
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return flag;
	}
	
	/**
	 * 
	 * 描述: 
	 * @author  qye.zheng
	 * @return
	 */
	public static final boolean download()
	{
		boolean flag = false;
		String result = null;

		HttpClient httpClient = null;

		HttpGet httpGet = null;

		HttpPost httpPost = null;

		HttpRequest request = null;

		HttpResponse response = null;

		OutputStream output = null;

		InputStream input = null;

		URL serverUrl = null;

		HttpURLConnection httpUrlConn = null;
		try
		{
			/**
			 * org.apache.http.client.HttpClient
			 * 
			 * 通过 HttpClientBuilder 来构建HttpClient 对象
			 * 
			 * DefaultHttpClient 等实现对象已经过时，不推荐使用
			 */
			httpClient = HttpClientBuilder.create().build();
			// http get 实例
			httpGet = new HttpGet(param.getRequestUrl());
			if (!EmptyUtil.isEmpty(param.getAccepts()))
			{
				for (String accept : param.getAccepts())
				{
					httpGet.addHeader(HttpDebugParam.HEADER_ACCEPT, accept);
				}
			}
			response = httpClient.execute(httpGet);

			if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode())
			{
				// 成功响应 200 ok
				input = response.getEntity().getContent();
				result = StringUtil.streamToString(input);
				System.out.println("请求成功 ===== 响应数据如下: ");
				System.out.println(result);
			} else
			{
				// 请求失败
				input = response.getEntity().getContent();
				result = StringUtil.streamToString(input);
				System.out.println("请求失败 ===== 响应数据如下: ");
				System.out.println(result);				
			}
			flag = true;
			flag = true;
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return flag;
	}
	
	/**
	 * 可以启动器中设置requestData等参数
	 * @return the param
	 */
	public static final HttpDebugParam getParam()
	{
		return param;
	}

	/**
	 * 
	 * 描述: 
	 * @author  qye.zheng
	 * @return
	 */
	public static final boolean template()
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
	
}
