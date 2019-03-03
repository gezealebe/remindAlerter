package com.group6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.group6.model.Contact; 
import com.group6.service.UserService;

@Controller
public class ContactController {

	@Autowired
	public UserService userService;
	
	@RequestMapping(value="/addreminder", method=RequestMethod.GET)
	public ModelAndView addPage() { 
		  ModelAndView model = new ModelAndView();
		  
		  Contact contact = new Contact();
		  model.addObject("addForm", contact);
		  
		  model.setViewName("add");
		  return model; 
	}
	
	@RequestMapping(value="/editreminder", method=RequestMethod.GET)
	public String editPage() { 
		 /* ModelAndView model = new ModelAndView();
		  
		  Contact contact = new Contact();
		  model.addObject("addForm", contact);
		  
		  model.setViewName("add");*/
		  return "edit"; 
	}
	
	@RequestMapping(value="/deletereminder", method=RequestMethod.GET)
	public String deletePage() { 
		 /* ModelAndView model = new ModelAndView();
		  
		  Contact contact = new Contact();
		  model.addObject("addForm", contact);
		  
		  model.setViewName("add");*/
		  return "delete"; 
	}
}
