package com.contacttura.contacttura.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.contacttura.contacttura.entities.Contact;
import com.contacttura.contacttura.repository.ContactRepository;

@RestController
@RequestMapping("/api/contact")
public class ContactController {
	
	@Autowired
	private ContactRepository contactRepository;
	
	@PostMapping
	public Contact novoContact(@RequestParam String name, String email, String phone) {
		Contact contact = new Contact(name, email, phone);
		contactRepository.save(contact);
		return contact;
	}

}
