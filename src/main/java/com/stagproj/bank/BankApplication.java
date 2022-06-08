package com.stagproj.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
	}

}
//
//	Error starting ApplicationContext. To display the conditions report re-run your application with 'debug' enabled.
//		2022-06-08 09:42:12.240 ERROR 6436 --- [           main] o.s.b.d.LoggingFailureAnalysisReporter   :
//
//		***************************
//		APPLICATION FAILED TO START
//		***************************
//
//		Description:
//
//		Field _contaRepository in com.stagproj.bank.controller.ContaController required a bean of type 'com.stagproj.bank.repository.ContaRepository' that could not be found.
//
//		The injection point has the following annotations:
//		- @org.springframework.beans.factory.annotation.Autowired(required=true)
//
//
//Action:
//
//		Consider defining a bean of type 'com.stagproj.bank.repository.ContaRepository' in your configuration.
//
//
//		Process finished with exit code 1
//
