package com.example.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.example.demo.entity.User;
import com.example.demo.repository.AdminRepository;

@Component
public class AuthUtil {
	
	@Autowired
	AdminRepository adminRepository;
	
	public Long loggedInUserId() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null || !authentication.isAuthenticated()) {
            throw new RuntimeException("User is not authenticated");
        }
		
		User user = adminRepository.findByuserName(authentication.getName())
				.orElseThrow(() -> new RuntimeException("User not found"));
		
		return user.getUserId();
	
	}
	
	public User loggedInUserUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null || !authentication.isAuthenticated()) {
            throw new RuntimeException("User is not authenticated");
        }
		
		User user = adminRepository.findByuserName(authentication.getName())
				.orElseThrow(() -> new RuntimeException("User not found"));
		
		return user;
	
	}
	
}
