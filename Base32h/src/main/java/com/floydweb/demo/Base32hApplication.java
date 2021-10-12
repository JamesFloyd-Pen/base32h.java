package com.floydweb.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Base32hApplication {

	public static void main(String[] args) {
		SpringApplication.run(Base32hApplication.class, args);
		System.out.print("Hello!");
	}

}
