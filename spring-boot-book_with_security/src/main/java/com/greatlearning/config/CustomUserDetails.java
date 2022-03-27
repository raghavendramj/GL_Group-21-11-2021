package com.greatlearning.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.greatlearning.entity.Role;
import com.greatlearning.entity.User;

public class CustomUserDetails implements UserDetails {

	private static final long serialVersionUID = 1L;

	public CustomUserDetails(User user) {
		super();
		this.user = user;
	}

	private User user;

	public Collection<? extends GrantedAuthority> getAuthorities() {
		// Later we'll modify this add actual roles and its authorities..
		// return new ArrayList<>();
		
		List<Role> roles = user.getRoles();
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		for (Role eachRole : roles) {
			authorities.add(new SimpleGrantedAuthority(eachRole.getRolename()));
		}
		return authorities;
	}

	public String getPassword() {
		return user.getPassword();
	}

	public String getUsername() {
		return user.getUsername();
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return true;
	}
}
