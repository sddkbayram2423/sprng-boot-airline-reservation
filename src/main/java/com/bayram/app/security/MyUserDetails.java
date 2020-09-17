package com.bayram.app.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.bayram.app.model.Role;
import com.bayram.app.model.User;


public class MyUserDetails implements UserDetails{
	
	private static final long serialVersionUID = 1L;
	
	private User user;

	public MyUserDetails(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		List<Role> roles= user.getRoles();
		
		List<SimpleGrantedAuthority> authorities=new ArrayList<>();
		
		if(roles!=null) {
			for (Role role : roles) {
				authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
			}
		}
		return authorities;
	}

	@Override
	public String getPassword() {
	 
		return user.getPassword();
	}

	@Override
	public String getUsername() {
	 
		return user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
	 
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
	 
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
	 
		return true;
	}

	@Override
	public boolean isEnabled() {
	 
		return user.isActive();
	}

}
