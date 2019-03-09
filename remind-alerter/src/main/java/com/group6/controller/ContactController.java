package com.group6.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.group6.model.Contact;
import com.group6.model.User;
import com.group6.service.ContactService;
import com.group6.service.UserService;

@Controller
public class ContactController {

	@Autowired
	public ContactService contactService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/addreminder", method=RequestMethod.GET)
	public ModelAndView addPage() { 
		  ModelAndView model = new ModelAndView();
		  
		  Contact contact = new Contact();
		  model.addObject("addForm", contact);
		  
		  model.setViewName("add");
		  return model; 
	}
	
	@RequestMapping(value="/editreminder/{id}", method=RequestMethod.GET)
	public ModelAndView editContact(@PathVariable("id") Long id) { 
		  ModelAndView model = new ModelAndView();
		   
		  Contact contact = contactService.getContactById(id);
		  model.addObject("editForm", contact);
		  
		  model.setViewName("edit");
		  return model; 
	}
	
	@RequestMapping(value="/editreminder", method=RequestMethod.POST)
	public ModelAndView saveContact(@ModelAttribute("editForm")  Contact contact,
			 final BindingResult bindingResult, Model model) {  
		  contactService.saveContact(contact, getCurrentUser()); 
		  return new ModelAndView("redirect:" +"remindalerter/home");
	}
	
	 @RequestMapping(value="/addreminder", method=RequestMethod.POST)          
	 public ModelAndView registerUser(@ModelAttribute("addForm")  Contact contact,
			 final BindingResult bindingResult, Model model) {
		 Contact contactExist = contactService.getContact(contact.getFirstName(), contact.getReminderTypes(), getCurrentUser());
		 if (contactExist == null) { 
			 contactService.saveContact(contact, getCurrentUser()); 
			 return new ModelAndView("redirect:/");
		 }  
		 
		 model.addAttribute("error", "The user name exist");
		return new ModelAndView("redirect:/addreminder");
	 }
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView editPage() { 
	   ModelAndView model = new ModelAndView();
		  
		List<Contact> contact = (List<Contact>) contactService.getListOfContacts(getCurrentUser());
		  model.addObject("reminder", contact);
		  
		  model.setViewName("reminder");
		  model.setViewName("list");
		  return model;  
	}
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public ModelAndView goHome() { 
	   ModelAndView model = new ModelAndView();
		  
		List<Contact> contact = (List<Contact>) contactService.getListOfContacts(getCurrentUser());
		  model.addObject("reminder", contact);
		  
		  model.setViewName("reminder");
		  model.setViewName("list");
		  return model;  
	}
	
	 @RequestMapping(value="/contacts", method=RequestMethod.GET)
	 @ResponseBody
	 public List<Contact> getUsers() {  		
		  return contactService.getListOfContacts(getCurrentUser()); 
	 } 

	
	@RequestMapping(value="/deletereminder/{id}", method=RequestMethod.GET)
	public ModelAndView deletePage(@PathVariable("id") Long id) { 
		   
		   contactService.deleteContactById(id); 
		  
		  return new ModelAndView("redirect:/home");
	}
	
	public String getCurrentUser() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = null;
		if (principal instanceof UserDetails) {
		   username = ((UserDetails)principal).getUsername();
		} else {
		   username = principal.toString();
		}
		return username;
	}


}
