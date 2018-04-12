/**
 * 描述: 
 * XstreamTest.java
 * @author qye.zheng
 * 
 *  version 1.0
 */
package com.hua.test.xml;

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

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.hua.entity.xml.Address;
import com.hua.entity.xml.BillingAddress;
import com.hua.entity.xml.Customer;
import com.hua.entity.xml.PrimaryAddress;
import com.hua.test.BaseTest;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.HierarchicalStreamDriver;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * 描述: 
 * @author qye.zheng
 * 
 * XstreamTest
 */
public final class XstreamTest extends BaseTest
{
	
	/**
	 
	 无论是 转成xml还是json，统一是 XStream.toXML()方法，
	 没有toJson()方法
	 
	 json/xml --> bean 统一使用 XStream.fromXML()方法，没有fromJson()方法.
	 
	 */
	
	/**
	 * 
	 * 描述: javabean --> xml
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testBeanToXml() {
		try {
			/** begin 组装bean */
			Customer customer = new Customer();
			customer.setId("5646761321324132");
			customer.setFirstname("guanghua");
			customer.setLastname("li");
			customer.setGender("male");
			customer.setPhoneNumber("021-564697654");
			
			Address address = new Address();
			List<PrimaryAddress> primaryAddresses = new ArrayList<PrimaryAddress>();
			List<BillingAddress> billingAddresses = new ArrayList<BillingAddress>();
			PrimaryAddress pa = new PrimaryAddress();
			pa.setPostalCode("524211");
			pa.setAddressLine("广东省广州市天河区平云路526号");
			primaryAddresses.add(pa);
			BillingAddress ba = new BillingAddress();
			ba.setReceiver("王某人");
			ba.setPostalCode("5679851");
			ba.setAddressLine("广东省广州市天河区开泰路158号");
			billingAddresses.add(ba);
			address.setBillingAddresses(billingAddresses);
			address.setPrimaryAddresses(primaryAddresses);
			
			customer.setAddress(address);
			
			/** end of 组装bean */
			
			// 使用 xstream 实施转换 (bean --> xml)
			
			// 无参方式
			XStream xstream = new XStream();
			
			// 有参方式 DomDriver 为参数
			// 传入某一 DomDriver 实例，如 XppDomDriver、JDomDriver、Dom4JDriver
			// DomDriver 为 jdk  默认的 xml 驱动
			// final HierarchicalStreamDriver driver = new DomDriver();
			//XStream xstream = new XStream(driver);
			
			/**
			 * 结果显示类似
			 <com.hua.entity.xml.Customer>
  				<id>5646761321324132</id>
  			根节点使用了类的全限定名，可以使用别名来解决
			
			 */
			
			// 解决 对象节点使用类全限定名
			
			xstream.alias("customer", Customer.class);
			xstream.alias("primaryAddress", PrimaryAddress.class);
			xstream.alias("billingAddress", BillingAddress.class);
			
			// 输出为字符串
			resultXml = xstream.toXML(customer);
			
			// 输出流的方式
			//xstream.toXML(customer, out/writer);
			
