package com.activa.programa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.security.core.SpringSecurityMessageSource;

@SpringBootApplication
public class ProgramaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgramaApplication.class, args);
	}

}
