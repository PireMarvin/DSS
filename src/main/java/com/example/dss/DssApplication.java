package com.example.dss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DssApplication {
	public DssApplication() {
		System.out.println("test");
	}

	public static void main(String[] args) {
		SpringApplication.run(DssApplication.class, args);
	}

}
