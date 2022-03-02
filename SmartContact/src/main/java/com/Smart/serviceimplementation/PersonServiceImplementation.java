package com.Smart.serviceimplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Smart.Repository.UserRepository;
import com.Smart.entity.User;
import com.Smart.service.PersonService;

@Service
public class PersonServiceImplementation implements PersonService
{

	@Autowired
	UserRepository userRepository;

	@Override
	public void saveUserDetail(User user)
	{
		 userRepository.save(user);
		
	}
	
    @Override
	public User findByUserEmailAndUserPassword(String userEmail, String userPassword) {
		
	       return userRepository.findByUserEmailAndUserPassword(userEmail, userPassword);
	}

}
