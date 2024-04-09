package com.jbk.SimpleProjectRestApl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
@EntityScan
@SpringBootApplication
public class SimpleProjectRestAplApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleProjectRestAplApplication.class, args);
		System.out.println("Application Start.........");
	}

}
