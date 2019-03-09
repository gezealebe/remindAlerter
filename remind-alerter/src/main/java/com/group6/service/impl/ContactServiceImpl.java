package com.group6.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group6.model.Contact;
import com.group6.model.User;
import com.group6.repository.ContactRepository;
import com.group6.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService{

	@Autowired
	private ContactRepository contactRepository;
	@Override
	public Contact getContact(String personName, String type, String userId) { 
		return contactRepository.findContactByName(personName, type, userId);
	}

	@Override
	public Contact saveContact(Contact contact, String userId) { 
		contact.setUserId(userId);
		Contact c = contactRepository.save(contact);		 
		return c;
	}

	@Override
	public List<Contact> getListOfContacts(String userName) { 
		return contactRepository.getListOfContacts(userName);
	}

	@Override
	public Contact getContactById(Long id) {
		// TODO Auto-generated method stub
		return contactRepository.getOne(id);
	}

	@Override
	public void deleteContactById(Long id) {
		contactRepository.deleteById(id);
		
	}

}
