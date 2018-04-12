/**
 * 描述: 
 * SpringFileUploadTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.spring;

// 静态导入
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.hua.test.BaseTest;
import com.hua.util.ClassPathUtil;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * SpringFileUploadTest
 */
public final class SpringFileUploadTest extends BaseTest {

	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testFileUpload() {
		try {
			String testUrl = "http://127.0.0.1:8080/spring-file/api/file/upload/v10";
			
			/*StringHttpMessageConverter messageConverter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
			List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
			messageConverters.add(messageConverter);*/
			
			ResourceHttpMessageConverter messageConverter = new ResourceHttpMessageConverter();
			List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
			messageConverters.add(messageConverter);
			
			//final RestTemplate restTemplate = new RestTemplate(messageConverters);
			
			final RestTemplate restTemplate = new RestTemplate();
			
			/*
			 * 文件路径中含有中文会导致 中文乱码
			 * 
			 */
			//	FileSystemResource resource = new FileSystemResource(new File(ClassPathUtil.getClassSubpath("/file/img/白熊_01.jpg", true)));  
			String path = ClassPathUtil.getClassSubpath("/file/img/白熊_01.jpg", true);
			//path = URLEncoder.encode(path, Constant.CHART_SET_UTF_8);
			//path = URLDecoder.decode(path, Constant.CHART_SET_UTF_8);
			FileSystemResource resource = new FileSystemResource(path);  
			//InputStreamResource resource = new InputStreamResource(new FileInputStream(path));  
			log.info("testFileUpload =====> path = " + path);
			log.info("testFileUpload =====> filename = " + resource.getFilename());
			//	FileSystemResource resource = new FileSystemResource(new File(ClassPathUtil.getClassSubpath("/file/img/cat.jpg", true)));  
			// 请求头
			MultiValueMap<String, Object> param = new LinkedMultiValueMap<String, Object>();
			param.add("file", resource);
			//param.add("Content-Type", "form-data;charset=ISO-8859-1");
			/*
				Content-Disposition: form-data; name="file"; filename="??_01.jpg"
				Content-Type: image/jpeg
				Content-Length: 135769
			 */
			//param.add("Content-Disposition", "form-data; name=\"file\";filename=\"abc.png\"");
			param.add("Content-Disposition", "attachment; filename=\"abc.png\"");	
			
			//request.setCharacterEncoding("utf-8"); response.setCharacterEncoding("utf-8"); 
			
			
			//headers.add("Content-type", "multipart/form-data");
			//headers.add("fileName", "文件名_hha.png");
			// 响应实体
			String result = restTemplate.postForObject(testUrl, param, String.class);
			
			// 响应数据
			System.out.println("响应数据");
			System.out.println(result);
			
		} catch (Exception e) {
			log.error("testSpringHttpClient =====> ", e);
		}
	}	
	
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSpringHttpClient() {
		try {
			
			String testUrl = "http://127.0.0.1:8080/servlet3/TestServlet";
			// 构造请求对象
			RestTemplate restTemplate = new RestTemplate();
			// 请求头
			MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
			headers.add("Content-Type", "application/json; charset=UTF-8");
			headers.add("Accept", "application/json; charset=UTF-8");
			String json = "{\"id\":\"20150709\"}";
			// 请求实体
			HttpEntity<String> httpEntity = new HttpEntity<String>(json, headers);
			// 响应实体
			ResponseEntity<String> responseEntity = restTemplate.exchange(testUrl, HttpMethod.POST, httpEntity, String.class);
			
			// 响应数据
			String result = responseEntity.getBody();
			System.out.println("响应数据");
			System.out.println(result);
			
		} catch (Exception e) {
			log.error("testSpringHttpClient =====> ", e);
		}
	}	
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testHttpPostByForm() {
		try {
			
			String testUrl = "http://127.0.0.1:8080/servlet3/TestServlet";
			StringHttpMessageConverter messageConverter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
			List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
			messageConverters.add(messageConverter);
			RestTemplate restWebServiceTemplate = new RestTemplate(messageConverters);
			// 请求头
			MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
			headers.add("Content-Type", "application/json; charset=UTF-8");
			headers.add("Accept", "application/json; charset=UTF-8");
			//String json = "{\"id\":\"20150709\"}";
			// 请求实体
			HttpEntity<String> httpEntity = new HttpEntity<String>("", headers);
			// 响应实体
			ResponseEntity<String> responseEntity = restWebServiceTemplate.exchange(testUrl, HttpMethod.POST, httpEntity, String.class);
			// 响应数据
			String result = responseEntity.getBody();
			System.out.println("响应数据");
			System.out.println(result);
			
		} catch (Exception e) {
			log.error("testHttpPostByForm =====> ", e);
		}
	}		
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void test() {
		try {
			
			
		} catch (Exception e) {
			log.error("test =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testTemp() {
		try {
			
			
		} catch (Exception e) {
			log.error("testTemp=====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testCommon() {
		try {
			
			
		} catch (Exception e) {
			log.error("testCommon =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSimple() {
		try {
			
			
		} catch (Exception e) {
			log.error("testSimple =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testBase() {
		try {
			
			
		} catch (Exception e) {
			log.error("testBase =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 解决ide静态导入消除问题 
	 * @author qye.zheng
	 * 
	 */
	@Ignore("解决ide静态导入消除问题 ")
	private void noUse() {
		String expected = null;
		String actual = null;
		Object[] expecteds = null;
		Object[] actuals = null;
		String message = null;
		
		assertEquals(expected, actual);
		assertEquals(message, expected, actual);
		assertNotEquals(expected, actual);
		assertNotEquals(message, expected, actual);
		
		assertArrayEquals(expecteds, actuals);
		assertArrayEquals(message, expecteds, actuals);
		
		assertFalse(true);
		assertTrue(true);
		assertFalse(message, true);
		assertTrue(message, true);
		
		assertSame(expecteds, actuals);
		assertNotSame(expecteds, actuals);
		assertSame(message, expecteds, actuals);
		assertNotSame(message, expecteds, actuals);
		
		assertNull(actuals);
		assertNotNull(actuals);
		assertNull(message, actuals);
		assertNotNull(message, actuals);
		
		assertThat(null, null);
		assertThat(null, null, null);
		
		fail();
		fail("Not yet implemented");
		
	}

}
