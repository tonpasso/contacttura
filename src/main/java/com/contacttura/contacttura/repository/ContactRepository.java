package com.contacttura.contacttura.repository;

import org.springframework.data.repository.CrudRepository;

import com.contacttura.contacttura.entities.Contact;

public interface ContactRepository extends CrudRepository<Contact, Integer> {

}
