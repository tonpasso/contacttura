package com.contacttura.contacttura.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contacttura.contacttura.model.ContacturaUser;
import com.contacttura.contacttura.repository.ContacturaUserRepository;

@RestController
@RequestMapping({"/user"})
public class ContacturaUserController {
	
	@Autowired
	private ContacturaUserRepository repository;
	
//	@Autowired
//	private PasswordEncoder passwordEncoder;
	
		
//	List All
//  http://localhost:8090/user
	@GetMapping
	public List findAll() {
		return repository.findAll();
	}
	
//	List by Id
//  http://localhost:8090/user/5
	@GetMapping(value = "{id}")
	public ResponseEntity findById(@PathVariable long id) {
		return repository.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
//	Create
//  http://localhost:8090/user
	@PostMapping
	public ContacturaUser createUser(@RequestBody ContacturaUser contacturaUser) {		
		return repository.save(contacturaUser);
	}
	
//	Update
//  http://localhost:8090/user/5
	@PutMapping(value = "{id}")
	public ResponseEntity update(@PathVariable("id") long id, @RequestBody ContacturaUser contacturaUser) {
		return repository.findById(id)
				.map(record -> {
					record.setUsername(contacturaUser.getUsername());
					record.setPassword(contacturaUser.getPassword());
					record.setName(contacturaUser.getName());
					ContacturaUser update = repository.save(record);
					return ResponseEntity.ok().body(update);
				}).orElse(ResponseEntity.notFound().build());		
	}
	
//	Delete
//  http://localhost:8090/user/4
	@DeleteMapping(path = {"/{id}"})
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity <?> delete(@PathVariable long id){
		return repository.findById(id)
				.map(record -> {
					repository.deleteById(id);
					return ResponseEntity.ok().build();
				}).orElse(ResponseEntity.notFound().build());
	}

}
