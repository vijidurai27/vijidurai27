package com.Smart.controller;

import org.springframework.stereotype.*;

import java.security.Principal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.Smart.Repository.ContactRepository;
import com.Smart.Repository.UserRepository;
import com.Smart.entity.Contact;
import com.Smart.entity.User;
import com.Smart.helper.Message;
import com.Smart.service.*;

@Controller
public class HomeController {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PersonService personService;
	
	@Autowired
	private ContactService contactService;
	
	@ModelAttribute
	public void addCommonData() {
		
	}
	
	
	
	@GetMapping("/base")
	public String base() {
		return "base";
		
	}
	
	
	@GetMapping("/home")
	public String home(Model model)
	{
		
		model.addAttribute("title","Home-Smart Contact Manager");
		
		return "home";
		
	}
	
	@GetMapping("/about")
	public String about(Model model)
	{
		
		model.addAttribute("title","About-Smart Contact Manager");
		
		return "about";
		
	}
	
	
	
	
	
	@RequestMapping("/signup")
	public String signup(@ModelAttribute User user, Model model)
	{
		//contactService.addContact(user);
		model.addAttribute("title","Register-Smart Contact Manager");
		model.addAttribute("user",new User());
		
		return "signup";
	}
	
	
	@RequestMapping(value="/do_register", method = RequestMethod.POST)
   public String do_register(@Valid @ModelAttribute("user") User user,
			   @RequestParam(value = "agreement",
			   defaultValue = "false")
	           boolean agreement, Model model, HttpSession session )
	
	     {
     try   {
			
	     if(!agreement) 
		 {		   
		    System.out.println("You have not agreed the terms and conditions");
		    throw new Exception("You have not agreed the terms and conditions");	
		}
			  
			user.setUserRole("Role_User");
			user.setUserEnabled(true);
			user.setUserImageUrl("default.png");
			
			
			System.out.println("Agreement" + agreement);
			System.out.println("User"+ user);
			
			User result = this.userRepository.save(user);
			
			model.addAttribute("user",user);
			
			
			session.setAttribute("message", new Message("Successfully Registered!!", "alert-success"));
		
			return "signup";
}
		
		catch(Exception e)
		{
			
			e.printStackTrace();
			model.addAttribute("user",user);
			session.setAttribute("message", new Message("Error occured"+(e),"alert-danger"));
			
		}

		return "signup";		
	}
	

	@GetMapping("/signin")
	public String customLogin(Model model) 
	{
		model.addAttribute("title","Login Page");
		return "login";
		
	}
	
	@GetMapping("/userlogin")
	public String login(Model model)
	{
		model.addAttribute("title","Dashboard");
		return "userlogin";
		
	}
	
	@PostMapping("/dashboard")
	public String Dashboard(Model model)
	{
		model.addAttribute("title","Dashboard- Smart Contact Manager");
		return "dashboard";
		
	}
	
	@PostMapping("/userloginCheck")
	  public String userloginCheck(@ModelAttribute User user,Model model,HttpSession session)
	  {
		String view="";
		  try
		  {
		    User user1= personService.findByUserEmailAndUserPassword(user.getUserEmail(), user.getUserPassword());
		    
		    System.out.println(user1);
		  //  model.addAttribute("login", user1);
		    if(user1==null)
		    {
		    	  view= "userlogin";
		    }
		    else
		    {
		    	session.setAttribute("userEmail", user.getUserEmail());
		    	view= "dashboard";
		    	
		    }
		  }
		 
		  catch(Exception e) {
			  
			  System.out.println( e);
		  }
		  finally
		  {
			    return view;
		  }
	  }
	
	
	
	
	@GetMapping("/dashboard1")
	public String Dashboard1(Model model)
	{
		model.addAttribute("title","Dashboard- Smart Contact Manager");
		return "dashboard";
		
	} 
	
	
	

	
	
	 
}
