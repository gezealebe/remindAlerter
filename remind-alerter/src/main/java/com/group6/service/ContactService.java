package com.group6.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.group6.model.Contact;
import com.group6.model.User; 

@Component
public interface ContactService {

	public Contact getContact(String personName, String type, String userId );
	public Contact saveContact(Contact contact, String userId);
	public List<Contact> getListOfContacts(String userName);
	public Contact getContactById(Long id);
	public void deleteContactById(Long id);
}
