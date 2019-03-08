package com.group6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.group6.model.Login;
import com.group6.model.User;
import com.group6.service.UserService;

@Controller
public class UserContorller {
	
	@Autowired
	public UserService userService;
	/* @RequestMapping("/")
	 public String mainPage() { 
		 return "list";
	 } */
	 
	 @RequestMapping("/err")
	 public String errorPage() { 
		 return "error";
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
	 public ModelAndView registerUser(@ModelAttribute("userForm")  User user,
			 final BindingResult bindingResult, Model model) {
		 User userExist = userService.getUser(user.getUserName());
		 if (userExist == null) {
			  userService.saveUser(user); 
			  return new ModelAndView("redirect:/");
		 }  
		 
		 model.addAttribute("error", "The user name exist");
		return new ModelAndView("redirect:/register");
	 }	 
	 
	 @RequestMapping(value="/login/user", method=RequestMethod.POST)        
	 public ModelAndView login(@ModelAttribute("login") Login user, ModelMap map) {
 
		 map.addAttribute("error", "Wrong username and/or password"); 
		 userService.loginUser(user.getUserName(), user.getUserName()); 
		 
	  return new ModelAndView("redirect:/");
	  
	 }		
	 
	 @RequestMapping(value="/login", method=RequestMethod.GET)
	 public ModelAndView loginPage() {
		 
	 /*   if (SecurityContextHolder.getContext().getAuthentication() != null &&
				 SecurityContextHolder.getContext().getAuthentication().isAuthenticated() ) {
		  return new ModelAndView("redirect:/");
	      } */
		  ModelAndView model = new ModelAndView();
		  
		  Login user = new Login();
		  model.addObject("login", user);		  
		  model.setViewName("login");
		  return model; 
	 }  
}
