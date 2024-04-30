package com.example.academicsappjdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.academicsappjdbc"})
public class AcademicsappjdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcademicsappjdbcApplication.class, args);
	}

}
