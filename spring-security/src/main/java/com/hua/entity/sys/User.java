/**
 * 描述: 
 * User.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.entity.sys;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.hua.entity.BaseEntity;

/**
 * 
 * @type User
 * @description 
 * @author qye.zheng
 */
@SuppressWarnings({"serial"})
// 实现了 org.springframework.security.core.userdetails.UserDetails，
//暂时在业务bean中耦合框架(在设计上并不推荐，这里只是便于研究)
public final class User extends BaseEntity implements UserDetails {
	
	/* 昵称 (用于显示) */
	private String nickname;
	
	/* 用户类型 */
	private String type;
	
	/* 用户状态 - 是否有效 默认 : 有效(ON) 无效(OFF) */
	private String status;
	
	/*
	 * spring UserDetails 相关属性
	 */
	
	/* 登录-用户名 (唯一) */
	private String username;
	
	/* 登录-密码 */
	private String password;
	
	/* 帐号是否有权限 1-有, 0无 */
	private boolean enabled;
	
	/* 帐户是否 没过期 */
	private boolean accountNonExpired;
	
	/* 帐户是否 没锁定 */
	private boolean accountNonLocked;
	
	/* 证书是否 没过期 */
	private boolean credentialsNonExpired;
	
	/* 授权集合 */
	private Collection<? extends GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	
	/** 无参构造方法 */
	public User() {}

	/**
	 * @return the username
	 */
	@Override
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	@Override
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * @return the nickname
	 */
	public String getNickname()
	{
		return nickname;
	}

	/**
	 * @param nickname the nickname to set
	 */
	public void setNickname(String nickname)
	{
		this.nickname = nickname;
	}

	/**
	 * @return the status
	 */
	public final String getStatus()
	{
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public final void setStatus(String status)
	{
		this.status = status;
	}

	/**
	 * @param enabled the enabled to set
	 */
	public final void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * @description 
	 * @return
	 * @author qye.zheng
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	/**
	 * @description 
	 * @return
	 * @author qye.zheng
	 */
	@Override
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	/**
	 * @description 
	 * @return
	 * @author qye.zheng
	 */
	@Override
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	/**
	 * @description 
	 * @return
	 * @author qye.zheng
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	/**
	 * @description 
	 * @return
	 * @author qye.zheng
	 */
	@Override
	public boolean isEnabled() {
		
		return enabled;
	}

	/**
	 * @param accountNonExpired the accountNonExpired to set
	 */
	public final void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	/**
	 * @param accountNonLocked the accountNonLocked to set
	 */
	public final void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	/**
	 * @param credentialsNonExpired the credentialsNonExpired to set
	 */
	public final void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	/**
	 * @param authorities the authorities to set
	 */
	public final void setAuthorities(
			Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	
}
