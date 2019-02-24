package com.group6.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group6.model.User;
import com.group6.repository.UserRepository;
import com.group6.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	public UserRepository userRepository;
	
	@Override
	public void saveUser(User user) {		
		if (user != null) {
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

}
