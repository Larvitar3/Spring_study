package com.example.demo;

import javax.servlet.annotation.ServletSecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@ServletSecurity
public class SpringFilterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringFilterApplication.class, args);
	}

}
