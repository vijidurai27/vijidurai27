package com.Smart.service;

import java.util.List;

import com.Smart.entity.Contact;
import com.Smart.entity.User;

public interface ContactService  {
	
	
	public  void addContact(Contact contact);
	
	public List<Contact> displayAllContact();
	
	

	void deleteByContactId(int cid);

	public Contact findByContactId(int cid);
	
	
	}
