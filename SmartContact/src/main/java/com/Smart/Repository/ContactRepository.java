package com.Smart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Smart.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer>

{
	
}

   

