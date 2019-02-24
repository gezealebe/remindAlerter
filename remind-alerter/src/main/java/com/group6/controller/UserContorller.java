package com.group6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.group6.model.User;
import com.group6.service.UserService;

@Controller
public class UserContorller {
	
	@Autowired
	public UserService userService;
	 @RequestMapping("/")
	 public String mainPage() {
	     System.out.println(" going to the home page");
		 return "home";
	 }
	 
	 @RequestMapping(value="/register", method=RequestMethod.GET)
	 public ModelAndView registerPage() {
		  ModelAndView model = new ModelAndView();
		  
		  User user = new User();
		  model.addObject("userForm", user);
		  
		  model.setViewName("registration");
		  return model; 
	 }  

	 @RequestMapping(value="/users", method=RequestMethod.GET)
	 @ResponseBody
	 public List<User> getUsers() {  		   
		  return userService.getListOfUser(); 
	 } 
	 
	 @RequestMapping(value="/register/user", method=RequestMethod.POST)        
	 public ModelAndView registerUser(@ModelAttribute("userForm") User user) {
 
		  userService.saveUser(user); 
	  return new ModelAndView("redirect:/");
	  
	 }	 
	 
	 @RequestMapping(value="/login", method=RequestMethod.GET)
	 public String login() {
 
	  return "login";
	 }
}
