package com.greatlearning.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.greatlearning.config.CustomUserDetails;
import com.greatlearning.entity.User;
import com.greatlearning.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired 
	UserRepository userRepository;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("Cannot find user!");
		}
		return new CustomUserDetails(user);
		
		// Logic needs to written to fetch from the database.
		// User user = new User("admin", "admin@123", new ArrayList<>());
		// return new MyUserDetails(user);
	}

}
