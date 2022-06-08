package com.stagproj.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.stagproj.bank.repository")
public class BankApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
	}

}
//		***************************
//		APPLICATION FAILED TO START
//		***************************
//
//		Description:
//
//		Field _contaRepository in com.stagproj.bank.controller.ContaController required a bean named 'entityManagerFactory' that could not be found.
//
//		The injection point has the following annotations:
//		- @org.springframework.beans.factory.annotation.Autowired(required=true)
//
//
//		Action:
//
//		Consider defining a bean named 'entityManagerFactory' in your configuration.
//
//
//		Process finished with exit code 1