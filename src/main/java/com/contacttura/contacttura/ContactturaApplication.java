package com.contacttura.contacttura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.contacttura.contacttura.model.Contactura;
import com.contacttura.contacttura.repository.ContacturaRepository;

@SpringBootApplication
public class ContactturaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactturaApplication.class, args);
	}
	
	
//	@Bean
//	CommandLineRunner init(ContacturaRepository repository) {
//		return args -> {
//			O delete é opcional			
//			repository.deleteAll();
//			LongStream.range(1, 11)
//			.mapToObj( i -> {
//				Contactura c = new Contactura();
//				c.setName("Contactura User " + i);
//				c.setEmail("contactura" + i + "@gmail.com");
//				c.setPhone("(081) 9" + i + i + i + i + "-" + i + i + i + i);
//				return c;
//			})
//			.map(m -> repository.save(m))
//			.forEach(System.out::println);
//		};			
//	}	
	
	@Bean
	public CommandLineRunner run(@Autowired ContacturaRepository contacturaRepository) {
		
		return args -> {
			Contactura contact = Contactura.builder()
									.name("Wellington Passo")
									.email("ton@gmail.com")
									.phone("(81) 99999-8888")
									.build();
			contacturaRepository.save(contact);
		};
	}

}

