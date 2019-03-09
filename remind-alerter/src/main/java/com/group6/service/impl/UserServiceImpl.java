package com.group6.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.group6.model.User;
import com.group6.repository.UserRepository;
import com.group6.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	public UserRepository userRepository;
	
    @Autowired
    private UserDetailsService userDetailsService;
	
	@Autowired
	public AuthenticationManager authenticationManager;
	
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public void saveUser(User user) {		
		if (user != null) {
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			userRepository.save(user);
		}
	}

	@Override
	public User getUser(String userName) { 
		return userRepository.findUserByName(userName);
	}

	@Override
	public List<User> getListOfUser() { 
		List<User> users = userRepository.findAll();
		return users;
	}
	
    @Override
    public void loginUser(String username, String password) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());

        authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        if (usernamePasswordAuthenticationToken.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken); 
            System.out.println("***** login was successful for user with ! - username - " + username);
        }
    }

}
