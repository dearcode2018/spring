/**
  * @filename BaseOXM.java
  * @description  
  * @version 1.0
  * @author qye.zheng
 */
package com.hua.oxm;

import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;

import com.hua.bean.xml.Customer;
import com.hua.log.BaseLog;

 /**
 * @type BaseOXM
 * @description  
 * @author qye.zheng
 */
public abstract class BaseOXM extends BaseLog {

	/* 标准 Java Bean */
	private Customer bean;
	
	/* 编组器 */
	private Marshaller marshaller;
	
	/* 解组器 */
	private Unmarshaller unmarshaller;
	
	/* xml文档 输入路径 */
	private String inPath;
	
	/** xml文档 输出路径 */
	private String outPath;
	
	/**
	 * @return the marshaller
	 */
	public final Marshaller getMarshaller() {
		return marshaller;
	}

	/**
	 * @param marshaller the marshaller to set
	 */
	public final void setMarshaller(Marshaller marshaller) {
		this.marshaller = marshaller;
	}

	/**
	 * @return the unmarshaller
	 */
	public final Unmarshaller getUnmarshaller() {
		return unmarshaller;
	}

	/**
	 * @param unmarshaller the unmarshaller to set
	 */
	public final void setUnmarshaller(Unmarshaller unmarshaller) {
		this.unmarshaller = unmarshaller;
	}
	
	/**
	 * @return the bean
	 */
	public final Customer getBean() {
		return bean;
	}

	/**
	 * @param bean the bean to set
	 */
	public final void setBean(Customer bean) {
		this.bean = bean;
	}

	/**
	 * 
	 * @description xml 转换成 bean
	 * @return
	 * @author qye.zheng
	 */
	public abstract Customer toBean();
	
	/**
	 * 
	 * @description xml 转换成 bean
	 * @return
	 * @author qye.zheng
	 */
	public abstract void toXML();

	/**
	 * @return the inPath
	 */
	public final String getInPath() {
		return inPath;
	}

	/**
	 * @param inPath the inPath to set
	 */
	public final void setInPath(String inPath) {
		this.inPath = inPath;
	}

	/**
	 * @return the outPath
	 */
	public final String getOutPath() {
		return outPath;
	}

	/**
	 * @param outPath the outPath to set
	 */
	public final void setOutPath(String outPath) {
		this.outPath = outPath;
	}

}
