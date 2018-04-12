/**
  * @filename UserServiceImpl.java
  * @description  
  * @version 1.0
  * @author qye.zheng
 */
package com.hua.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.hua.entity.sys.User;
import com.hua.service.impl.CoreServiceImpl;

 /**
 * @type UserServiceImpl
 * @description  
 * @author qye.zheng
 */
// org.springframework.security.core.userdetails.UserDetailsService
public final class MyUserDetailsService extends CoreServiceImpl 
	implements UserDetailsService
{

	/**
	 * @description 通过 用户名 加载 用户详情
	 * @param username
	 * @return
	 * @throws UsernameNotFoundException
	 * @author qye.zheng
	 */
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		// 构造授权对象
		GrantedAuthority adminAuth = new SimpleGrantedAuthority("ROLE_ADMIN");
		User user = null;
		// 置入授权对象
		auths.add(adminAuth);
		
		/**
		 * 可以从数据库中获取 用户的详细信息，这里是模仿从数据库中
		 * 获取数据
		 */
		if ("admin".equals(username))
		{
			user = new User();
			user.setUsername(username);
			user.setPassword("123456");
			user.setAccountNonExpired(true);
			user.setAccountNonLocked(true);
			// 设置授权集合
			user.setAuthorities(auths);
			user.setEnabled(true);
			user.setCredentialsNonExpired(true);
			user.setNickname("管理员");
			user.setStatus("ON");
		}
		
		return user;
	}
}
