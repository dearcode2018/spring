/**
  * @filename CastorOXM.java
  * @description  
  * @version 1.0
  * @author qye.zheng
 */
package com.hua.oxm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.oxm.XmlMappingException;

import com.hua.bean.xml.Customer;
import com.hua.util.ClassPathUtil;
import com.hua.util.IOUtil;
import com.hua.util.ProjectUtil;


 /**
 * @type CastorOXM
 * @description  
 * @author qye.zheng
 */
public final class CastorOXM extends BaseOXM {

	/**
	 * @description 
	 * @return
	 * @author qye.zheng
	 */
	@Override
	public final Customer toBean() {
		InputStream inputStream = null;
		Customer bean = null;
		try {
			inputStream = new FileInputStream(ProjectUtil.getAbsolutePath(getInPath(), true));
			// 构建来源对象
			final Source source = new StreamSource(inputStream);
			bean = (Customer) getUnmarshaller().unmarshal(source);
		} catch (FileNotFoundException e) {
			log.error("toBean =====> ", e);
		} catch (XmlMappingException e) {
			log.error("toBean =====> ", e);
		} catch (IOException e) {
			log.error("toBean =====> ", e);
		} finally
		{ // 关闭流
			IOUtil.close(inputStream);
		}
		
		return bean;
	}

	/**
	 * @description 
	 * @author qye.zheng
	 */
	@Override
	public final void toXML() {
		OutputStream outputStream = null;
		try {
			outputStream = new FileOutputStream(ProjectUtil.getAbsolutePath(getOutPath(), true)
				+ "/castor-customer.xml");
			// 构建结果对象
			final Result result = new StreamResult(outputStream);
			// 执行编组
			getMarshaller().marshal(getBean(), result);
			outputStream.flush();
		} catch (FileNotFoundException e) {
			log.error("toXML =====> ", e);
		} catch (XmlMappingException e) {
			log.error("toXML =====> ", e);
		} catch (IOException e) {
			log.error("toXML =====> ", e);
		} finally
		{ // 关闭流
			IOUtil.close(outputStream);
		}
	}
	
	
}
