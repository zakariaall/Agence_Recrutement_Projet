package com.workify.agence_recrut;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.workify.agence_recrut.entites")
public class AgenceRecrutApplication {
	public static void main(String[] args) {

		SpringApplication.run(AgenceRecrutApplication.class, args);
	}

}
