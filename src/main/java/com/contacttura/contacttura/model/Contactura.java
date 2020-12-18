package com.contacttura.contacttura.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Cria automaticamente um construtor com todos os atributos da classe como argumento.
@AllArgsConstructor
//Cria automaticamente um construtor vazio (sem argumentos)
@NoArgsConstructor
//Cria automaticamente os métodos toString, equals, hashCode, getters e setters.
@Data
@Entity
public class Contactura {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String email;
	private String phone;

}
