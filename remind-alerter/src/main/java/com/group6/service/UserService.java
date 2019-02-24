package com.group6.service;

import java.util.List;

import org.springframework.stereotype.Component; 

import com.group6.model.User;

@Component
public interface UserService {

	public void saveUser(User user);
	
	public User getUser(String userName);
	
	public List<User> getListOfUser();
}
