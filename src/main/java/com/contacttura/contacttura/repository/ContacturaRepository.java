package com.contacttura.contacttura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.contacttura.contacttura.model.Contactura;

//interfacee que estende a interface JpaRepository (do Spring Data) facilitando,
//pois não precisa criar todo o DAO, que já vem abstraido

@Repository
public interface ContacturaRepository extends JpaRepository<Contactura, Long> {

}
