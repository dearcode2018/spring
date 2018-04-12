/**
 * CompositeType.java
 * @author  qye.zheng
 * 	version 1.0
 */
package com.hua.bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * CompositeType
 * 描述: 
 * @author  qye.zheng
 */
public final class CompositeType
{
	private String[] array;
	
	private List<Integer> list;
	
	private Set<String> set;
	
	private Map<String, Integer> map;
	
	private Properties props;

	/**
	 * 构造方法
	 * 描述: 
	 * @author  qye.zheng
	 */
	public CompositeType()
	{
	}

	/**
	 * @return the array
	 */
	public String[] getArray()
	{
		return array;
	}

	/**
	 * @param array the array to set
	 */
	public void setArray(String[] array)
	{
		this.array = array;
	}

	/**
	 * @return the list
	 */
	public List<Integer> getList()
	{
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(List<Integer> list)
	{
		this.list = list;
	}

	/**
	 * @return the set
	 */
	public Set<String> getSet()
	{
		return set;
	}

	/**
	 * @param set the set to set
	 */
	public void setSet(Set<String> set)
	{
		this.set = set;
	}

	/**
	 * @return the map
	 */
	public Map<String, Integer> getMap()
	{
		return map;
	}

	/**
	 * @param map the map to set
	 */
	public void setMap(Map<String, Integer> map)
	{
		this.map = map;
	}

	/**
	 * @return the props
	 */
	public Properties getProps()
	{
		return props;
	}

	/**
	 * @param props the props to set
	 */
	public void setProps(Properties props)
	{
		this.props = props;
	}
	
	/**
	 * 描述: 
	 * @author  qye.zheng
	 * @return
	 */
	@Override
	public String toString()
	{
		final String result = new ReflectionToStringBuilder(this).toString();
		
		return result;
	}
}