			System.out.println(resultXml);
			
			
		} catch (Exception e) {
			log.error("testBeanToXml =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: xml --> javabean
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testXmlToBean() {
		try {
			// 使用 bean --> xml 的结果值
			testBeanToXml();
			targetXml = resultXml;
			// 无参方式 (使用无参的方式无法实现 xml --> bean，需要使用一个驱动)
			//XStream xstream = new XStream();
			
			// 使用DomDriver 驱动来实现
			final HierarchicalStreamDriver driver = new DomDriver();
			XStream xstream = new XStream(driver);
			
			/**
			 * 目标xml类似
			 <com.hua.entity.xml.Customer>
  				<id>5646761321324132</id>
  			根节点使用了类的全限定名，可以使用别名来解决
			
			 */
			
			// 解决 对象节点使用类全限定名 (解决某些节点识别问题)
			xstream.alias("customer", Customer.class);
			xstream.alias("primaryAddress", PrimaryAddress.class);
			xstream.alias("billingAddress", BillingAddress.class);
			Customer customer = (Customer) xstream.fromXML(targetXml);
			
			log.info("testXmlToBean =====> " + customer.getAddress().getBillingAddresses().get(0).getAddressLine());
			
		} catch (Exception e) {
			log.error("testXmlToBean =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: javabean --> json
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testBeanToJson() {
		try {
			/** begin 组装bean */
			Customer customer = new Customer();
			customer.setId("5646761321324132");
			customer.setFirstname("guanghua");
			customer.setLastname("li");
			customer.setGender("male");
			customer.setPhoneNumber("021-564697654");
			
			Address address = new Address();
			List<PrimaryAddress> primaryAddresses = new ArrayList<PrimaryAddress>();
			List<BillingAddress> billingAddresses = new ArrayList<BillingAddress>();
			
			PrimaryAddress pa = new PrimaryAddress();
			pa.setPostalCode("524211");
			pa.setAddressLine("广东省广州市天河区平云路526号");
			primaryAddresses.add(pa);
			
			BillingAddress ba = new BillingAddress();
			ba.setReceiver("王某人");
			ba.setPostalCode("5679851");
			ba.setAddressLine("广东省广州市天河区开泰路158号");
			billingAddresses.add(ba);
			
			address.setPrimaryAddresses(primaryAddresses);
			address.setBillingAddresses(billingAddresses);
			
			customer.setAddress(address);
			
			/** end of 组装bean */
			
			// 使用 xstream 实施转换 (bean --> xml)
			
			
			// 有参方式 DomDriver 为参数
			// 传入某一 DomDriver 实例，如 XppDomDriver、JDomDriver、Dom4JDriver
			// DomDriver 为 jdk  默认的 xml 驱动
			// bean --> json 使用一个json驱动
			final HierarchicalStreamDriver driver = new JsonHierarchicalStreamDriver();
			XStream xstream = new XStream(driver);
			
			/**
			 * 结果显示类似
			 <com.hua.entity.xml.Customer>
  				<id>5646761321324132</id>
  			根节点使用了类的全限定名，可以使用别名来解决
			
			 */
			
			// 解决 对象节点使用类全限定名
			// 除了根节点，其他的都使用属性名作为节点名
			xstream.alias("customer", Customer.class);
			//xstream.alias("primaryAddress", PrimaryAddress.class);
			//xstream.alias("billingAddress", BillingAddress.class);
			
			// 输出为字符串
			resultJson = xstream.toXML(customer);
			
			// 输出流的方式
			//xstream.toXML(customer, out/writer);
			
			System.out.println(resultJson);
			
		} catch (Exception e) {
			log.error("testBeanToJson =====> ", e);
		}
	}
	
	/**
	 * 
	 * warning: JettisonMappedXmlDriver 无法将map / list 类型转成相应的bean
	 * 描述: json --> javabean
	 * @author qye.zheng
	 * 
	 */
	@Test
	@Ignore
	public void testJsonToBean() {
		try {
			// 使用 bean --> json 的结果值
			testBeanToJson();
			targetJson = resultJson;
			// json --> bean 使用一个json驱动
			final HierarchicalStreamDriver driver = new JettisonMappedXmlDriver();
			XStream xstream = new XStream(driver);
			
			/**
			 JettisonMappedXmlDriver 无法将map / list 类型转成相应的bean
			 这种复杂的Json --> bean 可以使用 Gson 或 Jackson 框架
			 */
			
			// 解决 对象节点使用类全限定名
			// 除了根节点，其他的都使用属性名作为节点名
			xstream.alias("customer", Customer.class);
			//xstream.alias("primaryAddress", PrimaryAddress.class);
			//xstream.alias("billingAddress", BillingAddress.class);
			
			Customer customer = (Customer) xstream.fromXML(targetJson);
			
			log.info("testJsonToBean =====> " + customer.getId());
			
		} catch (Exception e) {
			log.error("testJsonToBean =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 读取xml (文件/流的方式)
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testReadXml() {
		try {
			
			
		} catch (Exception e) {
			log.error("testReadXml =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 输出xml (文件/流的方式)
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testWriteXml() {
		try {
			
			
		} catch (Exception e) {
			log.error("testWriteXml =====> ", e);
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
