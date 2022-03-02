package com.Smart.service;

import com.Smart.entity.User;

public interface PersonService
{
    public User findByUserEmailAndUserPassword(String userEmail,String userPassword);
 
	
	public void saveUserDetail(User user);
	
	
	
  

}

