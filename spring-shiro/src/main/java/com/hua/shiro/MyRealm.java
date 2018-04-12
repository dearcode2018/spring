/**
  * @filename MyRealm.java
  * @description  
  * @version 1.0
  * @author qye.zheng
 */
package com.hua.shiro;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.hua.entity.User;

 /**
 * @type MyRealm
 * @description  
 * @author qye.zheng
 */
public final class MyRealm extends AuthorizingRealm
{

	/**
	 * @description 鉴权 (通过验证用户名和密码来进行鉴别，
	 * 当前帐号是否有权限访问该系统)
	 * @param authcToken
	 * @return
	 * @throws AuthenticationException
	 * @author qye.zheng
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException
	{
		System.out.println("鉴权开始 -- MyRealm.doGetAuthenticationInfo()");
		// 用户名-密码token
		final UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		final String username = token.getUsername();
		
		// 模仿从数据看中查询出数据 (模拟，只允许指定的帐号访问)
		User user = new User();
		user.setUsername("admin");
		user.setPassword("123456");
		user.setNickname("ZS");
		// 简单鉴权信息
		SimpleAuthenticationInfo info = null;
		if (user.getUsername().equals(username))
		{
			if (user.getPassword().equals(new String(token.getPassword())))
			{
				// 简单鉴权信息
				info = new SimpleAuthenticationInfo(user.getUsername(), 
						user.getPassword(), user.getNickname());
			} else
			{
				System.out.println("密码不正确!");
			}
		} else
		{
			System.out.println("用户名不正确!");
		}
		
		return info;
	}
	
	/**
	 * @description 授权 (通过判断当前用户的角色以及权限，判断当前用户
	 * 是否有权限访问该资源)
	 * @param principals
	 * @return
	 * @author qye.zheng
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals)
	{
		System.out.println("授权开始 -- MyRealm.doGetAuthorizationInfo()");
		// 简单鉴权信息
		final SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		// 获取当前登录的用户名
		final String username = (String) super.getAvailablePrincipal(principals);
		
		System.out.println("当前登录用户名: " + username);
		
		// 角色(模拟 - 不到数据库去获取)
		List<String> roles = new ArrayList<String>();
		// 更当前用户设置角色
		roles.add("admin");
		roles.add("normal");
		
		// 权限
		List<String> permissions = new ArrayList<String>();
		/**
		 * 与在spring-shiro.xml 配置的权限名称相同
		 * /api/sys/listUser**=authc,perms["admin1:manage1,admin2:mange2"]	
		 */
		permissions.add("admin1:manage1");
		permissions.add("admin2:manage2");
		
		permissions.add("manage2");
		permissions.add("manage");
		
		// 可以配置为直接访问某个资源
		permissions.add("/views/login-div.html");
		
		// 给当前用户设置角色
		info.addRoles(roles);
		//给当前用户设置权限
		info.addStringPermissions(permissions);
		
		return info;
	}

}
