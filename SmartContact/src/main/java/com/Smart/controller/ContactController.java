package com.Smart.controller;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.Smart.Repository.ContactRepository;
import com.Smart.Repository.UserRepository;
import com.Smart.entity.Contact;
import com.Smart.service.ContactService;

@Controller
public class ContactController {

@Autowired	
private ContactRepository contactRepository;	
	

	@Autowired
	private ContactService contactService;
	
	
	@PostMapping("/processContact")
	public String addContact(@ModelAttribute Contact contact,Model model)
	{
		contactService.addContact(contact);
		model.addAttribute(contact);
		
		return "processContact";
		
		
	}
	
	@GetMapping("/addContact")
	public String AddContactForm(Model model)
	{
		model.addAttribute("title","Add Contact");
		model.addAttribute("contact",new Contact());
		return "addContact";
	}
	
	
	/*
	 * @GetMapping("/viewContact") public String viewContact(Model model) {
	 * model.addAttribute("title","Your Contacts List"); List<Contact> list =
	 * contactService.displayAllContact(); model.addAttribute("contact", list);
	 * System.out.println(list); return "viewContact"; }
	 */
	
	@GetMapping("/myProfile")
	public String myProfile(Model model) 
	{
		model.addAttribute("title","My Profile");
		return "myProfile";
	}
	
	
	//"@{'/Contact'+${session.userEmail}}"
	/* @GetMapping("'/viewContact'+${session.userEmail}") */
	@GetMapping("/viewContact")
	public String viewContact2(Model model)
	{
		
		
		model.addAttribute("title","Add Contact");
       List<Contact>  list =  contactService.displayAllContact();
		/* contactService.findByContactId(0); */
		model.addAttribute("contact", list);
		System.out.println(list);
		return "viewContact2";
	}
	
	@GetMapping("/settings")
	public String settings(Model model) 
	{
		model.addAttribute("title","Settings");
		return "settings";
	}
	
	@GetMapping("/deletecontact{cid}")
	private String delete(@PathVariable int cid, Model model) 
	{
		
		Contact contact  = contactService.findByContactId(cid);
		
		if(contact!=null)
		{
			   contactService.deleteByContactId(cid);
			    List<Contact> list =  contactService.displayAllContact();
				model.addAttribute("contact", list);
		}
		
		return"viewContact2";
	
	}
	
	@GetMapping("/updateContact{cid}")
	private String update(@PathVariable int cid, @ModelAttribute Contact contact, Model model,HttpSession session) 
	{
		model.addAttribute(model);
		session.setAttribute("contactid", cid);
		Contact contactupdate  =contactService.findByContactId(cid);
		
		if(contactupdate!=null)
		{
			model.addAttribute("contact",contactupdate);
		}
		else
		{
			model.addAttribute("contact",new Contact());
		}
		return"updateContact";
	}

}
