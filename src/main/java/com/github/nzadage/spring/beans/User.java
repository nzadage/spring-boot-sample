package com.github.nzadage.spring.beans;
import java.util.Collection;
import java.util.Collections;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "USERS")
public class User implements UserDetails{

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "username", nullable = false, unique = true)
	private String username;
	
	@Column(name = "password", nullable = false, unique = false)
	private String password;
	
	@Column(name = "account_non_expired")
	private Boolean accountNonExpired;
	
	@Column(name = "enabled")
	private Boolean enabled;
	
	
//	private Set<? extends GrantedAuthority> authorities;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1189282248866155629L;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.EMPTY_SET;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return "<protected>";
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

}
